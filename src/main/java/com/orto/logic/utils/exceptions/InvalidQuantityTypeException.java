package com.orto.logic.utils.exceptions;

public class InvalidQuantityTypeException extends Exception {
    public InvalidQuantityTypeException() {
        super("Error in quantity type");
    }

    public InvalidQuantityTypeException(Throwable cause) {
        super("Error in quantity type", cause);
    }

    protected InvalidQuantityTypeException(String message) {
        super(message);
    }

    protected InvalidQuantityTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
