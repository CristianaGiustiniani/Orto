package com.orto.logic.controller.bean.exceptions;

public class InvalidStringException extends Exception {
    public InvalidStringException() {
        super("Error in syntactic validation of string");
    }

    public InvalidStringException(Throwable cause) {
        super("Error in syntactic validation of string", cause);
    }

    protected InvalidStringException(String s) {
        super(s);
    }

    protected InvalidStringException(String message, Throwable cause) {
        super(message, cause);
    }
}
