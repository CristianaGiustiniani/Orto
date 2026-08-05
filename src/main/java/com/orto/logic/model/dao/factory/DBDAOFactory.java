package com.orto.logic.model.dao.factory;

import com.orto.logic.model.dao.OrderDAO;
import com.orto.logic.model.dao.ProductDAO;
import com.orto.logic.model.dao.SellerDAO;
import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.db.OrderDAODB;
import com.orto.logic.model.dao.db.ProductDAODB;
import com.orto.logic.model.dao.db.SellerDAODB;
import com.orto.logic.model.dao.db.UserDAODB;

public class DBDAOFactory implements DAOFactory {
    @Override
    public UserDAO getUserDAO() { return new UserDAODB(); }
    @Override
    public SellerDAO getSellerDAO() {
        return new SellerDAODB();
    }
    @Override
    public OrderDAO getOrderDAO() {
        return new OrderDAODB();
    }
    @Override
    public ProductDAO getProductDAO() {
        return new ProductDAODB();
    }

}
