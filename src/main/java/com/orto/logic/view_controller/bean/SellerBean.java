package com.orto.logic.view_controller.bean;

import com.orto.logic.view_controller.bean.exceptions.InvalidStringException;

import java.util.List;

public class SellerBean {
    private Integer id;
    private String name;
    private AddressBean address;
    private List<TimeSlotBean> openingHours;

    //GETTERS AND SETTERS
    //todo: syntactic data validation
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidStringException {
        try {
            validateString(name);
            this.name = name;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Name has no characters or digits");
        }
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public List<TimeSlotBean> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<TimeSlotBean> openingHours) {
        this.openingHours = openingHours;
    }

    //DATA VALIDATION METHODS
    private void validateString(String string) throws InvalidStringException {
        boolean ok = string.matches("[a-zA-Z0-9]+");
        if (!ok) {
            throw new InvalidStringException();
        }
    }
}
