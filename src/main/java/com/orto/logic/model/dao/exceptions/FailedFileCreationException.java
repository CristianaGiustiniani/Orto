package com.orto.logic.model.dao.exceptions;

public class FailedFileCreationException extends Exception {
    public FailedFileCreationException() {
        super("Error in creation of file that already exists");
    }
}
