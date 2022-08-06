module com.example.users {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.users to javafx.fxml;
    exports com.example.users;
    exports com.example.users.Models;
    exports com.example.users.FXMLController;
    opens com.example.users.Models to javafx.fxml;
    opens com.example.users.FXMLController to javafx.fxml;
}