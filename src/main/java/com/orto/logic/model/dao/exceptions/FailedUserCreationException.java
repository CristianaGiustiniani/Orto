package com.orto.logic.model.dao.exceptions;

public class FailedUserCreationException extends Exception {
    public FailedUserCreationException() {
        super("Error in saving new user");
    }
    public FailedUserCreationException(String message) {
        super(message);
    }
}
