package com.orto.logic.controller;

import com.orto.logic.controller.bean.*;
import com.orto.logic.controller.exceptions.FailedPaymentException;
import com.orto.logic.controller.mapper.*;
import com.orto.logic.model.dao.ProductDAO;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.factory.DAOFactory;
import com.orto.logic.model.entity.*;
import com.orto.logic.model.entity.exceptions.NoProductSelectedException;

import java.util.List;

public class PlaceOrderController {
    private Order order;

    public void startOrder(SellerBean sellerBean) {
        SellerMapper mapper = new SellerMapper();
        Seller seller = mapper.toEntity(sellerBean);

        this.order = new Order();
        this.order.addSeller(seller);
    }

    public List<ProductBean> retrieveProducts() throws ConnectionException {
        ProductMapper mapper = new ProductMapper();
        ProductDAO productDAO = DAOFactory.getDAOFactory().getProductDAO();
        List<Product> products = productDAO.getProducts(order.getSeller());

        return mapper.toBeans(products);
    }

    public void addProductsToOrder(List<OrderLineBean> products) throws NoProductSelectedException {
        OrderLineMapper mapper = new OrderLineMapper();
        order.addLines(mapper.toEntities(products));
    }

    public String getOrderTotal() {
        PriceMapper mapper = new PriceMapper();
        order.calculateTotalPrice();
        return mapper.toBean(order.getTotalPrice());
    }

    public void defineDelivery(DeliveryBean delivery) {
        DeliveryMapper mapper = new DeliveryMapper();
        order.addDeliveryInfo(mapper.toEntity(delivery));
    }

    public boolean isOrderShipped() {
        return this.order.isDeliveryShipping();
    }

    public void pay(PaymentBean paymentBean) throws FailedPaymentException {
        PaymentMapper mapper = new PaymentMapper();
        Payment payment = mapper.toEntity(paymentBean);
        ProcessPaymentController paymentController = new ProcessPaymentController();

        paymentController.processPayment(payment);
        order.addPaymentInfo(payment);
        if (order.isPaymentSuccessful()) {
            order.setOrderStatusPending();
        }
    }

    public void saveOrder() throws ConnectionException {
        DAOFactory.getDAOFactory().getOrderDAO().createOrder(order);
    }

    public void notifySeller() {
        //not implementing this
    }
}
