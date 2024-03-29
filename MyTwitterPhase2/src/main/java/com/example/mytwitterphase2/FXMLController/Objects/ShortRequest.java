package com.example.mytwitterphase2.FXMLController.Objects;

import com.example.mytwitterphase2.Controller.UserController;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Creator;
import com.example.mytwitterphase2.FXMLController.LiveState;
import com.example.mytwitterphase2.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShortRequest implements Initializable {
    @FXML
    private Button confirmB;
    @FXML
    private Button deleteB;
    @FXML
    private Pane shortRequestPane;
    @FXML
    private Circle proPhoto;
    @FXML
    private Label usernameL;
    @FXML
    private Label nameL;
    private double scale;
    private Color themeColor;
    private Color mode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scale = Creator.subScale;
        theme();
        this.proPhoto.setFill(new ImagePattern(Creator.getRequestShortUser().getProfileImage()));
        this.usernameL.setText(Creator.getRequestShortUser().getUserName());
        this.nameL.setText(Creator.getRequestShortUser().getName() +" " + Creator.getRequestShortUser().getLastName());
        initial();
    }

    public void initial() {
        //responsive
        this.usernameL.setFont(Font.font(22 * scale));
        this.nameL.setFont(Font.font(22 * scale));
        this.confirmB.setFont(Font.font(18 * scale));
        this.deleteB.setFont(Font.font(18 * scale));

        this.proPhoto.setRadius(40 * scale);

        this.proPhoto.setLayoutX(110 * scale);
        this.usernameL.setLayoutX(190 * scale);
        this.nameL.setLayoutX(190 * scale);
        this.confirmB.setLayoutX(392 * scale);
        this.deleteB.setLayoutX(500 * scale);

        this.proPhoto.setLayoutY(45 * scale);
        this.usernameL.setLayoutY(18 * scale);
        this.nameL.setLayoutY(52 * scale);
        this.confirmB.setLayoutY(28 * scale);
        this.confirmB.setLayoutY(28 * scale);

        this.shortRequestPane.setPrefHeight(90 * scale);
        this.shortRequestPane.setPrefWidth(600 * scale);

        //theme
        this.shortRequestPane.setStyle("-fx-border-width:2; -fx-border-color: #" + themeColor.toString().substring(2) + "; -fx-background-color: #" + mode.toString().substring(2));
        this.usernameL.setTextFill(themeColor);
        this.nameL.setTextFill(themeColor);
        this.confirmB.setTextFill(mode);
        this.confirmB.setStyle("-fx-background-radius:15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.deleteB.setTextFill(mode);
        this.deleteB.setStyle("-fx-background-radius:15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.proPhoto.setStroke(themeColor);

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

    public void showUserPro(MouseEvent mouseEvent) throws IOException, InterruptedException {
        int i = DataBase.getUserNames().indexOf(this.usernameL.getText());
        User user = DataBase.getUsers().get(i);
        LiveState.user = user;
        LiveState.state = 15;
        DataBase.main.showUser();
        /// add kon
    }

    public void deleteRequest(ActionEvent event) throws IOException {
        UserController.unRequest(DataBase.getUser(), Creator.getRequestShortUser());
        LiveState.state = 12;
        DataBase.main.showRequests();
    }

    public void confirmRequest(ActionEvent event) throws IOException {
        UserController.acceptRequest(DataBase.getUser(), Creator.getRequestShortUser());
        LiveState.state = 12;
        DataBase.main.showRequests();
    }
}
