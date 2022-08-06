package com.example.users.FXMLController;

import com.example.users.DataBase.DataBase;
import com.example.users.Main;
import com.example.users.Models.User;
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
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Followings implements Initializable {
    @FXML
    private ScrollPane followingsScrollPane;
    @FXML
    private Pane topPane;
    @FXML
    private ImageView backImage;
    @FXML
    private Label titleFollowingL;
    @FXML
    private VBox mainVBox;
    private double scale;
    private Color themeColor;
    private Color mode;
    private Image image;
    private User user;
    private ArrayList<User> usersToShow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scale = Creator.getScale();
        initial();
        Node node;
        for (int i = 0; i < usersToShow.size(); i++) {
            try {
                mainVBox.setPrefHeight(mainVBox.getPrefHeight() + 90 * this.scale);
                node = Creator.showShortUser(usersToShow.get(i), this.scale);
                mainVBox.getChildren().add(node);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void initial() {
        theme();
        setValue();
        followingsScrollPane.setPrefWidth(600 * scale);
        followingsScrollPane.setPrefHeight(600 * scale);
        mainVBox.setPrefWidth(600 * scale);
        topPane.setPrefWidth(600 * scale);
        topPane.setPrefHeight(50 * scale);
        titleFollowingL.setFont(Font.font(24 * scale));
        titleFollowingL.setLayoutX(239 * scale);
        titleFollowingL.setLayoutY(11 * scale);
        backImage.setLayoutX(14 * scale);
        backImage.setLayoutY(4 * scale);
        backImage.setFitWidth(43 * scale);
        backImage.setFitHeight(48 * scale);

        topPane.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));
        titleFollowingL.setTextFill(mode);
    }

    public void setValue() {
        String s = Creator.getFollowerOrFollowing();
        this.user = Creator.getUserToShow();
        if (s.equals("Followings")) {
            usersToShow = this.user.getFollowings();
        } else if (s.equals("Followers")) {
            usersToShow = this.user.getFollowers();
        }
        this.titleFollowingL.setText(s);
    }

    public void theme() {
        switch (DataBase.getTheme()) {
            case 1:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/BackWhite.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 2:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/BackDark.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 3:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/BackWhite.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 4:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/BackDark.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
        }
    }

    public void back(MouseEvent mouseEvent) {
        // remove az pane
    }
}
