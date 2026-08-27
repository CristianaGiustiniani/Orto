package com.orto.logic.utils;


import com.orto.logic.model.entity.User;

import java.util.UUID;

public class Session {
    private final String sessionId;
    private final User loggedUser;

    public Session(User user) {
        if (user == null) {
            throw new IllegalArgumentException("A session requires a user");
        }
        this.sessionId = UUID.randomUUID().toString();
        this.loggedUser = user;
    }

    public String getSessionId() {
        return sessionId;
    }
    public User getUser() {
        return loggedUser;
    }
}
