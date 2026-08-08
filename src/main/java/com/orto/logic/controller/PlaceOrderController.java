package com.orto.logic.controller;

import com.orto.logic.model.dao.ProductDAO;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.*;
import com.orto.logic.model.entity.exceptions.NoProductSelectedException;
import com.orto.logic.utils.PaymentStatus;

import java.math.BigDecimal;
import java.util.List;

public class PlaceOrderController {
    private Order order;

    public void startOrder(Seller seller) {
        this.order = new Order();
        this.order.addSeller(seller);
    }

    public List<Product> retrieveProducts() throws ConnectionException {
        ProductDAO productDAO = DAOFactory.getDAOFactory().getProductDAO();
        return productDAO.getProducts(order.getSeller());
    }

    public void addProductsToOrder(List<OrderLine> products) throws NoProductSelectedException {
        order.addLines(products);
    }

    public BigDecimal getOrderTotal() {
        order.calculateTotalPrice();
        return order.getTotalPrice();
    }

    public void defineDelivery(Delivery delivery) {
        order.addDeliveryInfo(delivery);
    }

    public boolean isOrderShipped() {
        return this.order.isDeliveryShipping();
    }

    public void processPayment(Payment payment) {
        PaymentStatus status = payment.getPaymentStatus();
        if (status == PaymentStatus.SUCCESSFUL) {
            order.setOrderStatusPending();
        }
        else {
            order.setOrderStatusRejected();
        }
        order.addPaymentInfo(payment);
    }

    public void saveOrder() throws ConnectionException {
        DAOFactory.getDAOFactory().getOrderDAO().createOrder(order);
    }

    public void notifySeller() {
        //not implementing this
    }

}
