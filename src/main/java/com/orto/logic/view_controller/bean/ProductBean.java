package com.orto.logic.view_controller.bean;

import com.orto.logic.utils.QuantityUnit;
import com.orto.logic.view_controller.bean.exceptions.InvalidStringException;

public class ProductBean {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private QuantityUnit quantityUnit;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public QuantityUnit getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(QuantityUnit quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    //DATA VALIDATION METHODS
    private void validateString(String string) throws InvalidStringException {
        boolean ok = string.matches("[a-zA-Z0-9]+");
        if (!ok) {
            throw new InvalidStringException();
        }
    }
}
