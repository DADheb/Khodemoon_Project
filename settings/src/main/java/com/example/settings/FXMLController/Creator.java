package com.example.settings.FXMLController;

import com.example.settings.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class Creator {
    private static double scale;

    public static double getScale() {
        return scale;
    }

    public static Node showSettings(double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Setting.fxml"));
        node = fxmlLoader.load();
        return node;
    }
}
