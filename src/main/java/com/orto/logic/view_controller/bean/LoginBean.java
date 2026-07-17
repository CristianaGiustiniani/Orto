package com.orto.logic.view_controller.bean;

import com.orto.logic.view_controller.bean.exceptions.InvalidStringException;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class LoginBean {
    private String username;
    private String email;
    private String password;
    private boolean rememberUser;

    //GETTERS AND SETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws InvalidStringException {
        try {
            validateString(username);
            this.username = username;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Username has no characters or digits");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidStringException {
        try {
            validateString(email);
            this.email = email;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Email has no characters or digits");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidStringException {
        try {
            validateString(password);
            this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Email has no characters or digits");
        }
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
}
