package com.orto.logic.model.entity;

import com.orto.logic.utils.QuantityUnit;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private QuantityUnit quantityUnit;

    public Product(Integer id, String name, String description, BigDecimal price, QuantityUnit quantityUnit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityUnit = quantityUnit;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public QuantityUnit getQuantityUnit() {
        return quantityUnit;
    }
}
