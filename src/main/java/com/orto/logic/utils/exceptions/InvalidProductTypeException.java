package com.orto.logic.utils.exceptions;

public class InvalidProductTypeException extends Exception {
    public InvalidProductTypeException() {
        super("Error in product type");
    }

    public InvalidProductTypeException(Throwable cause) {
        super("Error in product type", cause);
    }

    protected InvalidProductTypeException(String message) {
        super(message);
    }

    protected InvalidProductTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
