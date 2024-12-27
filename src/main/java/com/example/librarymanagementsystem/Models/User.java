package com.example.librarymanagementsystem.Models;

import com.example.librarymanagementsystem.Enums.Status;

public class User extends Entity {
    private final String password;

    public User(String name, String password) {
        super(name, Status.ACTIVE);
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
