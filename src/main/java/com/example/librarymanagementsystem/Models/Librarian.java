package com.example.librarymanagementsystem.Models;

public class Librarian extends User {
    private String firstName, lastName;

    public Librarian(String name, String password) {
        super(name, password);
    }
}
