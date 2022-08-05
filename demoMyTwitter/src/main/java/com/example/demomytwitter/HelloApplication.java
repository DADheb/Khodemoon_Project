package com.example.demomytwitter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void load(Stage stage) {
        HelloApplication.stage = stage;
    }
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LogIn.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}