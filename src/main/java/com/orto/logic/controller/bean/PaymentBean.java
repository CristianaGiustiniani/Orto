package com.orto.logic.controller.bean;

import com.orto.logic.utils.PaymentStatus;
import com.orto.logic.utils.PaymentType;

public class PaymentBean {
    private PaymentType paymentType = null;
    private PaymentStatus paymentStatus = null;

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public PaymentType getPaymentType() {
        return paymentType;
    }
}
