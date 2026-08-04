package com.orto.logic.model.dao.exceptions;

import java.io.IOException;

public class ConnectionException extends Exception{
    public ConnectionException() {
        super("Error in connection");
    }

    public ConnectionException(Throwable cause) {
        super(cause);
    }
}
