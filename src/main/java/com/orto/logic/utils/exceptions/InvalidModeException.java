package com.orto.logic.utils.exceptions;

public class InvalidModeException extends ConfigurationException {
    public InvalidModeException() {
        super("Mode is invalid");
    }
}
