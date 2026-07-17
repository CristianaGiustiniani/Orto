package com.orto.logic.model.dao;

import com.orto.logic.model.entity.User;

public interface UserDAO {
    User verifyUser(String username, String password) throws Exception;
    void saveUser(User user) throws Exception;
}
