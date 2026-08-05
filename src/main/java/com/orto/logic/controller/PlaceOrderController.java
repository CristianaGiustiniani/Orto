package com.orto.logic.controller;

import com.orto.logic.model.dao.ProductDAO;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.Order;
import com.orto.logic.model.entity.PaymentInfo;
import com.orto.logic.model.entity.Product;
import com.orto.logic.model.entity.Seller;

import java.util.List;

public class PlaceOrderController {
    private Order order;
    private Seller seller;

    public void startOrder(Seller seller) {
        this.seller = seller;
        this.order = new Order();
        this.order.addSeller(seller);
    }

    public void saveOrder() throws ConnectionException {
        if (order != null) {
            DAOFactory.getDAOFactory().getOrderDAO().createOrder(order);
        }
    }

    private List<Product> retrieveProducts(Seller seller) {
        ProductDAO productDAO = DAOFactory.getDAOFactory().getProductDAO();
        return productDAO.getAllProducts();
    }
    private void processPayment(PaymentInfo payment) {}
    private void notifySeller(Seller seller) {}

}
