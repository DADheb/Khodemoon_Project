package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OthersProfile implements Initializable {
    @FXML
    private VBox mainVBox;
    @FXML
    private ScrollPane otherProScrollPane;
    private double scale;
    private Color mode;
    private Color themeColor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scale = Creator.mainScale;
        initial();
        try {
            this.mainVBox.setPrefHeight(this.mainVBox.getPrefHeight() + 180 * scale);
            this.mainVBox.getChildren().add(addHeader());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        Creator.user = DataBase.getUser();
        try {
            node = Creator.showUserPosts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.mainVBox.setPrefHeight(this.mainVBox.getPrefHeight() + Creator.usersPostVBox * scale);
        this.mainVBox.getChildren().add(node);
    }

    public void initial() {

        theme();
        this.otherProScrollPane.setPrefWidth(600 * scale);
        this.otherProScrollPane.setPrefHeight(600 * scale);
        this.mainVBox.setPrefWidth(600 * scale);
        this.mainVBox.setPrefHeight(600 * scale);

        this.mainVBox.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.otherProScrollPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
    }

    public Node addHeader() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GraphicObjects/OthersProfileHeader.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public void theme() {
        switch (DataBase.theme) {
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
