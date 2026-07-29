package com.orto.logic.view_controller.bean;

import com.orto.logic.utils.ProductType;
import com.orto.logic.view_controller.bean.exceptions.InvalidStringException;

import java.util.List;

public class SellerBean extends Bean {
    private Integer id;
    private String name;
    private AddressBean address;
    private List<ProductType> productTypes;
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

    public List<TimeSlotBean> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<TimeSlotBean> openingHours) {
        this.openingHours = openingHours;
    }

    //DATA VALIDATION METHODS
    public void validate() throws InvalidStringException {
        validateString(this.name);
    }
    private void validateString(String string) throws InvalidStringException {

        boolean ok = string.matches("[a-zA-Z0-9]+");
        if (!ok) {
            throw new InvalidStringException();
        }
    }
}
