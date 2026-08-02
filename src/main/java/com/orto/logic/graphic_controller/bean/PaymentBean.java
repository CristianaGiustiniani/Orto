package com.orto.logic.graphic_controller.bean;

import com.orto.logic.utils.PaymentType;

public class PaymentBean {
    //ATTRIBUTES
    private PaymentType paymentType;
    private Double amount;
    private Boolean successful;

    //GETTERS AND SETTERS
    //todo: syntactic data validation
    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    //DATA VALIDATION METHODS

}
