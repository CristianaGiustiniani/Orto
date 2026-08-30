package com.orto.logic.graphic_controller.exceptions;

public class ProductException extends Exception {
    public ProductException() {
        super("An error occurred during product selection");
    }

    public ProductException(Throwable cause) {
        super("An error occurred during product selection", cause);
    }

    protected ProductException(String message) {
        super(message);
    }

    protected ProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
