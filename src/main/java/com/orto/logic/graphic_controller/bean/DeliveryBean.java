package com.orto.logic.graphic_controller.bean;

import com.orto.logic.utils.DeliveryType;
import com.orto.logic.graphic_controller.bean.exceptions.InvalidStringException;

public class DeliveryBean {
    private DeliveryType deliveryType;
    private String recipientName;
    private String recipientSurname;
    private AddressBean address;
    private String phoneNumber;

    //GETTERS AND SETTERS
    //todo: syntactic data validation for beans
    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) throws InvalidStringException {
        try {
            validateString(recipientName);
            this.recipientName = recipientName;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Name has no characters or digits");
        }
    }

    public String getRecipientSurname() {
        return recipientSurname;
    }

    public void setRecipientSurname(String recipientSurname) throws InvalidStringException {
        try {
            validateString(recipientSurname);
            this.recipientSurname = recipientSurname;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Surname has no characters or digits");
        }
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

    public void setPhoneNumber(String phoneNumber) throws InvalidStringException {
        try {
            validateString(phoneNumber);
            this.phoneNumber = phoneNumber;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Phone number has no characters or digits");
        }
    }

    //DATA VALIDATION METHODS
    private void validateString(String string) throws InvalidStringException {
        boolean ok = string.matches("[a-zA-Z0-9]+");
        if (!ok) {
            throw new InvalidStringException();
        }
    }
}
