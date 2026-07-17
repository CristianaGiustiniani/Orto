package com.orto.logic.utils;


import com.orto.logic.model.entity.User;

public class Session {
    private static Session instance = null;

    private User loggedUser = null;

    private Session() {}

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public void logout() {
        this.loggedUser = null;
    }

    public boolean isLogged() {
        return (this.loggedUser != null);
    }
}
