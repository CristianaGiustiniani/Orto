package com.orto.test;


import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.User;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

class UserDAOTest {
    @Test
    void testSaveAndRetrieveUserInMemory() throws Exception {
       /* // 1. Get the InMemory Factory
        DAOFactory factory = DAOFactory.getDAOFactory();

        // 2. Get the DAO
        UserDAO userDAO = factory.getUserDAO();

        // 3. Create a dummy user
        String email;
        String password;

        try {
            // 4. Test Saving
            userDAO.save(email, password);

            // 5. Test Verification (Success case)
            User retrievedUser = userDAO.getUser("testUser", "12345");
            assertNotNull("User should be found.", retrievedUser);
            assertEquals("testUser", retrievedUser.getUsername());

            // 6. Test Verification (Failure case - wrong password)
            User wrongPass = userDAO.getUser("testUser", "wrong");
            assertNull(wrongPass, "User should not be returned with wrong password.");

        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }*/
    }

}
