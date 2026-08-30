package com.orto.logic.model.dao.exceptions;

public class ValidationException extends Exception {
    public ValidationException() {
        super("An error occurred during data validation");
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    protected ValidationException(String message) {
        super(message);
    }

    protected ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
