package com.orto.logic.model.dao.factory;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.utils.PersistencyType;


public interface DAOFactory {
    public abstract UserDAO getUserDAO();

    public static DAOFactory getDAOFactory(PersistencyType type) throws Exception {
        switch (type) {
            case INMEMORY:
                return new MEMDAOFactory();
            case FILESYSTEM:
                return new FSDAOFactory();
            case DATABASE:
                return new JDBCDAOFactory();
            default:
                throw new Exception("Unknown persistency");
        }
    }


}
