module com.example.firstscene {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.firstscene to javafx.fxml;
    exports com.example.firstscene;
}