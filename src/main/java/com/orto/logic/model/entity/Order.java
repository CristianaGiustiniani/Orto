package com.orto.logic.model.entity;

import com.orto.logic.model.entity.exceptions.NoProductSelectedException;
import com.orto.logic.utils.DeliveryType;
import com.orto.logic.utils.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class Order {
    private Integer id;
    private Seller seller;
    private List<OrderLine> orderLines;
    private Delivery delivery;
    private Payment payment;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private Instant orderDate;

    public Order() {
    }

    public Order(Seller seller, List<OrderLine> orderLines, OrderStatus status, BigDecimal totalPrice) {
        this.seller = seller;
        this.orderLines = orderLines;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public Order(Seller seller, List<OrderLine> orderLines, Delivery delivery, Payment paymentInfo, OrderStatus status, BigDecimal totalPrice, Instant orderDate) {
        this.seller = seller;
        this.orderLines = orderLines;
        this.delivery = delivery;
        this.payment = paymentInfo;
        this.status = status;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public void addSeller(Seller seller) {
        this.seller = seller;
    }

    public void addLines(List<OrderLine> orderLines) throws NoProductSelectedException {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new NoProductSelectedException();
        }
        this.orderLines = orderLines;
    }

    public void addDeliveryInfo(Delivery delivery) {
        this.delivery = delivery;
    }

    public void addPaymentInfo(Payment paymentInfo) {
        this.payment = paymentInfo;
    }

    public void setOrderStatusCompleted() {
        this.status = OrderStatus.COMPLETED;
    }

    public void setOrderStatusPending() {
        this.status = OrderStatus.PENDING;
    }

    public void setOrderStatusRejected() {
        this.status = OrderStatus.REJECTED;
    }

    public void calculateTotalPrice() {
        BigDecimal total = new BigDecimal("0.00");
        for (OrderLine orderLine : orderLines) {
            total = total.add(orderLine.getSubtotal());
        }
        this.totalPrice = total;
    }

    public Integer getId() {
        return id;
    }
    public Seller getSeller() {
        return seller;
    }
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
    public Delivery getDeliveryInfo() {
        return delivery;
    }
    public Payment getPaymentInfo() {
        return payment;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public Instant getOrderDate() {
        return orderDate;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDeliveryShipping() {
        return delivery.deliveryType == DeliveryType.SHIPPING;
    }



}
