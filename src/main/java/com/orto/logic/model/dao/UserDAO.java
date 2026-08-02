package com.orto.logic.model.dao;

import com.orto.logic.model.entity.User;

public interface UserDAO {
    User getUser(String username, String password) throws Exception;
}
