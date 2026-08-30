package com.orto.logic.controller;

import com.orto.logic.controller.api.DummyPaymentGateway;
import com.orto.logic.controller.api.PaymentGateway;
import com.orto.logic.controller.bean.PaymentBean;
import com.orto.logic.controller.exceptions.FailedPaymentException;
import com.orto.logic.controller.mapper.PaymentMapper;
import com.orto.logic.model.entity.Payment;

public class ProcessPaymentController {
    public void processPayment(Payment payment) throws FailedPaymentException {
        if (payment.isPaymentCash()) {
            payment.setPaymentStatusSuccessful();
        } else {
            PaymentGateway paymentGateway = new DummyPaymentGateway();
            PaymentMapper mapper = new PaymentMapper();

            PaymentBean result = paymentGateway.submitPayment(mapper.toBean(payment));

            if ((mapper.toEntity(result).isPaymentFailed())) {
                throw new FailedPaymentException();
            }
        }
    }
}
