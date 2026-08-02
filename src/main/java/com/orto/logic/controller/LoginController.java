package com.orto.logic.controller;

import com.orto.logic.controller.exceptions.FailedLoginException;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.User;

public class LoginController extends Controller {
    public void login(String email, String password) throws Exception {
        DAOFactory factory;
        UserDAO userDAO;
        User user;

        factory = DAOFactory.getDAOFactory();
        userDAO = factory.getUserDAO();
        user = userDAO.getUser(email, password);

        if (user == null) {
            throw new FailedLoginException();
        }
    }

}
