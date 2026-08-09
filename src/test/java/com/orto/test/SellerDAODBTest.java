package com.orto.test;

import com.orto.logic.model.dao.SellerDAO;
import com.orto.logic.model.dao.db.SellerDAODB;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.utils.PersistenceType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SellerDAODBTest {

    @Test
    public void testSellerDAOFactoryDatabase() {
        DAOFactory factory = DAOFactory.getDAOFactory(PersistenceType.DATABASE);
        assertNotNull(factory);
        SellerDAO sellerDAO = factory.getSellerDAO();
        assertNotNull(sellerDAO);
        assertTrue(sellerDAO instanceof SellerDAODB);
    }

    @Test
    public void testGetAllSellersConnectionHandling() {
        SellerDAO sellerDAO = new SellerDAODB();
        try {
            List<Seller> sellers = sellerDAO.getAllSellers();
            assertNotNull(sellers);
        } catch (ConnectionException e) {
            assertNull(e);
        }
    }
}
