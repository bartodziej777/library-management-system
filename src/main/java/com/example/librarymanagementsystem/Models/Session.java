package com.example.librarymanagementsystem.Models;

import java.util.UUID;

public class Session extends Entity {
    private final int sessionID;
    private User user;

    public Session(int sessionID) {
        super(UUID.randomUUID().toString());
        this.sessionID = sessionID;
    }

    public void logout() {
        this.user = null;
    }

    public void login(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
