package com.orto.logic.model.dao.factory;

import com.orto.logic.model.dao.SellerDAO;
import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.db.SellerDAODB;
import com.orto.logic.model.dao.db.UserDAODB;

public class DBDAOFactory implements DAOFactory {
    @Override
    public UserDAO getUserDAO() { return new UserDAODB(); }
    @Override
    public SellerDAO getSellerDAO() {
        return new SellerDAODB();
    }
}
