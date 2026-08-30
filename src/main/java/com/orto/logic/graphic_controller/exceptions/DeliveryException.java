package com.orto.logic.graphic_controller.exceptions;

public class DeliveryException extends Exception {
    public DeliveryException() {
        super("An error occurred during delivery definition");
    }

    public DeliveryException(Throwable cause) {
        super("An error occurred during delivery definition", cause);
    }

    protected DeliveryException(String message) {
        super(message);
    }

    protected DeliveryException(String message, Throwable cause) {
        super(message, cause);
    }
}
