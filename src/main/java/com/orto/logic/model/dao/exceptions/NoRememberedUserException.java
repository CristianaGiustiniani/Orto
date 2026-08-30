package com.orto.logic.model.dao.exceptions;

public class NoRememberedUserException extends ValidationException {
    public NoRememberedUserException() {
        super("No remembered user could be found");
    }
}
