package com.example.librarymanagementsystem.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.ArrayList;

public class ClientDashboard {
    @FXML public AnchorPane contentRoot;

    private final String[] views = {"/views/searchBooks.fxml", "/views/myBooks.fxml", "/views/favorites.fxml", "/views/history.fxml"};

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

    @FXML public void handleLogout() {
        System.out.println("Logout");
    }

    public ClientDashboard() {
    }
}
