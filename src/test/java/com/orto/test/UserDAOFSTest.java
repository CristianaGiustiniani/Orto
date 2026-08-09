package com.orto.test;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.orto.logic.utils.PersistenceType.FILESYSTEM;
import static org.junit.Assert.*;

public class UserDAOFSTest {
    private static final String USERS_FILE = "users.txt";
    private static final String BACKUP_FILE = "users_backup.txt";

    @Before
    public void backupUsersFile() throws Exception {
        Path original = Paths.get(USERS_FILE);
        if (Files.exists(original)) {
            Files.copy(original, Paths.get(BACKUP_FILE), StandardCopyOption.REPLACE_EXISTING);
        }
        Files.deleteIfExists(original);
    }

    @After
    public void restoreUsersFile() throws Exception {
        Path backup = Paths.get(BACKUP_FILE);
        Path original = Paths.get(USERS_FILE);
        Files.deleteIfExists(original);
        if (Files.exists(backup)) {
            Files.move(backup, original, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    @Test
    public void testUserDAOFS() throws Exception {
        UserDAO userDAO = DAOFactory.getDAOFactory(FILESYSTEM).getUserDAO();
        assertNotNull(userDAO);
        //Create user
        User user = new User("test", "test", "test");
        userDAO.createUser(user, "test@test.it", "orto");
        //Get user
        User retrieved = userDAO.getUser("test@test.it", "orto");
        assertNotNull(retrieved);
        assertEquals("test", retrieved.getUsername());
    }
}
