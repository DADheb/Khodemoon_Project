package com.example.mytwitterphase2.FXMLController.Objects;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Creator;
import com.example.mytwitterphase2.FXMLController.LiveState;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.User;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SelectUser implements Initializable {
    public Pane pane;
    public Circle cir;
    public Label username;
    public Label name;
    public ImageView select;
    public User user;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double scale = Creator.subScale;
        user = Creator.u;

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

        select.setFitWidth(50*scale);
        select.setFitHeight(50*scale);
        select.setLayoutX(530*scale);
        select.setLayoutY(25*scale);
        select.setVisible(false);

        switch (DataBase.theme){
            case 2 :
            case 4 :
                username.setTextFill(Color.web("#ffffff"));
                name.setTextFill(Color.web("#ffffff"));
                select.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/TikWhite.png")).toExternalForm()));
                break;
        }
    }

    public void addUser(MouseEvent mouseEvent) {
        select.setVisible(!select.isVisible());
        if(select.isVisible()){
            Creator.selectedUsers.add(user);
        } else {
            Creator.selectedUsers.remove(user);
        }
        LiveState.user = user;
    }
}
