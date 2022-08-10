package com.example.mytwitterphase2.FXMLController.Objects;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Creator;
import com.example.mytwitterphase2.FXMLController.LiveState;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Group;
import com.example.mytwitterphase2.entity.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Member implements Initializable {

    public Pane pane;
    public Circle cir;
    public Label username;
    public Label name;
    public Label grade;
    public User user;
    public Group group;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double scale = Creator.subScale;
        user = Creator.u;
        group = Creator.g;

        pane.setPrefWidth(600*scale);
        pane.setPrefHeight(100*scale);

        cir.setRadius(40*scale);
        cir.setLayoutX(50*scale);
        cir.setLayoutY(50*scale);
        cir.setFill(new ImagePattern(user.getProfileImage()));

        username.setFont(Font.font(24*scale));
        username.setLayoutX(120*scale);
        username.setLayoutY(15*scale);

        name.setFont(Font.font(20*scale));
        name.setLayoutX(120*scale);
        name.setLayoutY(55*scale);

        grade.setFont(Font.font(20*scale));
        grade.setLayoutX(480*scale);
        grade.setLayoutY(15*scale);
        switch (ControllerManager.getGrade(group, user)) {
            case 3:
                grade.setText("Ban");
                break;
            case 1:
                grade.setText("Creator");
                break;
            case 2:
                grade.setText("Admin");
                break;
            case 0:
                grade.setText("Member");
                break;
            case -1 :
                grade.setText("Removed");
                break;
        }

        switch (DataBase.theme){
            case 2 :
            case 4 :
                username.setTextFill(Color.web("#ffffff"));
                name.setTextFill(Color.web("#ffffff"));
                grade.setTextFill(Color.web("#ffffff"));
                break;
        }
    }

    public void addUser(MouseEvent mouseEvent) {
        LiveState.user = user;
    }
}
