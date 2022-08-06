package com.example.users;

import com.example.users.DataBase.DataBase;
import com.example.users.FXMLController.Creator;
import com.example.users.FXMLController.Windows;
import com.example.users.Models.User;
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
        Creator.setOthersProfileHeaderUser(user);
        stage.setHeight(600);
        stage.setWidth(400);
        Windows.load(stage);
      //  Windows.myProfile();
        Windows.othersProfile();
    }

    public static void main(String[] args) {
        launch();
    }
}
