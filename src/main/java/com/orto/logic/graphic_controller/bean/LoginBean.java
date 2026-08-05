package com.orto.logic.graphic_controller.bean;

import com.orto.logic.graphic_controller.bean.exceptions.EmptyEmailException;
import com.orto.logic.graphic_controller.bean.exceptions.EmptyPasswordException;
import com.orto.logic.graphic_controller.bean.exceptions.InvalidStringException;

public class LoginBean {
    private String email;
    private String password;
    private boolean rememberUser;

    //GETTERS AND SETTERS
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberUser() {
        return rememberUser;
    }

    public void setRememberUser(boolean rememberUser) {
        this.rememberUser = rememberUser;
    }

    //DATA VALIDATION METHODS
    private void validateString(String string) throws InvalidStringException {
        boolean ok = string.matches(".*\\S.*");
        if (!ok) {
            throw new InvalidStringException();
        }
    }

    public void validate() throws EmptyEmailException, EmptyPasswordException {
        try {
            validateString(email);
        } catch (InvalidStringException e) {
            throw new EmptyEmailException();
        }

        try {
            validateString(password);
        } catch (InvalidStringException e) {
            throw new EmptyPasswordException();
        }
    }
}
