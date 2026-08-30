package com.orto.logic.model.entity.exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() { super("Wrong password"); }

    public WrongPasswordException(Throwable cause) { super("Wrong password", cause); }

    protected WrongPasswordException(String message) { super(message); }

    protected WrongPasswordException(String message, Throwable cause) { super(message, cause); }
}
