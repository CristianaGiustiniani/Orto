package com.orto.logic.controller.bean;

import com.orto.logic.controller.bean.exceptions.EmptyEmailException;
import com.orto.logic.controller.bean.exceptions.EmptyPasswordException;
import com.orto.logic.controller.bean.exceptions.InvalidStringException;

import java.util.regex.Pattern;

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

        boolean ok = Pattern.compile("[a-zA-Z0-9]").matcher(string).find();
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
