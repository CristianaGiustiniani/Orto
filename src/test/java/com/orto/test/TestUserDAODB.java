package com.orto.test;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.db.UserDAODB;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.exceptions.EmailAlreadyExistsException;
import com.orto.logic.model.dao.exceptions.UsernameAlreadyExistsException;
import com.orto.logic.model.dao.exceptions.WrongEmailException;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.security.crypto.bcrypt.BCrypt;

class TestUserDAODB {
    /**
     * Tests for the UserDAODB class
     *
     * @author Cristiana Giustiniani
     */

    @Test
    void testGetUserRightId() throws WrongEmailException, ConnectionException, WrongPasswordException {
        UserDAO userDAO = new UserDAODB();
        User existingUser = new User(
                1,
                "cristiana",
                "cristiana",
                "giustiniani");
        User retrievedUser = userDAO.getUser("crisgius@gmail.com", "orto");
        assertEquals(existingUser.getId(), retrievedUser.getId());
    }

    @Test
    void testGetUserRightUsername() throws WrongEmailException, ConnectionException, WrongPasswordException {
        UserDAO userDAO = new UserDAODB();
        User existingUser = new User(
                1,
                "cristiana",
                "cristiana",
                "giustiniani");
        User retrievedUser = userDAO.getUser("crisgius@gmail.com", "orto");
        assertEquals(existingUser.getUsername(), retrievedUser.getUsername());
    }

    @Test
    void testGetUserWrongPassword() throws WrongEmailException, ConnectionException {
        UserDAO userDAO = new UserDAODB();
        try {
            userDAO.getUser("crisgius@gmail.com", "wrongpassword");
        } catch (WrongPasswordException e) {
            assertNotNull(e);
        }
    }

    @Test
    void testGetUserWrongEmail() throws ConnectionException, WrongPasswordException {
        UserDAO userDAO = new UserDAODB();
        try {
            userDAO.getUser("nonexistent@orto.it", "orto");
        } catch (WrongEmailException e) {
            assertNotNull(e);
        }
    }

    @Test
    void testCreateUserUsernameAlreadyExists() throws EmailAlreadyExistsException, ConnectionException {
        UserDAO userDAO = new UserDAODB();
        try {
            userDAO.createUser(
                    new User(
                            "cristiana",
                            "nome",
                            "cognome"),
                    "newemail",
                    BCrypt.hashpw("orto", BCrypt.gensalt()));
        } catch (UsernameAlreadyExistsException e) {
            assertNotNull(e);
        }
    }

    @Test
    void testCreateUserEmailAlreadyExists() throws UsernameAlreadyExistsException, ConnectionException {
        UserDAO userDAO = new UserDAODB();
        try {
            userDAO.createUser(
                    new User(
                            "newusername",
                            "nome",
                            "cognome"),
                    "crisgius@gmail.com",
                    BCrypt.hashpw("orto", BCrypt.gensalt()));
        } catch (EmailAlreadyExistsException e) {
            assertNotNull(e);
        }
    }
}
