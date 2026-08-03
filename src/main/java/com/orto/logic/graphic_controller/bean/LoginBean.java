package com.orto.logic.graphic_controller.bean;

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
        boolean ok = string.matches("[a-zA-Z0-9]+");
        if (!ok) {
            throw new InvalidStringException();
        }
    }

    public void validate() throws InvalidStringException {
        try {
            validateString(email);
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Email has no characters or digits");
        }

        try {
            validateString(password);
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Password has no characters or digits");
        }
    }
}
