package com.example.librarymanagementsystem.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    public TextField login, password;
    public Button button;

    @FXML
    public void handleMouseClick(ActionEvent mouseEvent) {
        System.out.println("Click");
    }
}
