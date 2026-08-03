package com.orto.logic.model.dao.inmemory;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;

import java.util.HashMap;
import java.util.Map;

public class UserDAOMEM implements UserDAO {
    private static final Map <String, User> users = new HashMap<>();

    static {
        //Populating in-memory users
        // User 1
        users.put(
                "crisgius@gmail.com",
                new User(
                        1,
                        "cristiana",
                        "cristiana",
                        "giustiniani",
                        "$2a$10$T4E2mmeHfmmTkicnoQcCTebRptWMpX"));

        // User 2
        users.put(
                "dajeromadaje@gmail.com",
                new User(
                        2,
                        "robiforzaroma",
                        "roberta",
                        "lupi",
                        "$2a$10$T4E2mmeHfmmTkicnoQcCTebRptWMpX"));

        // User 3
        users.put(
                "maria6116@libero.it",
                new User(
                        3,
                        "maria61",
                        "marianna",
                        "sabatini",
                        "$2a$10$T4E2mmeHfmmTkicnoQcCTebRptWMpX"));
    }

    @Override
    public User getUser(String email, String password) throws WrongPasswordException {
        User user = users.get(email);
        if (user != null) {
            user.checkPassword(password);
            return user;
        }
    }

    @Override
    public void saveUser(User user, String email, String password) {

    }
}
