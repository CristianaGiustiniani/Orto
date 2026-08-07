package com.orto.logic.model.dao.inmemory;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.exceptions.EmailAlreadyExistsException;
import com.orto.logic.model.dao.exceptions.UsernameAlreadyExistsException;
import com.orto.logic.model.dao.exceptions.WrongEmailException;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserDAOMEM implements UserDAO {
    private static final Map <String, User> users = new HashMap<>();

    static {
        //Populating in-memory users
        final String hashedOrto = "$2a$10$T4E2mmeHfmmTkicnoQcCTebRptWMpX/EsSzZ53yD89uaYkWGDWgn6";
        // User 1
        users.put(
                "crisgius@gmail.com",
                new User(
                        "cristiana",
                        "cristiana",
                        "giustiniani",
                        hashedOrto));

        // User 2
        users.put(
                "dajeromadaje@gmail.com",
                new User(
                        "robiforzaroma",
                        "roberta",
                        "lupi",
                        hashedOrto));

        // User 3
        users.put(
                "maria6116@libero.it",
                new User(
                        "maria61",
                        "marianna",
                        "sabatini",
                        hashedOrto));
    }

    @Override
    public User getUser(String email, String password) throws WrongPasswordException, WrongEmailException {
        User user = users.get(email);
        if (user != null) {
            user.checkPassword(password);
            return user;
        }
        else {
            throw new WrongEmailException();
        }
    }

    @Override
    public void createUser(User user, String email, String password) throws EmailAlreadyExistsException, UsernameAlreadyExistsException {
        if (users.get(email) != null) {
            throw new EmailAlreadyExistsException();
        }
        for (User u: users.values()) {
            if (Objects.equals(u.getUsername(), user.getUsername())) {
                throw new UsernameAlreadyExistsException();
            }
        }
        users.put(
                email,
                new User(
                        user.getUsername(),
                        user.getName(),
                        user.getSurname(),
                        BCrypt.hashpw(password, BCrypt.gensalt())));

    }
}
