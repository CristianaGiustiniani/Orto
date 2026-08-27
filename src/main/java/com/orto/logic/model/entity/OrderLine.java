package com.orto.logic.model.entity;

import com.orto.logic.utils.QuantityUnit;

import java.math.BigDecimal;

public class OrderLine {
    private final Product product;
    private final Double quantity;
    private final String annotation;

    public OrderLine(Product product, Double quantity, String annotation) {
        this.product = product;
        this.quantity = quantity;
        this.annotation = annotation;
    }


    public Product getProduct() {
        return product;
    }

    public Integer getProductId() { return product.getId(); }

    public String getProductName() { return product.getName(); }

    public BigDecimal getProductPrice() { return product.getPrice(); }

    public Double getQuantity() {
        return quantity;
    }

    public QuantityUnit getQuantityUnit() { return product.getQuantityUnit(); }

    public String getAnnotation() {
        return annotation;
    }

    public BigDecimal getSubtotal() {
        return (BigDecimal.valueOf(quantity)).multiply(product.getPrice());
    }
}
