package com.orto.logic.graphic_controller.bean;

import com.orto.logic.graphic_controller.bean.exceptions.AnnotationTooLongException;
import com.orto.logic.graphic_controller.bean.exceptions.NotPositiveQuantityException;
import com.orto.logic.graphic_controller.bean.exceptions.NullQuantityException;
import com.orto.logic.graphic_controller.bean.exceptions.WrongFormatQuantityException;
import com.orto.logic.utils.QuantityUnit;

public class OrderLineBean {
    private Integer productId;
    private String productName;
    private String quantity;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
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
    public void validate() throws AnnotationTooLongException, NullQuantityException, NotPositiveQuantityException, WrongFormatQuantityException {
        validateQuantity(this.quantity);
        validateAnnotation(this.annotation);
    }

    private void validateAnnotation(String annotation) throws AnnotationTooLongException {
        int length = annotation.length();
        if (length > 200) {
            throw new AnnotationTooLongException();
        }
    }

    private void validateQuantity(String quantity) throws WrongFormatQuantityException, NullQuantityException, NotPositiveQuantityException {
        String formattedQuantity;
        double doubleQuantity;
        if (quantity != null && !quantity.isBlank()) {
            try {
                formattedQuantity =quantity.trim().replace(',', '.');
                doubleQuantity = Double.parseDouble(formattedQuantity);
                if (doubleQuantity <= 0) {
                    throw new NotPositiveQuantityException();
                }
                this.quantity = formattedQuantity;
            } catch (NumberFormatException e) {
                throw new WrongFormatQuantityException();
            }
        } else {
            throw new NullQuantityException();
        }

        boolean isDecimal = ((doubleQuantity % 1) != 0);
        switch (quantityUnit) {
            case LITER, MILLILITER, KILOGRAM, HECTOGRAM, GRAM:
                break;
            case PIECE, PACK:
                if (isDecimal) throw new WrongFormatQuantityException();
                break;
        }
    }
}
