package com.orto.logic.model.dao.exceptions;

public class WrongEmailException extends ValidationException {
    public WrongEmailException() {
        super("Email is inexistent");
    }

    public WrongEmailException(Throwable cause) {
        super("Email is inexistent", cause);
    }

    protected WrongEmailException(String message) {
        super(message);
    }

    protected WrongEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
