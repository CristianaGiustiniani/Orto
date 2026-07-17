package com.orto.logic.utils.exceptions;

public class EndOfEnumException extends Exception {
    public EndOfEnumException() {
        super("Trying to go to nonexistent next step");
    }
}
