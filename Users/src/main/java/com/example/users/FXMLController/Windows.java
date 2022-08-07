package com.example.users.FXMLController;

import com.example.users.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Windows {
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void load(Stage stage) {
        Windows.stage = stage;
    }

    public static void myProfile() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("MyProfile.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("My Twitter");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public static void othersProfile() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("Requests.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("My Twitter");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
