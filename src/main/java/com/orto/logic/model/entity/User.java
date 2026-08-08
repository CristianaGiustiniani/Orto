package com.orto.logic.model.entity;

import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class User {
    private Integer id;
    private final String username;
    private final String name;
    private final String surname;
    private String hashedPassword;

    public User(String username, String name, String surname) {
        this.username = username;
        this.name = name;
        this.surname = surname;
    }

    public User(Integer id, String username, String name, String surname) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
    }

    public User(String username, String name, String surname, String hashedPassword) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.hashedPassword = hashedPassword;
    }

    public User(Integer id, String username, String name, String surname, String hashedPassword) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.hashedPassword = hashedPassword;
    }


    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void checkPassword(String password) throws WrongPasswordException {
        if (!(BCrypt.checkpw(password, this.hashedPassword))) {
            throw new WrongPasswordException();
        }
    }
}
