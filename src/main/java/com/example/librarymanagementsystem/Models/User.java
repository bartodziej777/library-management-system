package com.example.librarymanagementsystem.Models;

import java.util.UUID;

public class User extends Entity {
    private final String password;

    public User(String name, String password) {
        super(name);
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
