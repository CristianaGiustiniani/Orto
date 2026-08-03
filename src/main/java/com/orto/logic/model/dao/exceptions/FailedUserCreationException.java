package com.orto.logic.model.dao.exceptions;

public class FailedUserCreationException extends Exception {
    public FailedUserCreationException(String message) {
        super(message);
    }

    public FailedUserCreationException() {
        super("Could not save new user");
    }
}
