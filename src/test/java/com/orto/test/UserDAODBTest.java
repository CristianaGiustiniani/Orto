package com.orto.test;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.db.UserDAODB;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.exceptions.WrongEmailException;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import com.orto.logic.utils.PersistenceType;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAODBTest {

    @Test
    public void testUserDAOFactoryDatabase() {
        DAOFactory factory = DAOFactory.getDAOFactory(PersistenceType.DATABASE);
        assertNotNull(factory);
        UserDAO userDAO = factory.getUserDAO();
        assertNotNull(userDAO);
        assertTrue(userDAO instanceof UserDAODB);
    }

    @Test
    public void testGetUserRightCredentials() {
        UserDAO userDAO = DAOFactory.getDAOFactory(PersistenceType.DATABASE).getUserDAO();
        try {
            User user = userDAO.getUser("crisgius@gmail.com", "orto");
            assertNotNull(user);
        } catch (WrongEmailException | WrongPasswordException | ConnectionException e) {
            assertNull(e);
        }
    }

    @Test
    public void testGetUserWrongPassword() {
        UserDAO userDAO = new UserDAODB();
        try {
            userDAO.getUser("crisgius@gmail.com", "wrongpassword");
        } catch (WrongEmailException | ConnectionException e) {
            assertNull(e);
        } catch (WrongPasswordException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testGetUserWrongEmail() {
        UserDAO userDAO = new UserDAODB();
        try {
            userDAO.getUser("nonexistent@orto.it", "orto");
        } catch (WrongEmailException e) {
            assertNotNull(e);
        } catch (WrongPasswordException | ConnectionException e) {
            assertNull(e);
        }
    }
}
