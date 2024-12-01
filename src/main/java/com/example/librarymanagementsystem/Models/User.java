package com.example.librarymanagementsystem.Models;

import java.util.UUID;

public class User {
    private UUID userID;
    private final String login, password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UUID getUserID() {
        return this.userID;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }
}
