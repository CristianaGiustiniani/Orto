package com.orto.logic.model.dao.inmemory;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOMEM implements UserDAO {
    private static final List<User> userTable = new ArrayList<>();
    @Override
    public User getUser(String username, String password) {
        for (User user : userTable) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Login successful
            }
        }
        return null; // Login failed
    }

    //todo: populate entries
}
