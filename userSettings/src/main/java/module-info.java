module com.example.usersettings {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.usersettings to javafx.fxml;
    exports com.example.usersettings;
    exports com.example.usersettings.FXMLController;
    opens com.example.usersettings.FXMLController to javafx.fxml;
}