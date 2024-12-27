package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.App;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Models.Library;
import com.example.librarymanagementsystem.Models.Reader;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

import java.util.List;

public class MyBooks {
    @FXML public VBox booksContainer;
    Reader reader = (Reader) App.session.getUser();
    List<Book> books;

    public MyBooks() {}

    @FXML
    public void initialize() {
        displayBooks();
    }

    public void displayBooks() {
        books = reader.getBooks();

        booksContainer.getChildren().clear();
        Label countLabel = new Label("You have " + books.size() + " books");
        countLabel.getStyleClass().add("count-label");
        booksContainer.getChildren().add(countLabel);


        for (Book book : books) {
            BorderPane bookPane = new BorderPane();
            bookPane.getStyleClass().add("book-pane");

            bookPane.getStyleClass().add(books.indexOf(book) % 2 == 0 ? "book-pane-color" : "");

            bookPane.setPrefSize(600.0, 75.0);

            Label availabilityLabel = new Label("You have this book until: " + book.getLoanDue().toString());
            availabilityLabel.getStyleClass().add("green");
            Button actionButton = new Button("Return");
            actionButton.getStyleClass().add("borrow-btn");
            actionButton.setOnAction(e -> handleReturnBook(book.getID()));

            BorderPane.setAlignment(availabilityLabel, javafx.geometry.Pos.TOP_RIGHT);
            bookPane.setBottom(availabilityLabel);

            BorderPane.setAlignment(actionButton, javafx.geometry.Pos.TOP_CENTER);
            bookPane.setRight(actionButton);

            VBox detailsBox = new VBox();
            detailsBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
            detailsBox.setPrefSize(600.0, 119.0);

            Label titleLabel = new Label(book.getName());
            titleLabel.setFont(new Font(20.0));
            titleLabel.getStyleClass().add("book-label");

            Label authorLabel = new Label(book.getAuthor());
            authorLabel.setFont(new Font(12.0));
            authorLabel.getStyleClass().add("book-label");

            detailsBox.getChildren().addAll(titleLabel, authorLabel);
            BorderPane.setAlignment(detailsBox, javafx.geometry.Pos.CENTER);
            bookPane.setLeft(detailsBox);

            BorderPane.setMargin(bookPane, new Insets(10.0, 20.0, 10.0, 20.0));

            booksContainer.getChildren().add(bookPane);
        }
    }

    public void handleReturnBook(int bookID) {
        Library.returnBook(App.session.getUser(), bookID);
        reader.handleReturnBook(bookID);
        displayBooks();
    }
}
