package com.example.librarymanagementsystem.Models;

import com.example.librarymanagementsystem.Enums.UserType;

public class Admin extends User {
    private UserType type = UserType.ADMIN;

    public Admin(String login, String password) {
        super(login, password);
    }
}
