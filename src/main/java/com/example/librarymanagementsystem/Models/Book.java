package com.example.librarymanagementsystem.Models;

import com.example.librarymanagementsystem.Enums.Status;

import java.time.LocalDate;

public class Book extends Entity {
    private int releaseYear;
    private String author;
    private LocalDate loanDue;
    private User loanBy;

    public Book(String title, Status status, String author, int releaseYear) {
        super(title, status);
        this.author = author;
        this.releaseYear = releaseYear;
        this.loanDue = null;
        this.loanBy = null;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setLoanDue(LocalDate loanDue) {
        this.loanDue = loanDue;
    }

    public LocalDate getLoanDue() {
        return loanDue;
    }

    public void setLoanBy(User user) {
        this.loanBy = user;
    }

    public User getLoanBy() {
        return loanBy;
    }
}
