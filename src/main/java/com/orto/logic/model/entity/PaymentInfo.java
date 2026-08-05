package com.orto.logic.model.entity;

import com.orto.logic.utils.PaymentStatus;
import com.orto.logic.utils.PaymentType;

public class PaymentInfo {
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;

    public void setPaymentStatusSuccessful(){
        this.paymentStatus = PaymentStatus.SUCCESSFUL;
    }
    public void setPaymentStatusFailed(){
        this.paymentStatus = PaymentStatus.FAILED;
    }
    public void setPaymentTypeCash(){
        this.paymentType = PaymentType.CASH;
    }
    public void setPaymentTypeOnline(){
        this.paymentType = PaymentType.ONLINE;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public PaymentType getPaymentType() {
        return paymentType;
    }
}
