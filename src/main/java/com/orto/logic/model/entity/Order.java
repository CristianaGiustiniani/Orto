package com.orto.logic.model.entity;

import com.orto.logic.utils.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class Order {
    private Integer id;
    private Seller seller;
    private List<OrderLine> orderLines;
    private DeliveryInfo deliveryInfo;
    private PaymentInfo paymentInfo;
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

    public Order(Seller seller, List<OrderLine> orderLines, DeliveryInfo deliveryInfo, PaymentInfo paymentInfo, OrderStatus status, BigDecimal totalPrice, Instant orderDate) {
        this.seller = seller;
        this.orderLines = orderLines;
        this.deliveryInfo = deliveryInfo;
        this.paymentInfo = paymentInfo;
        this.status = status;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public void addSeller(Seller seller) {
        this.seller = seller;
    }

    public void addLineToOrder(OrderLine orderLine) {
        this.orderLines.add(orderLine);
    }

    public void addDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public void addPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
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
        BigDecimal totalPrice = new BigDecimal("0.00");
        for (OrderLine orderLine : orderLines) {
            totalPrice = totalPrice.add(orderLine.getSubtotal());
        }
        this.totalPrice = totalPrice;
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
    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }
    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
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



}
