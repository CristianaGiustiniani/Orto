package com.orto.logic.model.dao.exceptions;

import java.io.IOException;

public class FailedFileCreationException extends IOException {
    public FailedFileCreationException() {
        super("Error in creation of file that already exists");
    }
}
