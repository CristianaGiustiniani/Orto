package com.orto.logic.utils.exceptions;

public class StartOfEnumException extends Exception {
    public StartOfEnumException() {
        super("Trying to go to nonexistent previous step");
    }
}
