package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.Models.Book;
import com.example.librarymanagementsystem.Models.Library;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class AddBook {
    @FXML public TextField title;
    @FXML public TextField author;
    @FXML public TextField releaseYear;
    @FXML public Label statusLabel;

    public AddBook() {
    }

    public void handleAddBook() {
        String bookTitle = title.getText();
        String bookAuthor = author.getText();
        String releaseYearInput = releaseYear.getText();

        if (bookTitle == null || bookTitle.trim().isEmpty() || bookAuthor == null || bookAuthor.trim().isEmpty()) {
            statusLabel.setText("Book's title and author's name cannot be empty");
            statusLabel.setOpacity(1);
            return;
        }

        int releaseYearValue;
        try {
            releaseYearValue = Integer.parseInt(releaseYearInput);
        } catch (NumberFormatException e) {
            statusLabel.setText("Release year is not a number");
            statusLabel.setOpacity(1);
            return;
        }

        statusLabel.setOpacity(0);

        Book book = new Book(bookTitle, bookAuthor, releaseYearValue);
        Library.addBook(book);

        Stage popupStage = new Stage();
        popupStage.initStyle(StageStyle.UNDECORATED);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #323232; -fx-padding: 20px;");

        Text text = new Text("Book added successfully");
        text.setStyle("-fx-fill: white; -fx-font-size: 16px;");

        root.getChildren().add(text);

        Scene scene = new Scene(root);
        popupStage.setScene(scene);
        popupStage.show();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                popupStage.close();
                title.setText("");
                author.setText("");
                releaseYear.setText("");
            });
        }).start();
    }
}