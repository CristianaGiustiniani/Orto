package com.orto.logic.controller;

import com.orto.logic.controller.exceptions.UserNotRememberedException;
import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.exceptions.ForgetUserException;
import com.orto.logic.model.dao.exceptions.NoRememberedUserException;
import com.orto.logic.model.dao.exceptions.WrongEmailException;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.dao.filesystem.UserDAOFS;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import com.orto.logic.utils.Session;

import java.io.File;

public class LoginController {
    public void login(String email, String password) throws ConnectionException, WrongPasswordException, WrongEmailException {
        UserDAO userDAO;
        User user;

        userDAO = DAOFactory.getDAOFactory().getUserDAO();
        user = userDAO.getUser(email, password);
        Session.getInstance().setLoggedUser(user);
    }

    public synchronized void tryAutologin() {
        try {
            User user = UserDAOFS.getUser();
            Session.getInstance().setLoggedUser(user);
        } catch (NoRememberedUserException | ConnectionException ignored) {
            //if autologin can't be performed, it does not matter
        }
    }

    public static void logout() throws ForgetUserException {
        Session.getInstance().logout();
        UserDAOFS.forgetUser();


    }

}
