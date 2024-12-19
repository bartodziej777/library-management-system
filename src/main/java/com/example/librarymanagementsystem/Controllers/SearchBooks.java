package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.App;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Models.Library;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SearchBooks {
    @FXML public TextField searchbar;
    @FXML public Button searchBtn;
    @FXML public Button clearBtn;
    @FXML public VBox booksContainer;
    List<Book> books;
    List<Book> filteredBooks;

    public SearchBooks() {
        books = Library.getBooks();
        books.getFirst().setLoanDue(LocalDate.of(2025, 3, 2));
        books.getFirst().setIsAvailable(false);
    }

    @FXML
    public void initialize() {
        displayResults(books);
    }

    public void displayResults(List<Book> books) {
        booksContainer.getChildren().clear();
        int counter = 0;
        for (Book book : books) {
            counter++;
            BorderPane bookPane = new BorderPane();
            bookPane.getStyleClass().add("book-pane");
            if(counter % 2 == 0) bookPane.getStyleClass().add("book-pane-color");
            bookPane.setPrefSize(600.0, 75.0);

            Label availabilityLabel = new Label();
            Button actionButton = new Button("Borrow");

            if(!book.getIsAvailable() && book.getLoanBy() == App.session.getUser()) {
                availabilityLabel.getStyleClass().add("green");
                availabilityLabel.setText("You have this book until: " + book.getLoanDue().toString());
                actionButton.setText("Return");
                actionButton.getStyleClass().add("borrow-btn");
                actionButton.setOnAction(e -> handleReturnBook(book.getID()));
            }
            else if(book.getIsAvailable()) {
                availabilityLabel.getStyleClass().add("green");
                availabilityLabel.setText("Book is available now");
                actionButton.getStyleClass().add("borrow-btn");
                actionButton.setOnAction(e -> handleBorrowBook(book.getID()));
            }
            else {
                availabilityLabel.getStyleClass().add("red");
                availabilityLabel.setText("Book will be available since: " + book.getLoanDue().toString());
                actionButton.setDisable(true);
                actionButton.getStyleClass().add("borrow-btn--inactive");
            }

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

    public void handleSearch() {
        filteredBooks = books.stream().filter(book -> book.getName().toLowerCase().contains(searchbar.getText().toLowerCase()) || book.getAuthor().toLowerCase().contains(searchbar.getText().toLowerCase())).collect(Collectors.toList());
        displayResults(filteredBooks);
    }

    public void handleClear() {
        searchbar.setText("");
        displayResults(books);
    }

    public void handleBorrowBook(int bookID) {
        Library.borrowBook(App.session.getUser(), bookID, 14);
        handleSearch();
    }

    public void handleReturnBook(int bookID) {
        Library.returnBook(App.session.getUser(), bookID);
        handleSearch();
    }
}
