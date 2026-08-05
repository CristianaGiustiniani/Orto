package com.orto.logic.model.dao;

import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.entity.Order;

import java.util.List;

public interface OrderDAO {
    void createOrder(Order order) throws ConnectionException;
    List<Order> getAllOrders() throws ConnectionException;
}
