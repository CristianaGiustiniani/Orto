package com.orto.logic.graphic_controller.exceptions;

public class InvalidDeliveryInfoException extends DeliveryException {
    public InvalidDeliveryInfoException() {
        super("Submitted delivery information is invalid");
    }

    public InvalidDeliveryInfoException(Throwable cause) {
        super("Submitted delivery information is invalid", cause);
    }

    protected InvalidDeliveryInfoException(String message) {
        super(message);
    }

    protected InvalidDeliveryInfoException(String message, Throwable cause) {
        super(message, cause);
    }
}
