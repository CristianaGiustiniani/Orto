package com.orto.logic.controller;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.User;
import com.orto.logic.view_controller.bean.LoginBean;
import com.orto.logic.utils.PersistencyType;


import com.orto.logic.controller.exceptions.FailedSignUpException;

public class SignUpController {
    public void signUp(LoginBean loginBean) throws Exception {
        DAOFactory factory;
        UserDAO userDAO;
        User user;

        factory = DAOFactory.getDAOFactory(PersistencyType.FILESYSTEM);
        userDAO = factory.getUserDAO();
        user = userDAO.verifyUser(loginBean.getUsername(), loginBean.getPassword());

        if (user == null) {
            throw new FailedSignUpException();
        }
    }
}
