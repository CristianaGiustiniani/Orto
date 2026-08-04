package com.orto.logic.model.dao.exceptions;

public class ForgetUserException extends Exception {
    public ForgetUserException(Throwable cause) {
        super("Can't delete the file containing the remembered user", cause);
    }

    public ForgetUserException() {
        super("Can't delete the file containing the remembered user");
    }
}
