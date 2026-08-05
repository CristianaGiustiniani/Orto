package com.orto.logic.model.dao.factory;

import com.orto.logic.model.dao.OrderDAO;
import com.orto.logic.model.dao.ProductDAO;
import com.orto.logic.model.dao.SellerDAO;
import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.filesystem.UserDAOFS;

public class FSDAOFactory implements DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new UserDAOFS();
    }
    @Override
    public SellerDAO getSellerDAO() {
        return null;
    }
    @Override
    public OrderDAO getOrderDAO() {
        return null;
    }
    @Override
    public ProductDAO getProductDAO() {
        return null;
    }
}
