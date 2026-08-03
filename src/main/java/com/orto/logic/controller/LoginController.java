package com.orto.logic.controller;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.exceptions.WrongEmailException;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import com.orto.logic.utils.Session;

public class LoginController {
    public void login(String email, String password) throws ConnectionException, WrongPasswordException, WrongEmailException {
        DAOFactory factory;
        UserDAO userDAO;
        User user;

        userDAO = DAOFactory.getDAOFactory().getUserDAO();
        user = userDAO.getUser(email, password);
        Session.getInstance().setLoggedUser(user);
    }

    public static void logout() {
        Session.getInstance().logout();
        //todo: manage the remember me file system case

    }

}
