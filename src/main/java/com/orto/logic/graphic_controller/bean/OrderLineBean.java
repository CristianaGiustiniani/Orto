package com.orto.logic.graphic_controller.bean;

import com.orto.logic.graphic_controller.bean.exceptions.AnnotationTooLongException;
import com.orto.logic.utils.QuantityUnit;
import com.orto.logic.graphic_controller.bean.exceptions.InvalidStringException;

public class OrderLineBean {
    private Integer productId;
    private String productName;
    private Double quantity;
    private QuantityUnit quantityUnit;
    private String annotation;
    private Double subtotal;

    //GETTERS AND SETTERS
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public QuantityUnit getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(QuantityUnit quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    //DATA VALIDATION METHODS
    private void validate() throws AnnotationTooLongException {
        validateAnnotation(this.annotation);
    }

    private void validateAnnotation(String annotation) throws AnnotationTooLongException {
        int length = annotation.length();
        if (length > 200) {
            throw new AnnotationTooLongException();
        }
    }
}
