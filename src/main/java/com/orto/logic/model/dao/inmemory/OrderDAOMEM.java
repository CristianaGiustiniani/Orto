package com.orto.logic.model.dao.inmemory;

import com.orto.logic.model.dao.OrderDAO;
import com.orto.logic.model.entity.Order;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOMEM implements OrderDAO {
    private static final List<Order> orders = new ArrayList<>();
    private static Integer nextOrderId = 1;

    @Override
    public void createOrder(Order order) {
        Order o = new Order(
                order.getSeller(),
                order.getOrderLines(),
                order.getDeliveryInfo(),
                order.getPaymentInfo(),
                order.getStatus(),
                order.getTotalPrice(),
                Instant.now());
        o.setId(getNextOrderId());
        orders.add(o);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    private static synchronized int getNextOrderId() {
        return nextOrderId++;
    }
}
