package com.orto.logic.model.entity.exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {super("Wrong password");
    }

    public WrongPasswordException(String message) {
    super(message);
  }

}
