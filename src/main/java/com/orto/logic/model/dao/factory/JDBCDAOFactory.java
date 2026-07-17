package com.orto.logic.model.dao.factory;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.jdbc.UserDAOJDBC;

public class JDBCDAOFactory implements DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        //codice JDBC
        //return new UserDAOJDBC();
        return null;
    }
}
