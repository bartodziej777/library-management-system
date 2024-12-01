package com.example.librarymanagementsystem.Models;

import java.util.UUID;

public class Session {
    private int sessionID;
    private boolean active;
    private UUID loggedUserID;

    public Session(int sessionID) {
        this.sessionID = sessionID;
    }

    public void logout() {
        this.active = false;
        this.loggedUserID = null;
    }

    public void login(UUID userID) {
        this.active = true;
        this.loggedUserID = userID;
    }
}
