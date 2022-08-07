package com.example.users.FXMLController;

import com.example.users.DataBase.DataBase;
import com.example.users.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MyProfile implements Initializable {
    private static int state = 2;
    @FXML
    private ScrollPane myProScrollPane;
    @FXML
    private VBox mainVBox;
    private double scale;
    private Color mode;
    private Color themeColor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scale = Creator.getScale();
        initial();
        try {
            this.mainVBox.setPrefHeight(this.mainVBox.getPrefHeight() + 180 * scale);
            this.mainVBox.getChildren().add((Pane) addHeader());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.mainVBox.setPrefHeight(this.mainVBox.getPrefHeight() + Creator.getUsersPostVBox() * scale);
        this.mainVBox.getChildren().add(Creator.showUserPosts(DataBase.getUser(), this.scale));
    }

    public void initial() {

        theme();
        this.myProScrollPane.setPrefWidth(600 * scale);
        this.myProScrollPane.setPrefHeight(600 * scale);
        this.mainVBox.setPrefWidth(600 * scale);

        this.mainVBox.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.myProScrollPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
    }

    public Node addHeader() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MyProfileHeader.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public void theme() {
        switch (DataBase.getTheme()) {
            case 1:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.WHITE;
                break;
            case 2:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.BLACK;
                break;
            case 3:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.WHITE;
                break;
            case 4:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.BLACK;
                break;
        }
    }

}
