package com.example.librarymanagementsystem;

import com.example.librarymanagementsystem.Models.Session;
import com.example.librarymanagementsystem.Models.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static Session session = new Session(1);
    @Override
    public void start(Stage primaryStage) throws Exception{
        UserService.ShowAllUsers();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
            primaryStage.setTitle("Library Management System");
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
