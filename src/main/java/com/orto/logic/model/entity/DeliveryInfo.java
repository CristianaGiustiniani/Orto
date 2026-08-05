package com.orto.logic.model.entity;

import com.orto.logic.utils.DeliveryType;

public class DeliveryInfo {
    DeliveryType deliveryType;
    Address address;
    String phoneNumber;

    public DeliveryInfo(DeliveryType deliveryType, Address address) {
        this.deliveryType = deliveryType;
        this.address = address;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }
    public Address getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
