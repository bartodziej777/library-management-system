package com.example.librarymanagementsystem.Models;

import com.example.librarymanagementsystem.Enums.UserType;

public class Client extends User {
    private UserType type = UserType.CLIENT;

    public Client(String login, String password) {
        super(login, password);
    }
}
