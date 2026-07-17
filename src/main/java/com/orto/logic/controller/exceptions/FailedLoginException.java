package com.orto.logic.controller.exceptions;

public class FailedLoginException extends LoginException{
    public FailedLoginException() {
        super("Failed login");
    }
}
