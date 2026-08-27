package com.orto.logic.controller.bean;

import com.orto.logic.utils.ProductType;
import com.orto.logic.controller.bean.exceptions.InvalidStringException;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class SellerBean {
    private Integer id;
    private String name;
    private AddressBean address;
    private List<ProductType> productTypes;
    private Map<DayOfWeek, TimeSlotBean> openingHours;

    //GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public List<ProductType> getProductTypes() { return productTypes; }

    public void setProductTypes(List<ProductType> productTypes) { this.productTypes = productTypes; }

    public Map<DayOfWeek, TimeSlotBean> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Map<DayOfWeek, TimeSlotBean> openingHours) {
        this.openingHours = openingHours;
    }

    //DATA VALIDATION METHODS
    public void validate() throws InvalidStringException {
        validateString(this.name);
        address.validate();
    }
    private void validateString(String string) throws InvalidStringException {
        boolean ok = Pattern.compile("[a-zA-Z0-9]").matcher(string).find();
        if (!ok) {
            throw new InvalidStringException();
        }
    }
}
