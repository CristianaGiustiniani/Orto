package com.orto.logic.graphic_controller.bean;

import com.orto.logic.utils.DeliveryType;
import com.orto.logic.graphic_controller.bean.exceptions.InvalidStringException;

import java.util.regex.Pattern;

public class DeliveryBean {
    private DeliveryType deliveryType;
    private String recipientName;
    private String recipientSurname;
    private AddressBean address;
    private String phoneNumber;

    //GETTERS AND SETTERS
    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientSurname() {
        return recipientSurname;
    }

    public void setRecipientSurname(String recipientSurname) {
        this.recipientSurname = recipientSurname;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //DATA VALIDATION METHODS
    public void validate() throws InvalidStringException {
        if (deliveryType == DeliveryType.SHIPPING) {
            validateString(recipientName);
            validateString(recipientSurname);
            address.validate();
        }
        validateString(phoneNumber);
    }
    private void validateString(String string) throws InvalidStringException {
        if (string == null || !(Pattern.compile("[a-zA-Z0-9]").matcher(string).find())) {
            throw new InvalidStringException();
        }
    }
}
