package com.orto.logic.model.dao.exceptions;

public class WrongEmailException extends Exception {
    public WrongEmailException() {
        super("Wrong email address");
    }
}
