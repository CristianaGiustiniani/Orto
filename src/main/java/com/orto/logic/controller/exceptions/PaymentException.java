package com.orto.logic.controller.exceptions;

public class PaymentException extends Exception{
    public PaymentException() {
        super("An error occurred during payment");
    }

    public PaymentException(Throwable cause) {
        super("An error occurred during payment", cause);
    }

    protected PaymentException(String message) {
        super(message);
    }

    protected PaymentException(String message, Throwable cause) {
        super(message, cause);
    }
}
