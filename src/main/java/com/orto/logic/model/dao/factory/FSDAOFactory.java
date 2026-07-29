package com.orto.logic.model.dao.factory;

import com.orto.logic.model.dao.SellerDAO;
import com.orto.logic.model.dao.UserDAO;

public class FSDAOFactory implements DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return null;
    }

    @Override
    public SellerDAO getSellerDAO() {
        return null;
    }
}
