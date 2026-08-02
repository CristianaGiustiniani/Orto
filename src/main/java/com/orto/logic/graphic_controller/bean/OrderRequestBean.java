package com.orto.logic.graphic_controller.bean;

import com.orto.logic.utils.OrderStatus;
import com.orto.logic.graphic_controller.bean.exceptions.InvalidStringException;

import java.util.List;

public class OrderRequestBean {
    private Integer id;
    private SellerBean seller;
    private List<OrderLineBean> orderLines;
    private DeliveryBean delivery;
    private  PaymentBean payment;
    private Double totalPrice;
    private OrderStatus status;

    //GETTERS AND SETTERS
    //todo: syntactic data validation
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SellerBean getSeller() {
        return seller;
    }

    public void setSeller(SellerBean seller) {
        this.seller = seller;
    }

    public List<OrderLineBean> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineBean> orderLines) {
        this.orderLines = orderLines;
    }

    public DeliveryBean getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryBean delivery) {
        this.delivery = delivery;
    }

    public PaymentBean getPayment() {
        return payment;
    }

    public void setPayment(PaymentBean payment) {
        this.payment = payment;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    //DATA VALIDATION METHODS
    private void validateString(String string) throws InvalidStringException {
        boolean ok = string.matches("[a-zA-Z0-9]+");
        if (!ok) {
            throw new InvalidStringException();
        }
    }
}
