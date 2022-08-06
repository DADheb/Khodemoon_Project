package com.example.users.FXMLController;

import com.example.users.Controller.UserController;
import com.example.users.DataBase.DataBase;
import com.example.users.Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShortUser implements Initializable {
    @FXML
    private Pane shortUserPane;
    @FXML
    private Circle proPhoto;
    @FXML
    private Label usernameL;
    @FXML
    private Button followB;
    @FXML
    private Label nameL;
    private double scale;
    private Color themeColor;
    private Color mode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scale = Creator.getScale();
        theme();
        this.proPhoto.setFill(new ImagePattern(Creator.getShortUser().getProfileImage()));
        this.usernameL.setText(Creator.getShortUser().getUserName());
        this.nameL.setText(Creator.getShortUser().getName() +" "+ Creator.getShortUser().getLastName());
        if (DataBase.getUser().getFollowings().contains(Creator.getShortUser())){
            this.followB.setText("Following");
        }else if (Creator.getShortUser().getRequests().contains(DataBase.getUser())){
            this.followB.setText("Requested");
        }else {
            this.followB.setText("Follow");
        }
        initial();
    }

    public void initial() {
        //responsive
        this.usernameL.setFont(Font.font(22 * scale));
        this.nameL.setFont(Font.font(22 * scale));
        this.followB.setFont(Font.font(18 * scale));

        this.proPhoto.setRadius(40 * scale);

        this.proPhoto.setLayoutX(110 * scale);
        this.usernameL.setLayoutX(190 * scale);
        this.nameL.setLayoutX(190 * scale);
        this.followB.setLayoutX(433 * scale);

        this.proPhoto.setLayoutY(45 * scale);
        this.usernameL.setLayoutY(18 * scale);
        this.nameL.setLayoutY(52 * scale);
        this.followB.setLayoutY(28 * scale);

        this.shortUserPane.setPrefHeight(90 * scale);
        this.shortUserPane.setPrefWidth(600 * scale);

        //theme
        this.shortUserPane.setStyle("-fx-border-width:2; -fx-border-color: #" +  themeColor.toString().substring(2)+"-fx-background-color: #" + mode.toString().substring(2));
        this.usernameL.setTextFill(themeColor);
        this.nameL.setTextFill(themeColor);
        this.followB.setTextFill(mode);
        this.followB.setStyle("-fx-background-radius:15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.proPhoto.setStroke(themeColor);

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

    public void followAction(ActionEvent event) {
        String s = this.usernameL.getText();
        if (s.equals("Following")){
            UserController.unFollow(DataBase.getUser(),Creator.getShortUser());
        } else if (s.equals("Requested")){
            UserController.unRequest(DataBase.getUser(),Creator.getShortUser());
        } else if (s.equals("Follow")){
            int n = UserController.follow(DataBase.getUser(),Creator.getShortUser());
            if(n==0){
                this.followB.setText("Following");
            }
            else if (n==2){
                this.followB.setText("Requested");
            }
        }
    }

    public void showUserPro(MouseEvent mouseEvent) {
        int i = DataBase.getUserNames().indexOf(this.usernameL.getText());
        User user = DataBase.getUsers().get(i);
        try {
            Creator.showOthersProfile(user, this.scale);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /// add she
    }

}
