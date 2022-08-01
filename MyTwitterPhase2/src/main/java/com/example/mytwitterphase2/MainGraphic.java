package com.example.mytwitterphase2;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.SQL.SQL;
import com.example.mytwitterphase2.entity.Group;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainGraphic extends Application {
    static public Stage window;
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("ChatGroup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 415, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        /*stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                Scene scene1;
                try {
                    DataBase.setScale(stage.getWidth()/600);
                    FXMLLoader fxmlLoader1 = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ShortGroup.fxml"));
                    scene1 = new Scene(fxmlLoader1.load(), 600, 150);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setScene(scene1);
            }
        });*/
        stage.show();
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234");
        DataBase.setConnection(connection);
        SQL.getDatabaseInitializer().createTables(connection);
        SQL.loadAll(connection);
        launch();
    }
}