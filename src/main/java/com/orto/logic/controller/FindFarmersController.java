package com.orto.logic.controller;

import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.Seller;

import java.util.List;

public class FindFarmersController extends Controller {
    //METHODS
    public List<Seller> getFarmers() throws ConnectionException {
        DAOFactory factory = DAOFactory.getDAOFactory();
        List <Seller> sellers;
        sellers = factory.getSellerDAO().getAll();
        return sellers;
    }
}
