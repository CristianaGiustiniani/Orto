package com.orto.logic.utils.exceptions;

public class EndOfEnumException extends Exception {
    public EndOfEnumException() {
        super("Trying to go to nonexistent next step");
    }

    public EndOfEnumException(Throwable cause) {
        super("Trying to go to nonexistent next step", cause);
    }

    protected EndOfEnumException(String message) {
        super(message);
    }

    protected EndOfEnumException(String message, Throwable cause) {
        super(message, cause);
    }
}
