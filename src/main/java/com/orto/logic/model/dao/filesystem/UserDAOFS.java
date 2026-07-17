package com.orto.logic.model.dao.filesystem;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.entity.User;

public class UserDAOFS implements UserDAO {
    @Override
    public User verifyUser(String username, String password) {
        return null;
    }

    @Override
    public void saveUser(User user) throws Exception {

    }
}
