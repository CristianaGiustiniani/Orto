package com.orto.logic.model.dao.exceptions;

public class EmailAlreadyExistsException extends ValidationException {
    public EmailAlreadyExistsException() {
        super("Email address already exists");
    }

    public EmailAlreadyExistsException(Throwable cause) {
        super("Email address already exists", cause);
    }

    protected EmailAlreadyExistsException(String message) {
        super(message);
    }

    protected EmailAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
