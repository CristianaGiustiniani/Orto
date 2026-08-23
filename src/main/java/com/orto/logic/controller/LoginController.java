package com.orto.logic.controller;

import com.orto.logic.model.dao.exceptions.*;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import com.orto.logic.utils.PersistenceType;
import com.orto.logic.utils.Session;


public class LoginController {
    public void login(String email, String password, boolean rememberUser) throws ConnectionException, WrongPasswordException, WrongEmailException {
        User user;

        user = DAOFactory.getDAOFactory().getUserDAO().getUser(email, password);
        Session.getInstance().setLoggedUser(user);

        if (rememberUser) {
            try {
                DAOFactory.getDAOFactory(PersistenceType.FILESYSTEM).getUserDAO().createUser(user, email, password);
            } catch (UsernameAlreadyExistsException | EmailAlreadyExistsException e) {
                //do nothing, as users.txt shall keep only one user info
            }
        }

    }

    public synchronized void tryAutologin() {
        try {
            User user = DAOFactory.getDAOFactory(PersistenceType.FILESYSTEM).getUserDAO().getUser();
            Session.getInstance().setLoggedUser(user);
        } catch (NoRememberedUserException | ConnectionException ignored) {
            //if autologin can't be performed, it does not matter
        }
    }

    public static void logout() throws ForgetUserException {
        Session.getInstance().logout();
        DAOFactory.getDAOFactory(PersistenceType.FILESYSTEM).getUserDAO().forgetUser();
    }

}
