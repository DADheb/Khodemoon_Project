package com.example.mytwitterphase2;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Creator;
import com.example.mytwitterphase2.FXMLController.Main;
import com.example.mytwitterphase2.FXMLController.Objects.Waiter;
import com.example.mytwitterphase2.SQL.SQL;
import com.example.mytwitterphase2.entity.Chat;
import com.example.mytwitterphase2.entity.Message;
import com.example.mytwitterphase2.entity.User;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;


public class MainGraphic extends Application {
    static public Stage window;
    @Override
    public void start(Stage stage) throws IOException, SQLException, InterruptedException {
        window = stage;
        Scene scene = new Scene(DataBase.main.main,1000,600);
        stage.setScene(scene);
        stage.setTitle("MICHKA");
        stage.getIcons().add(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/Michka.png")).toExternalForm()));
        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                try {
                    DataBase.main.setWidth(stage.getWidth());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                try {
                    DataBase.main.setHeight(stage.getHeight());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        stage.show();
        DataBase.main.refresh();
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234");
        DataBase.setConnection(connection);
        SQL.getDatabaseInitializer().createTables(connection);
        SQL.loadAll(connection);
        Main main = new Main();
        DataBase.main = main;
        Waiter waiter = new Waiter();
        DataBase.waiter = waiter;
        launch();
    }
}