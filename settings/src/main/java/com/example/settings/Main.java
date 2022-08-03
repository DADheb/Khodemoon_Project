package com.example.settings;

import com.example.settings.DataBase.DataBase;
import com.example.settings.FXMLController.Windows;
import com.example.settings.Models.User;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        User user = new User("tina.hlm","12345678","its tina", "TINA","Halimi","2003-05-27","t@gmail.com","khar",false,true);
        DataBase.setUser(user);
        stage.setHeight(600);
        stage.setWidth(1000);
        Windows.load(stage);
        Windows.setting();
    }

    public static void main(String[] args) {
        launch();
    }
}

