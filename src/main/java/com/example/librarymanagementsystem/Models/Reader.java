package com.example.librarymanagementsystem.Models;

import com.example.librarymanagementsystem.Interfaces.LoanOperations;

import java.util.ArrayList;
import java.util.List;

public class Reader extends User implements LoanOperations {
    List<Book> books = new ArrayList<>();

    public Reader(String username, String password) {
        super(username, password);
    }

    @Override
    public void borrowBook() {

    }

    @Override
    public void returnBook() {

    }
}
