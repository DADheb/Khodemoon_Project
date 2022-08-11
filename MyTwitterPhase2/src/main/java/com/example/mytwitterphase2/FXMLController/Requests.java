package com.example.mytwitterphase2.FXMLController;


import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Requests implements Initializable {
    @FXML
    private ScrollPane requestsScrollPane;
    @FXML
    private Pane topPane;
    @FXML
    private ImageView backImage;
    @FXML
    private Label titleL;
    @FXML
    private VBox mainVBox;
    private double scale;
    private Color themeColor;
    private Color mode;
    private Image image;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scale = Creator.mainScale;
        initial();
        Node node;
        for (int i = 0; i < DataBase.getUser().getRequests().size(); i++) {
            try {
                mainVBox.setPrefHeight(mainVBox.getPrefHeight() + 90 * this.scale);
                node = Creator.showRequestShortUser(DataBase.getUser().getRequests().get(i), this.scale);
                mainVBox.getChildren().add(node);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void initial() {
        theme();
        mainVBox.setPrefWidth(600 * scale);
        requestsScrollPane.setPrefWidth(600 * scale);
        requestsScrollPane.setPrefHeight(600 * scale);
        topPane.setPrefWidth(600 * scale);
        topPane.setPrefHeight(50 * scale);
        titleL.setFont(Font.font(24 * scale));
        titleL.setLayoutX(218 * scale);
        titleL.setLayoutY(11 * scale);
        backImage.setLayoutX(14 * scale);
        backImage.setLayoutY(11 * scale);
        backImage.setFitWidth(29 * scale);
        backImage.setFitHeight(33 * scale);

        topPane.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));
        mainVBox.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        requestsScrollPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        titleL.setTextFill(mode);
    }

    public void theme() {
        switch (DataBase.theme) {
            case 1:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackDark.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 2:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 3:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackDark.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 4:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
        }
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 7 ;
        DataBase.main.setMenuPane();
    }

}
