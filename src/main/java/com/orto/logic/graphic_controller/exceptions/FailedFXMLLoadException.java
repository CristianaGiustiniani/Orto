package com.orto.logic.graphic_controller.exceptions;

public class FailedFXMLLoadException extends RuntimeException {
    public FailedFXMLLoadException() {
        super("Failed to load FXML file");
    }
    public FailedFXMLLoadException(Throwable cause) {
        super("Failed to load FXML file", cause);
    }
    protected FailedFXMLLoadException(String message) {
        super(message);
    }
    protected FailedFXMLLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
