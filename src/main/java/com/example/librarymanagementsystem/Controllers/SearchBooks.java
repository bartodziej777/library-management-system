package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Models.Library;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

public class SearchBooks {
    @FXML public VBox booksContainer;

    public SearchBooks() {
        List<Book> books = Library.getBooks();
        for (Book book : books) {
            System.out.println(book);
            Label bookContainer = new Label();
            bookContainer.setText(book.getName());
            booksContainer.getChildren().add(bookContainer);
        }
    }
}
