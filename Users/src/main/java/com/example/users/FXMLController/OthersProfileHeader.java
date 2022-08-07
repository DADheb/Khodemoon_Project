package com.example.users.FXMLController;

import com.example.users.Controller.UserController;
import com.example.users.DataBase.DataBase;
import com.example.users.FXMLController.Creator;
import com.example.users.Main;
import com.example.users.Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class OthersProfileHeader implements Initializable {

    @FXML
    private Pane proHeadPane;
    @FXML
    private Label userNameL;
    @FXML
    private Label postsL;
    @FXML
    private Label followersL;
    @FXML
    private Label followingsL;
    @FXML
    private Label numOfPostL;
    @FXML
    private Label numOfFollowersL;
    @FXML
    private Label numOfFollowingsL;
    @FXML
    private Line topLine;
    @FXML
    private Line bottomLine;
    @FXML
    private Circle proPhoto;
    @FXML
    private Button follow;
    @FXML
    private Button sendMessage;
    @FXML
    private Button blockB;
    @FXML
    private ImageView backImage;

    private double scale;
    private Image image;
    private Color themeColor;
    private Color mode;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scale = Creator.getScale();
        initial();
    }

    public void initial() {
        setValues();
        //responsive
        this.userNameL.setFont(Font.font(22 * scale));
        this.followersL.setFont(Font.font(16 * scale));
        this.followingsL.setFont(Font.font(16 * scale));
        this.postsL.setFont(Font.font(16 * scale));
        this.numOfFollowingsL.setFont(Font.font(18 * scale));
        this.numOfFollowersL.setFont(Font.font(18 * scale));
        this.numOfPostL.setFont(Font.font(18 * scale));
        this.follow.setFont(Font.font(15 * scale));
        this.sendMessage.setFont(Font.font(15 * scale));
        //this.blockB.setFont(Font.font(15 * scale));

        this.proPhoto.setRadius(56 * scale);
        this.topLine.setEndX(600 * scale);
        this.bottomLine.setEndX(600 * scale);

        this.userNameL.setLayoutX(260 * scale);
        this.followingsL.setLayoutX(451 * scale);
        this.followersL.setLayoutX(341 * scale);
        this.postsL.setLayoutX(244 * scale);
        this.numOfPostL.setLayoutX(252 * scale);
        this.numOfFollowersL.setLayoutX(362 * scale);
        this.numOfFollowingsL.setLayoutX(476 * scale);
        this.proPhoto.setLayoutX(112 * scale);
        this.follow.setLayoutX(270 * scale);
        this.sendMessage.setLayoutX(398 * scale);

        this.userNameL.setLayoutY(5 * scale);
        this.followingsL.setLayoutY(93 * scale);
        this.followersL.setLayoutY(93 * scale);
        this.postsL.setLayoutY(93 * scale);
        this.numOfPostL.setLayoutY(69 * scale);
        this.numOfFollowersL.setLayoutY(69 * scale);
        this.numOfFollowingsL.setLayoutY(69 * scale);
        this.proPhoto.setLayoutY(100 * scale);
        this.topLine.setLayoutY(45 * scale);
        this.bottomLine.setLayoutY(175 * scale);
        this.follow.setLayoutY(121 * scale);
        this.sendMessage.setLayoutY(121 * scale);
        //this.blockB.setLayoutY(121 * scale);

        this.proHeadPane.setPrefWidth(600 * scale);
        this.proHeadPane.setPrefHeight(180 * scale);

        this.backImage.setLayoutX(14 * scale);
        this.backImage.setLayoutY(8 * scale);
        this.backImage.setFitWidth(27 * scale);
        this.backImage.setFitHeight(23 * scale);

        //theme
        this.userNameL.setTextFill(themeColor);
        this.followersL.setTextFill(themeColor);
        this.followingsL.setTextFill(themeColor);
        this.postsL.setTextFill(themeColor);
        this.numOfPostL.setTextFill(themeColor);
        this.numOfFollowingsL.setTextFill(themeColor);
        this.numOfFollowersL.setTextFill(themeColor);
        this.topLine.setFill(themeColor);
        this.bottomLine.setFill(themeColor);
        this.follow.setTextFill(mode);
        this.sendMessage.setTextFill(mode);
        this.follow.setStyle("-fx-background-radius:15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.sendMessage.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.proHeadPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.proPhoto.setStroke(themeColor);
    }

    public void setValues() {
        theme();
        User user = Creator.getOthersProfileHeaderUser();
        this.userNameL.setText(user.getUserName());
        this.numOfPostL.setText(String.valueOf(user.getNumberOfPosts()));
        this.numOfFollowersL.setText(String.valueOf(user.getNumberOfFollowers()));
        this.numOfFollowingsL.setText(String.valueOf(user.getNumberOfFollowings()));

        this.image = user.getProfileImage();
        this.proPhoto.setFill(new ImagePattern(image));

        if (DataBase.getUser().getFollowings().contains(user)) {
            this.follow.setText("Following");
        } else if (!DataBase.getUser().getFollowings().contains(user)) {
            this.follow.setText("Follow");
        } else if (user.getRequests().contains(DataBase.getUser())) {
            this.follow.setText("Requested");
        }
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

    public void followUser(ActionEvent event) {
        if (this.follow.getText().equals("Follow")) {
            int n = UserController.follow(DataBase.getUser(), Creator.getOthersProfileHeaderUser());
            if (n == 2) {
                this.follow.setText("Requested");
            } else if (n == 0) {
                this.follow.setText("Following");
            }
        } else if (this.follow.getText().equals("Following")) {
            UserController.unFollow(DataBase.getUser(), Creator.getOthersProfileHeaderUser());
            this.follow.setText("Follow");
        } else if (this.follow.getText().equals("Requested")) {
            UserController.unRequest(DataBase.getUser(), Creator.getOthersProfileHeaderUser());
            this.follow.setText("Follow");
        }
    }

    public void sendMessageToUser(ActionEvent event) {
        // behdad
    }

    public void showFollowers(MouseEvent mouseEvent) {
        Creator.showFollowingsOrFollowers(Creator.getOthersProfileHeaderUser(), "Followers", this.scale);
        // ad beshe be safhe
    }

    public void showFollowings(MouseEvent mouseEvent) {
        Creator.showFollowingsOrFollowers(Creator.getOthersProfileHeaderUser(), "Followings", this.scale);
        // ad beshe be safhe
    }

    public void back(MouseEvent mouseEvent) {
    }
}