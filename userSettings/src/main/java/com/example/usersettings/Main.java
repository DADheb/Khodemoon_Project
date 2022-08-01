package com.example.usersettings;

import com.example.usersettings.DataBase.DataBase;
import com.example.usersettings.FXMLController.Windows;
import com.example.usersettings.Models.User;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        User user = new User("tina.hlm");
        DataBase.setUser(user);
        stage.setHeight(400);
        stage.setWidth(600);
        Windows.load(stage);
        Windows.setting();
    }

    public static void main(String[] args) {
        launch();
    }
}
