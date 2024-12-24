package com.example.librarymanagementsystem.Models;

import java.time.LocalDate;
import java.util.UUID;

public class Book extends Entity {
    private int releaseYear;
    private String author;
    private boolean isAvailable;
    private LocalDate loanDue;
    private User loanBy;

    public Book(String title, String author, int releaseYear) {
        super(title);
        this.author = author;
        this.releaseYear = releaseYear;
        this.isAvailable = true;
        this.loanDue = null;
        this.loanBy = null;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean getIsAvailable() {
        return isAvailable;
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
