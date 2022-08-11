package com.example.mytwitterphase2.FXMLController.Objects;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Creator;
import com.example.mytwitterphase2.FXMLController.LiveState;
import com.example.mytwitterphase2.MainGraphic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MyProfileHeader implements Initializable {
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
    private Label viewersL;
    @FXML
    private Label numOfViewersL;
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
    private ImageView backImage;

    private double scale;
    private Image image;
    private Color themeColor;
    private Color mode;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scale = DataBase.getScale();
        initial();
    }

    public void initial() {
        setValues();
        //responsive
        this.userNameL.setFont(Font.font(22 * scale));
        this.followersL.setFont(Font.font(16 * scale));
        this.followingsL.setFont(Font.font(16 * scale));
        this.postsL.setFont(Font.font(16 * scale));
        this.viewersL.setFont(Font.font(16 * scale));
        this.numOfFollowingsL.setFont(Font.font(18 * scale));
        this.numOfFollowersL.setFont(Font.font(18 * scale));
        this.numOfPostL.setFont(Font.font(18 * scale));

        this.proPhoto.setRadius(56 * scale);
        this.topLine.setEndX(600 * scale);
        this.bottomLine.setEndX(600 * scale);

        this.userNameL.setLayoutX(260 * scale);
        this.followingsL.setLayoutX(451 * scale);
        this.followersL.setLayoutX(341 * scale);
        this.postsL.setLayoutX(244 * scale);
        this.viewersL.setLayoutX(314 * scale);
        this.numOfPostL.setLayoutX(252 * scale);
        this.numOfFollowersL.setLayoutX(362 * scale);
        this.numOfFollowingsL.setLayoutX(476 * scale);
        this.proPhoto.setLayoutX(112 * scale);
        this.backImage.setLayoutX(14 * scale);

        this.userNameL.setLayoutY(5 * scale);
        this.followingsL.setLayoutY(93 * scale);
        this.followersL.setLayoutY(93 * scale);
        this.postsL.setLayoutY(93 * scale);
        this.viewersL.setLayoutY(122 * scale);
        this.numOfPostL.setLayoutY(69 * scale);
        this.numOfFollowersL.setLayoutY(69 * scale);
        this.numOfFollowingsL.setLayoutY(69 * scale);
        this.proPhoto.setLayoutY(100 * scale);
        this.topLine.setLayoutY(45 * scale);
        this.bottomLine.setLayoutY(175 * scale);
        this.backImage.setLayoutY(8 * scale);

        this.proHeadPane.setPrefWidth(600 * scale);
        this.proHeadPane.setPrefHeight(180 * scale);

        this.backImage.setFitWidth(27 * scale);
        this.backImage.setFitHeight(23 * scale);
        if(LiveState.subState == 1){
            backImage.setVisible(false);
        } else {
            backImage.setVisible(true);
        }

        //theme
        this.userNameL.setTextFill(themeColor);
        this.followersL.setTextFill(themeColor);
        this.followingsL.setTextFill(themeColor);
        this.postsL.setTextFill(themeColor);
        this.viewersL.setTextFill(themeColor);
        this.numOfPostL.setTextFill(themeColor);
        this.numOfFollowingsL.setTextFill(themeColor);
        this.numOfFollowersL.setTextFill(themeColor);
        this.topLine.setStroke(themeColor);
        this.bottomLine.setStroke(themeColor);
        this.proHeadPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.proPhoto.setStroke(themeColor);
    }

    public void setValues() {
        theme();
        this.userNameL.setText(DataBase.getUser().getUserName());
        this.numOfPostL.setText(String.valueOf(DataBase.getUser().getNumberOfPosts()));
        this.numOfFollowersL.setText(String.valueOf(DataBase.getUser().getNumberOfFollowers()));
        this.numOfFollowingsL.setText(String.valueOf(DataBase.getUser().getNumberOfFollowings()));
        if (DataBase.getUser().getUserType() == false) {
            viewersL.setVisible(false);
        }
        this.image = DataBase.getUser().getProfileImage();
        this.proPhoto.setFill(new ImagePattern(image));
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

    public void showUserFollowers(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 16;
        LiveState.user = DataBase.getUser();
        DataBase.main.showFollowers();
    }

    public void showUserFollowings(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 17;
        LiveState.user = DataBase.getUser();
        DataBase.main.showFollowings();
    }

    public void showViewers(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 18;
        LiveState.user = DataBase.getUser();
        DataBase.main.showViewPerDay();
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 7;
        DataBase.main.setMenuPane();
    }
}