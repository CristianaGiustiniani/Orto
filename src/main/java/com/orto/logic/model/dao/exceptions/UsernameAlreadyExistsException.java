package com.orto.logic.model.dao.exceptions;

public class UsernameAlreadyExistsException extends Exception {
    public UsernameAlreadyExistsException(String message) {
        super(message);
    }

    public UsernameAlreadyExistsException() {
        super("Username already exists");
    }
}
