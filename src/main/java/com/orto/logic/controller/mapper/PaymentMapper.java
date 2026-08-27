package com.orto.logic.controller.mapper;

import com.orto.logic.controller.bean.PaymentBean;
import com.orto.logic.model.entity.Payment;

public class PaymentMapper implements Mapper<Payment, PaymentBean>{
    @Override
    public PaymentBean toBean(Payment entity) {
        PaymentBean bean = new PaymentBean();
        bean.setPaymentStatus(entity.getPaymentStatus());
        bean.setPaymentType(entity.getPaymentType());
        return bean;
    }

    @Override
    public Payment toEntity(PaymentBean bean) {
        return new Payment(
                bean.getPaymentType(),
                bean.getPaymentStatus());
    }
}
