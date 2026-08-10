package com.orto.logic.model.entity;

import com.orto.logic.model.entity.exceptions.NoProductSelectedException;
import com.orto.logic.utils.DeliveryType;
import com.orto.logic.utils.OrderStatus;
import com.orto.logic.utils.PaymentStatus;
import com.orto.logic.utils.PaymentType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class Order {
    private Integer id = null;
    private Seller seller = null;
    private List<OrderLine> orderLines = null;
    private Delivery delivery = null;
    private Payment payment = null;
    private OrderStatus status = null;
    private BigDecimal totalPrice = null;
    private Instant orderDate = null;

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
    public boolean isDeliveryShipping() {
        return delivery.deliveryType == DeliveryType.SHIPPING;
    }
    public boolean isDeliveryPickup() {
        return delivery.deliveryType == DeliveryType.PICKUP;
    }
    public Payment getPaymentInfo() {
        return payment;
    }
    public boolean isPaymentSuccessful() {
        if (payment != null) {
            return (payment.getPaymentStatus() == PaymentStatus.SUCCESSFUL);
        }
        return false;
    }
    public boolean isPaymentFailed() {
        if (payment != null) {
            return (payment.getPaymentStatus() == PaymentStatus.FAILED);
        }
        return false;
    }
    public boolean isPaymentCash() {
        if (payment != null) {
            return (payment.getPaymentType() == PaymentType.CASH);
        }
        return false;
    }
    public boolean isPaymentOnline() {
        if (payment != null) {
            return (payment.getPaymentType() == PaymentType.ONLINE);
        }
        return false;
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
