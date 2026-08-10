package com.orto.logic.controller;

import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.Order;

import java.util.List;

public class PurchaseHistoryController {
    //won't implement this UC

    //METHODS
    public List<Order> getOrders() throws ConnectionException {
        DAOFactory factory = DAOFactory.getDAOFactory();
        List <Order> orders;
        orders = factory.getOrderDAO().getAllOrders();
        return orders;
    }
}
