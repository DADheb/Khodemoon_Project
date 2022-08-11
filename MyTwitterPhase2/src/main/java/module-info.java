module com.example.mytwitterphase2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mytwitterphase2 to javafx.fxml;
    exports com.example.mytwitterphase2;
    exports com.example.mytwitterphase2.FXMLController;
    opens com.example.mytwitterphase2.FXMLController to javafx.fxml;
    exports com.example.mytwitterphase2.FXMLController.Objects;
    opens com.example.mytwitterphase2.FXMLController.Objects to javafx.fxml;
}