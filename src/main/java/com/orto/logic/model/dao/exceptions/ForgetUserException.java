package com.orto.logic.model.dao.exceptions;

public class ForgetUserException extends ValidationException {
    public ForgetUserException() {
        super("Error in deleting the file containing the remembered user");
    }
    public ForgetUserException(Throwable cause) {
        super(cause);
    }
}
