package com.example.librarymanagementsystem.Models;

import com.example.librarymanagementsystem.Enums.Status;

import java.util.UUID;

public class Session extends Entity {
    private User user;

    public Session() {
        super(UUID.randomUUID().toString(), Status.ACTIVE);
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
