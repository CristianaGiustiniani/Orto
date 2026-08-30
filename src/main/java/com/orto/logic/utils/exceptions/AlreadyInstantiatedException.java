package com.orto.logic.utils.exceptions;

public class AlreadyInstantiatedException extends ConfigurationException {
    public AlreadyInstantiatedException() {
        super("Configuration has already been instantiated");
    }

    public AlreadyInstantiatedException(Throwable cause) {
        super("Configuration has already been instantiated", cause);
    }

    protected AlreadyInstantiatedException(String message) {
        super(message);
    }

    protected AlreadyInstantiatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
