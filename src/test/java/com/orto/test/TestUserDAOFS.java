package com.orto.test;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.entity.User;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;

import com.orto.logic.model.dao.filesystem.UserDAOFS;

public class TestUserDAOFS {
    @Test
    public void testCreateUser() throws Exception {
        Path usersFile = Files.createTempFile("test-users-", ".txt");
        try {
            UserDAO userDAO = new UserDAOFS(usersFile);
            assertNotNull(userDAO);
            User user = new User(0, "testUsername", "test", "test");
            userDAO.createUser(user, "test@test.it", "orto");
            User retrieved = userDAO.getUser("test@test.it", "orto");
            assertNotNull(retrieved);
            assertEquals("testUsername", retrieved.getUsername());
        } finally {
            Files.deleteIfExists(usersFile);
        }
    }
}