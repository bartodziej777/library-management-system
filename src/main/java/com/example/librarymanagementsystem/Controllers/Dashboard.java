package com.example.librarymanagementsystem.Controllers;

import com.example.librarymanagementsystem.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class Dashboard {
    @FXML public AnchorPane contentRoot;

    private final String[] views = {"/views/searchBooks.fxml", "/views/myBooks.fxml", "/views/favorites.fxml", "/views/searchBooks.fxml", "/views/addBook.fxml"};

    @FXML public void changeView(int viewNum) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(views[viewNum-1]));
            AnchorPane newView = loader.load();

            contentRoot.getChildren().removeAll();
            contentRoot.getChildren().setAll(newView);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML public void handleMenuBtn1() {
        changeView(1);
    }

    @FXML public void handleMenuBtn2() {
        changeView(2);
    }

    @FXML public void handleMenuBtn3() {
        changeView(3);
    }

    @FXML public void handleMenuBtn4() {
        changeView(4);
    }

    @FXML public void handleMenuBtn5() {
        changeView(5);
    }


    @FXML public void handleLogout() {
        App.session.logout();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
            Scene scene = new Scene(loader.load());
            Stage currentStage = (Stage) contentRoot.getScene().getWindow();
            currentStage.setScene(scene);
            currentStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Dashboard() {
    }
}
