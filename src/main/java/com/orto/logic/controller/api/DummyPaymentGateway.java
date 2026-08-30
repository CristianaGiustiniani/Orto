package com.orto.logic.controller.api;

import com.orto.logic.controller.bean.PaymentBean;
import com.orto.logic.utils.PaymentStatus;

public class DummyPaymentGateway implements PaymentGateway{
    @Override
    public PaymentBean submitPayment(PaymentBean payment) {
        //dummy assignation: if payment is online, it automatically fails
        payment.setPaymentStatus(PaymentStatus.FAILED);
        return payment;
    }

    @Override
    public void refundPayment(PaymentBean payment) {
        //not implementing this
    }
}
