package com.orto.logic.model.dao.inmemory;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOMEM implements UserDAO {
    private static final List<User> userTable = new ArrayList<>();
    @Override
    public User verifyUser(String username, String password) {
        for (User user : userTable) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Login successful
            }
        }
        return null; // Login failed
    }

    @Override
    public void saveUser(User user) throws Exception {
        // Check for duplicates (simulating Primary Key constraint)
        for (User u : userTable) {
            if (u.getUsername().equals(user.getUsername())) {
                throw new Exception("Username already exists");
            }
            if (u.getEmail().equals(user.getEmail())) {
                throw new Exception("Email already exists");
            }
        }
        userTable.add(user);
    }
}
