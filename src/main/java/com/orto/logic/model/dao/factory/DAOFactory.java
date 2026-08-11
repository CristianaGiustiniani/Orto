package com.orto.logic.model.dao.factory;

import com.orto.logic.model.dao.OrderDAO;
import com.orto.logic.model.dao.ProductDAO;
import com.orto.logic.model.dao.SellerDAO;
import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.utils.Configuration;
import com.orto.logic.utils.PersistenceType;

public interface DAOFactory {
    static DAOFactory getDAOFactory() {
        switch (Configuration.getInstance().getMode()) {
            case DEMO:
                return new MEMDAOFactory();
            case FULL: default:
                return new DBDAOFactory();
        }
    }
    static DAOFactory getDAOFactory(PersistenceType type) {
        switch (type) {
            case INMEMORY:
                return new MEMDAOFactory();
            case FILESYSTEM:
                return new FSDAOFactory();
            case DATABASE: default:
                return new DBDAOFactory();
        }
    }


    UserDAO getUserDAO();
    SellerDAO getSellerDAO();
    OrderDAO getOrderDAO();
    ProductDAO getProductDAO();


}
