package com.orto.logic.graphic_controller.bean;

import com.orto.logic.utils.QuantityUnit;
import com.orto.logic.graphic_controller.bean.exceptions.InvalidStringException;

public class ProductBean {
    private Integer id;
    private String name;
    private String description;
    private String price;
    private QuantityUnit quantityUnit;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public QuantityUnit getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(QuantityUnit quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    //DATA VALIDATION METHODS
    public void validate() throws InvalidStringException {
        validateString(this.name);
        //todo: validate other fields
    }
    private void validateString(String string) throws InvalidStringException {
        boolean ok = string.matches("[a-zA-Z0-9]+");
        if (!ok) {
            throw new InvalidStringException();
        }
    }
}
