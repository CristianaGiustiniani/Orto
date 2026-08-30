package com.orto.logic.model.dao.exceptions;

public class ConnectionException extends Exception{
    public ConnectionException() {
        super("An error occurred during connection to the persistence layer");
    }
    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(Throwable cause) {
        super(cause);
    }
}
