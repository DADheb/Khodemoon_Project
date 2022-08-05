module com.example.demotwitterpost {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demotwitterpost to javafx.fxml;
    exports com.example.demotwitterpost;
}