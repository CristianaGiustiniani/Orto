package com.orto.logic.controller.api;

import com.orto.logic.controller.bean.PaymentBean;

public interface PaymentGateway {
    PaymentBean submitPayment(PaymentBean payment);
    void refundPayment(PaymentBean payment);

}
