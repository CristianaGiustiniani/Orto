package com.orto.logic.model.entity.exceptions;

import com.orto.logic.graphic_controller.exceptions.ProductException;

public class NoProductSelectedException extends ProductException {
    public NoProductSelectedException() {
        super("No product has been selected during product selection");
    }
    public NoProductSelectedException(Throwable cause) {
        super("No product has been selected during product selection", cause);
    }
    protected NoProductSelectedException(String message) {
        super(message);
    }
    protected NoProductSelectedException(String message, Throwable cause) {
        super(message, cause);
    }
}
