package com.orto.logic.controller.exceptions;

public class FailedSignUpException extends SignUpException {
    public FailedSignUpException() {
        super("Signup failed");
    }
}
