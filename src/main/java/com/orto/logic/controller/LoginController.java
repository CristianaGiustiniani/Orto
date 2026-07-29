package com.orto.logic.controller;

import com.orto.logic.controller.exceptions.FailedLoginException;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.User;
import com.orto.logic.view_controller.bean.LoginBean;

import static com.orto.logic.utils.PersistenceType.FILESYSTEM;

public class LoginController extends Controller {
    public void logIn(LoginBean loginBean) throws Exception {
        DAOFactory factory;
        UserDAO userDAO;
        User user;

        factory = DAOFactory.getDAOFactory(FILESYSTEM);
        userDAO = factory.getUserDAO();
        user = userDAO.verifyUser(loginBean.getUsername(), loginBean.getPassword());

        if (user == null) {
            throw new FailedLoginException();
        }
    }

}
