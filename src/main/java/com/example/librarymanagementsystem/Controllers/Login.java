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
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/readerDashboard.fxml"));
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

import com.example.librarymanagementsystem.App;
import com.example.librarymanagementsystem.Models.Reader;
import com.example.librarymanagementsystem.Models.User;
import com.example.librarymanagementsystem.Models.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Login {
    @FXML public TextField login, password;
    @FXML public Button button;
    @FXML public Label error;

    private final String[] views = {"/views/readerDashboard.fxml", "/views/librarianDashboard.fxml"};

    @FXML
    public void handleLogin() {
        User user = UserService.authenticate(login.getText(), password.getText());
        if(user!=null) {
            try {
                App.session.login(user);
                FXMLLoader loader = new FXMLLoader(getClass().getResource(user instanceof Reader ? views[0] : views[1]));
                Scene scene = new Scene(loader.load());
                Stage currentStage = (Stage) button.getScene().getWindow();
                currentStage.setScene(scene);
                currentStage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else {
            error.setText("Login Failed");
            error.setOpacity(1);
        }
    }
}
