package com.orto.logic.model.dao.factory;

import com.orto.logic.model.dao.OrderDAO;
import com.orto.logic.model.dao.ProductDAO;
import com.orto.logic.model.dao.SellerDAO;
import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.db.ProductDAODB;
import com.orto.logic.model.dao.inmemory.OrderDAOMEM;
import com.orto.logic.model.dao.inmemory.ProductDAOMEM;
import com.orto.logic.model.dao.inmemory.SellerDAOMEM;
import com.orto.logic.model.dao.inmemory.UserDAOMEM;

public class MEMDAOFactory implements DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new UserDAOMEM();
    }
    @Override
    public SellerDAO getSellerDAO() { return new SellerDAOMEM(); }
    @Override
    public OrderDAO getOrderDAO() {
        return new OrderDAOMEM();
    }
    @Override
    public ProductDAO getProductDAO() {
        return new ProductDAOMEM();
    }

}
