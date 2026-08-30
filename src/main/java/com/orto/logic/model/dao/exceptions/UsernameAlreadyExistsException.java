package com.orto.logic.model.dao.exceptions;

public class UsernameAlreadyExistsException extends ValidationException {
    public UsernameAlreadyExistsException() {
        super("Username already exists");
    }
    public UsernameAlreadyExistsException(Throwable cause) {
        super("Username already exists", cause);
    }
    protected UsernameAlreadyExistsException(String message) {
        super(message);
    }
    protected UsernameAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
