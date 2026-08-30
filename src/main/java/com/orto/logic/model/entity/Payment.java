package com.orto.logic.model.entity;

import com.orto.logic.utils.PaymentStatus;
import com.orto.logic.utils.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private PaymentType paymentType = null;
    private PaymentStatus paymentStatus = null;
    private Integer id;
    private LocalDateTime date;
    private BigDecimal amount;


    public Payment() {}

    public Payment(PaymentType paymentType, PaymentStatus paymentStatus) {
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
    }

    public Payment(PaymentType paymentType, PaymentStatus paymentStatus, BigDecimal amount) {
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

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
    public void setId(Integer id) {
        this.id = id;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setPaymentAmount(BigDecimal amount){
        this.amount = amount;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public boolean isPaymentSuccessful() {
        return paymentStatus == PaymentStatus.SUCCESSFUL;
    }
    public boolean isPaymentFailed() {
        return paymentStatus == PaymentStatus.FAILED;
    }
    public PaymentType getPaymentType() {
        return paymentType;
    }
    public boolean isPaymentOnline() {
        return paymentType == PaymentType.ONLINE;
    }
    public boolean isPaymentCash() {
        return paymentType == PaymentType.CASH;
    }
    public Integer getId() {
        return id;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public BigDecimal getAmount() {
        return amount;
    }

}
