package com.orto.test;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.User;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.orto.logic.utils.PersistenceType.FILESYSTEM;

public class TestUserDAOFS {
    private static final String USERS_FILE = "users.txt";
    private static final String BACKUP_FILE = "users_backup.txt";

    @BeforeEach
    public void backupUsersFile() throws Exception {
        Path original = Paths.get(USERS_FILE);
        if (Files.exists(original)) {
            Files.copy(original, Paths.get(BACKUP_FILE), StandardCopyOption.REPLACE_EXISTING);
        }
        Files.deleteIfExists(original);
    }

    @AfterEach
    public void restoreUsersFile() throws Exception {
        Path backup = Paths.get(BACKUP_FILE);
        Path original = Paths.get(USERS_FILE);
        Files.deleteIfExists(original);
        if (Files.exists(backup)) {
            Files.move(backup, original, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    @Test
    public void testCreateUser() throws Exception {
        UserDAO userDAO = DAOFactory.getDAOFactory(FILESYSTEM).getUserDAO();
        assertNotNull(userDAO);
        //Create user
        User user = new User(0, "testUsername", "test", "test");
        userDAO.createUser(user, "test@test.it", "orto");
        //Get user
        User retrieved = userDAO.getUser("test@test.it", "orto");
        assertNotNull(retrieved);
        assertEquals("testUsername", retrieved.getUsername());
    }
}
