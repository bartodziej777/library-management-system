package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.App;
import com.example.librarymanagementsystem.Enums.Status;
import com.example.librarymanagementsystem.Interfaces.LoanOperations;
import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Models.Librarian;
import com.example.librarymanagementsystem.Models.Library;
import com.example.librarymanagementsystem.Models.Reader;
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

public class SearchBooks implements LoanOperations {
    @FXML public TextField searchbar;
    @FXML public Button searchBtn;
    @FXML public Button clearBtn;
    @FXML public VBox booksContainer;
    List<Book> books;
    List<Book> filteredBooks;

    public SearchBooks() {
        books = Library.getBooks();
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

            if(book.getStatus() == Status.UNAVAILABLE && book.getLoanBy() == App.session.getUser()) {
                availabilityLabel.getStyleClass().add("green");
                availabilityLabel.setText("You have this book until: " + book.getLoanDue().toString());
                if(App.session.getUser() instanceof  Librarian) {
                    actionButton.setText("Delete");
                    actionButton.setDisable(true);
                }
                actionButton.setText("Return");
                actionButton.getStyleClass().add("borrow-btn");
                actionButton.setOnAction(e -> handleReturnBook(book.getID()));
            }
            else if(book.getStatus() == Status.AVAILABLE) {
                availabilityLabel.getStyleClass().add("green");
                availabilityLabel.setText("Book is available now");
                actionButton.getStyleClass().add("borrow-btn");
                if(App.session.getUser() instanceof  Librarian) {
                    actionButton.setText("Delete");
                    actionButton.setOnAction(e -> handleDeleteBook(book.getID()));
                }
                else {
                    actionButton.setOnAction(e -> handleBorrowBook(book));
                }
            }
            else {
                availabilityLabel.getStyleClass().add("red");
                availabilityLabel.setText("Book will be available since: " + book.getLoanDue().toString());
                actionButton.setDisable(true);
                if(App.session.getUser() instanceof  Librarian) {
                    actionButton.setText("Delete");
                }
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

    @Override
    public void handleBorrowBook(Book book) {
        Library.borrowBook(App.session.getUser(), book.getID(), 14);
        ((Reader) App.session.getUser()).handleBorrowBook(book);
        handleSearch();
    }

    @Override
    public void handleReturnBook(int bookID) {
        Library.returnBook(App.session.getUser(), bookID);
        ((Reader) App.session.getUser()).handleReturnBook(bookID);
        handleSearch();
    }

    public void handleDeleteBook(int bookID) {
        Library.removeBook(bookID);
        handleSearch();
    }
}
