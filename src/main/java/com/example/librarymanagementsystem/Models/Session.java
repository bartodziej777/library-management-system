package com.example.librarymanagementsystem.Models;

import java.util.UUID;

public class Session extends Entity {
    private User user;

    public Session() {
        super(UUID.randomUUID().toString());
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
