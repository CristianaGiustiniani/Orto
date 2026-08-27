package com.orto.logic.controller;

import com.orto.logic.model.dao.exceptions.*;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import com.orto.logic.utils.*;
import com.orto.logic.utils.exceptions.IllegalNullUserException;

import java.util.Objects;

public class LoginController {
    private final SessionManager sessionManager;

    public LoginController() {
        this(SessionManager.getInstance());
    }
    public LoginController(SessionManager sessionManager) {
        this.sessionManager = Objects.requireNonNull(sessionManager);
    }

    public String login(String email, String password, boolean rememberUser) throws ConnectionException, WrongPasswordException, WrongEmailException {
        User user;
        String sessionId;

        user = DAOFactory.getDAOFactory().getUserDAO().getUser(email, password);
        sessionId = sessionManager.createSession(user);

        if (rememberUser && !Configuration.getInstance().getMode().equals(Mode.DEMO)) {
            try {
                DAOFactory.getDAOFactory(PersistenceType.FILESYSTEM).getUserDAO().createUser(user, email, password);
            } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
                //do nothing, as users.txt shall keep track of multiple sessions
            }
        }

        return sessionId;
    }

    public synchronized void tryAutologin() {
        if (Configuration.getInstance().getMode().equals(Mode.DEMO)) {
            return;
        }

        try {
            User user = DAOFactory.getDAOFactory(PersistenceType.FILESYSTEM).getUserDAO().getUser();
            sessionManager.createSession(user);
        } catch (NoRememberedUserException | ConnectionException ignored) {
            //if autologin can't be performed, it does not matter
        }
    }

    public void logout() throws ForgetUserException {
        logout(sessionManager.getCurrentSessionId());
    }
    public void logout(String sessionId) throws ForgetUserException {
        Session session = sessionManager.getSession(sessionId);
        sessionManager.removeSession(sessionId);
        if (session != null && !sessionManager.hasActiveSessionForUser(session.getUser())) {
            DAOFactory.getDAOFactory(PersistenceType.FILESYSTEM).getUserDAO().forgetUser(session.getUser());
        }
    }

    public String getLoggedUserUsername() throws IllegalNullUserException {
        return sessionManager.getLoggedUser().getUsername();
    }
}
