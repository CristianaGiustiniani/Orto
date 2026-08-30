package com.orto.logic.controller.exceptions;

public class FailedPaymentException extends PaymentException {
    public FailedPaymentException() {
        super("Payment failed at gateway");
    }

    public FailedPaymentException(Throwable cause) {
        super("Payment failed at gateway", cause);
    }

    protected FailedPaymentException(String message) {
        super(message);
    }

    protected FailedPaymentException(String message, Throwable cause) {
        super(message, cause);
    }

}
