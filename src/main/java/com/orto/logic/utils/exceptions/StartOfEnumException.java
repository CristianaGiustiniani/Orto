package com.orto.logic.utils.exceptions;

public class StartOfEnumException extends Exception {
    public StartOfEnumException() {
        super("Trying to go to nonexistent previous step");
    }

    public StartOfEnumException(Throwable cause) {
        super("Trying to go to nonexistent previous step", cause);
    }
    protected StartOfEnumException(String message) {
        super(message);
    }
    protected StartOfEnumException(String message, Throwable cause) {
        super(message, cause);
    }
}
