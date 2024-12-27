package com.example.librarymanagementsystem.Models;

import com.example.librarymanagementsystem.Enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private static final List<Book> books = new ArrayList<>(loadDefaultBooks());

    public Library() {}

    public static void borrowBook(User user, int bookID, int borrowingDays) {
        Book borrowedBook = null;
        for (Book book : books) {
            if (book.getID() == bookID) {
                borrowedBook = book;
            }
        }
        if (borrowedBook != null) {
            borrowedBook.setStatus(Status.UNAVAILABLE);
            borrowedBook.setLoanDue(LocalDate.now().plusDays(borrowingDays));
            borrowedBook.setLoanBy(user);
        }
    }

    public static void returnBook(User user, int bookID) {
        Book returnedBook = null;
        for (Book book : books) {
            if (book.getID() == bookID && book.getLoanBy() == user) {
                returnedBook = book;
                returnedBook.setStatus(Status.AVAILABLE);
                returnedBook.setLoanDue(null);
                returnedBook.setLoanBy(null);
            }
        }
    }

    //loading predefined books enabling program demonstrations
    private static List<Book> loadDefaultBooks() {
        List<Book> defaultBooks = new ArrayList<>();
        defaultBooks.add(new Book("Harry Potter", Status.AVAILABLE,"JK.Rowling", 1997));
        defaultBooks.add(new Book("1984", Status.AVAILABLE,"George Orwell", 1949));
        defaultBooks.add(new Book("The Hobbit", Status.AVAILABLE,"JRR Tolkien", 1937));
        return defaultBooks;
    }

    public static void addBook(Book book){
        books.add(book);
    }

    public static void removeBook(int bookID){
        books.removeIf(book -> book.getID() == bookID);
    }

    public static List<Book> getBooks() {
        return books;
    }
}
