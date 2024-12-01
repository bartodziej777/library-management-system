module com.example.librarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires java.desktop;

    opens com.example.librarymanagementsystem to javafx.fxml;
    exports com.example.librarymanagementsystem;
    exports com.example.librarymanagementsystem.Controllers;
    exports com.example.librarymanagementsystem.Models;
    //exports com.example.librarymanagementsystem.Controllers.Admin;
    //exports com.example.librarymanagementsystem.Controllers.Client;
    //exports com.example.librarymanagementsystem.Views;
}