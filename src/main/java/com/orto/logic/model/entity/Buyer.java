package com.orto.logic.model.entity;

public class Buyer extends User {
    public Buyer(String username, String name, String surname) {
        super(username, name, surname);
    }

    public Buyer(Integer id, String username, String name, String surname) {
        super(id, username, name, surname);
    }
}
