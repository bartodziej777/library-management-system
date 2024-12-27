package com.example.librarymanagementsystem.Interfaces;

import com.example.librarymanagementsystem.Models.Book;

public interface LoanOperations {
    void handleBorrowBook(Book book);

    void handleReturnBook(int bookID);
}
