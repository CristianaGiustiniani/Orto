package com.orto.logic.model.dao.factory;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.inmemory.UserDAOMEM;

public class MEMDAOFactory implements DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new UserDAOMEM();
    }
    //@Override
    //public UserDAO getCollectionDAO() {
    //    return new CollectionDAOMEM();
    //}
    //Poi da implementare per ogni DAO
}
