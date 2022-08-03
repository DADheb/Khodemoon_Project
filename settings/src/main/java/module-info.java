module com.example.settings {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.settings to javafx.fxml;
    exports com.example.settings;
    exports com.example.settings.FXMLController;
    opens com.example.settings.FXMLController to javafx.fxml;

}