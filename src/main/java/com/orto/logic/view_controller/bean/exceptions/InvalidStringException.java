package com.orto.logic.view_controller.bean.exceptions;

public class InvalidStringException extends Exception {

    public InvalidStringException() {
        super();
    }
    public InvalidStringException(String s) {
        super(s);
    }
}
