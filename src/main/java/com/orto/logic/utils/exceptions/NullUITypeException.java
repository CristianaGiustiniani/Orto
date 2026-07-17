package com.orto.logic.utils.exceptions;

public class NullUITypeException extends ConfigurationException {
    public NullUITypeException() {
        super("UI type can't be null");
    }
}
