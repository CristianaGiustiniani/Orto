package com.orto.logic.controller.bean;

import com.orto.logic.utils.PaymentStatus;
import com.orto.logic.utils.PaymentType;

public class PaymentBean {
    private PaymentType paymentType = null;
    private PaymentStatus paymentStatus = null;

    private int id;
    private String amount;
    private String date;


    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPaymentDate(String date) {
        this.date = date;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public PaymentType getPaymentType() {
        return paymentType;
    }
    public int getId() {
        return id;
    }
    public String getPaymentDate() {
        return date;
    }
    public String getAmount() {
        return amount;
    }
}
