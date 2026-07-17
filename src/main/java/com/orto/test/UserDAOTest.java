package com.collectible.test;

import com.collectible.logic.model.dao.factory.DAOFactory;
import com.collectible.logic.model.dao.UserDAO;
import com.collectible.logic.utils.PersistencyType;
import com.collectible.logic.model.entity.User;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class UserDAOTest {

    @Test
    void testSaveAndRetrieveUserInMemory() throws Exception {
        // 1. Get the InMemory Factory
        DAOFactory factory = DAOFactory.getDAOFactory(PersistencyType.INMEMORY);

        // 2. Get the DAO
        UserDAO userDAO = factory.getUserDAO();

        // 3. Create a dummy user
        User newUser = new User("testUser", "12345", "test@example.com");

        try {
            // 4. Test Saving
            userDAO.saveUser(newUser);

            // 5. Test Verification (Success case)
            User retrievedUser = userDAO.verifyUser("testUser", "12345");
            assertNotNull(retrievedUser, "User should be found.");
            assertEquals("testUser", retrievedUser.getUsername());

            // 6. Test Verification (Failure case - wrong password)
            User wrongPass = userDAO.verifyUser("testUser", "wrong");
            assertNull(wrongPass, "User should not be returned with wrong password.");

        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }
}
