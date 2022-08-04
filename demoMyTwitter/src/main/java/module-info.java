module com.example.demomytwitter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demomytwitter to javafx.fxml;
    exports com.example.demomytwitter;
}