package com.orto.logic.utils.exceptions;

public class ConfigurationException extends Exception{
    public ConfigurationException() {
        super("An error occurred during system configuration");
    }

    public ConfigurationException(Throwable cause) {
        super("An error occurred during system configuration", cause);
    }

    protected ConfigurationException(String message) {
        super(message);
    }
    protected ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }


}
