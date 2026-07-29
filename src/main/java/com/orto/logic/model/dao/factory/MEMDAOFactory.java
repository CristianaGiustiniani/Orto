package com.orto.logic.model.dao.factory;

import com.orto.logic.model.dao.SellerDAO;
import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.inmemory.SellerDAOMEM;
import com.orto.logic.model.dao.inmemory.UserDAOMEM;

public class MEMDAOFactory implements DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new UserDAOMEM();
    }
    @Override
    public SellerDAO getSellerDAO() { return new SellerDAOMEM(); }

}
