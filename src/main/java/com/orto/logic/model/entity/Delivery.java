package com.orto.logic.model.entity;

import com.orto.logic.utils.DeliveryType;

public class Delivery {
    private final DeliveryType deliveryType;
    private final String recipientName;
    private final String recipientSurname;
    private final Address address;
    private final String phoneNumber;

    public Delivery(DeliveryType deliveryType, String recipientName, String recipientSurname, Address address, String phoneNumber) {
        this.deliveryType = deliveryType;
        this.recipientName = recipientName;
        this.recipientSurname = recipientSurname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }
    public String getRecipientName() {
        return recipientName;
    }
    public String getRecipientSurname() {
        return recipientSurname;
    }
    public Address getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
