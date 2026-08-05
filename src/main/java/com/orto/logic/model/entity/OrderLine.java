package com.orto.logic.model.entity;

import java.math.BigDecimal;

public class OrderLine {
    private Product product;
    private Double quantity;
    private String annotation;

    public OrderLine(Product product, Double quantity, String annotation) {
        this.product = product;
        this.quantity = quantity;
        this.annotation = annotation;
    }

    public Product getProduct() {
        return product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getAnnotation() {
        return annotation;
    }

    public BigDecimal getSubtotal() {
        return (BigDecimal.valueOf(quantity)).multiply(product.getPrice());
    }
}
