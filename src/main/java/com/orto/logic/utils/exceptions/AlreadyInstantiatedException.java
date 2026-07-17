package com.orto.logic.utils.exceptions;

public class AlreadyInstantiatedException extends ConfigurationException {
    public AlreadyInstantiatedException() {
        super("Configuration has already been instantiated");
    }
}
