//package com.example.librarymanagementsystem.Controllers;
//
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class Login {
//
//    public Button loginBtn;
//    @FXML
//    public AnchorPane rootPane; // Zakładamy, że rootPane to kontener w FXML, który chcesz zaktualizować.
//
//    // Metoda obsługująca kliknięcie przycisku Login
//    @FXML
//    public void handleLogin() {
//        System.out.println("Login Button clicked");
//
//        try {
//            // Ładujemy nowy plik FXML (view1.fxml)
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/clientDashboard.fxml"));
//            AnchorPane newView = loader.load();
//
//            // Zamieniamy zawartość kontenera (rootPane) na nowy widok
//            rootPane.getChildren().setAll(newView);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
package com.example.librarymanagementsystem.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;

public class Login {
    @FXML
    public TextField login, password;
    @FXML
    public Button button;

    @FXML
    public void handleLogin() {
        System.out.println("Login");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/clientDashboard.fxml"));
            Scene scene = new Scene(loader.load());
            Stage currentStage = (Stage) button.getScene().getWindow();
            currentStage.setScene(scene);
            currentStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
