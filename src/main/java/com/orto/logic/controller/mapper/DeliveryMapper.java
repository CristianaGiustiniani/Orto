package com.orto.logic.controller.mapper;

import com.orto.logic.controller.bean.DeliveryBean;
import com.orto.logic.model.entity.Delivery;

public class DeliveryMapper implements Mapper<Delivery, DeliveryBean>{
    @Override
    public DeliveryBean toBean(Delivery entity) {
        DeliveryBean bean = new DeliveryBean();
        bean.setDeliveryType(entity.getDeliveryType());
        bean.setRecipientName(entity.getRecipientName());
        bean.setRecipientSurname(entity.getRecipientSurname());
        bean.setAddress((new AddressMapper()).toBean(entity.getAddress()));
        bean.setPhoneNumber(entity.getPhoneNumber());
        return bean;
    }

    @Override
    public Delivery toEntity(DeliveryBean bean) {
        return new Delivery(
                bean.getDeliveryType(),
                bean.getRecipientName(),
                bean.getRecipientSurname(),
                (new AddressMapper()).toEntity(bean.getAddress()),
                bean.getPhoneNumber()
        );
    }
}
