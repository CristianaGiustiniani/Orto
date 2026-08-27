package com.orto.logic.utils;

import com.orto.logic.model.entity.User;
import com.orto.logic.utils.exceptions.IllegalNullUserException;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {
    private static final SessionManager instance = new SessionManager();
    private final Map<String, Session> sessions = new ConcurrentHashMap<>();
    private volatile String currentSessionId;

    public static SessionManager getInstance() {
        return instance;
    }

    public String createSession(User user) {
        Session session = new Session(user);
        sessions.put(session.getSessionId(), session);
        currentSessionId = session.getSessionId();
        return session.getSessionId();
    }

    public Session getSession(String sessionId) {
        return sessionId == null ? null : sessions.get(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionId != null && sessions.containsKey(sessionId);
    }

    public boolean hasActiveSessionForUser(User user) {
        if (user == null) {
            return false;
        }
        return sessions.values().stream()
                .map(Session::getUser)
                .anyMatch(activeUser -> Objects.equals(activeUser.getUsername(), user.getUsername()));
    }

    public void removeSession(String sessionId) {
        if (sessionId != null) {
            sessions.remove(sessionId);
            if (sessionId.equals(currentSessionId)) {
                currentSessionId = null;
            }
        }
    }

    public String getCurrentSessionId() {
        return currentSessionId;
    }

    public Session getCurrentSession() {
        return getSession(currentSessionId);
    }

    public boolean isLogged() {
        return isSessionValid(currentSessionId);
    }

    public User getLoggedUser() throws IllegalNullUserException {
        Session session = getCurrentSession();
        if (session == null) {
            throw new IllegalNullUserException();
        }
        return session.getUser();
    }

}
