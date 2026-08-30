package com.orto.logic.utils.exceptions;

public class IllegalNullUserException extends Exception {
    public IllegalNullUserException() {
        super("User is null and shan't be null");
    }

    public IllegalNullUserException(Throwable cause) {
        super("User is null and shan't be null", cause);
    }

    protected IllegalNullUserException(String message) {
        super(message);
    }

    protected IllegalNullUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
