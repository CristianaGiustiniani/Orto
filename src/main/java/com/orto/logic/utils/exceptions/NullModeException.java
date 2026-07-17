package com.orto.logic.utils.exceptions;

public class NullModeException extends ConfigurationException {
    public NullModeException() {
        super("Mode can't be null");
    }

}
