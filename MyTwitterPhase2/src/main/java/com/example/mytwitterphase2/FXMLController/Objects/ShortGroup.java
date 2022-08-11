package com.example.mytwitterphase2.FXMLController.Objects;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Creator;
import com.example.mytwitterphase2.FXMLController.LiveState;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Group;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShortGroup implements Initializable {
    @FXML
    public ImageView imgLabel;
    @FXML
    public Label lastMessage;
    @FXML
    public Region reg1InHBox;
    @FXML
    public Region reg2InVBox2;
    @FXML
    public HBox hBox;
    @FXML
    public Label name;
    @FXML
    public Region reg1InVBox2;
    @FXML
    public VBox vBox2InMainHBox;
    @FXML
    public Region reg2InMainHBox;
    @FXML
    public Circle cir;
    @FXML
    public Region regInVBox1;
    @FXML
    public VBox vBox1InMainHBox;
    @FXML
    public Region reg1InMainHBox;
    @FXML
    public HBox mainHBox;
    @FXML
    public Pane pane;
    @FXML
    public Region reg3InVBox2;

    public Group group;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        group = Creator.g;
        Image image = Creator.image;
        double scale = Creator.subScale;
        cir.setRadius(65*scale);
        reg3InVBox2.setPrefWidth(435*scale);
        reg3InVBox2.setPrefHeight(45*scale);
        imgLabel.setFitWidth(85*scale);
        imgLabel.setFitHeight(30*scale);
        imgLabel.setLayoutX(500*scale);
        imgLabel.setLayoutY(60*scale);
        lastMessage.setFont(Font.font("System",20*scale));
        lastMessage.setText(Creator.string1);
        reg1InHBox.setPrefWidth(30*scale);
        reg1InHBox.setPrefHeight(30*scale);
        reg2InVBox2.setPrefWidth(435*scale);
        reg2InVBox2.setPrefHeight(30*scale);
        hBox.setPrefWidth(435*scale);
        hBox.setPrefHeight(30*scale);
        name.setFont(Font.font("System",24*scale));
        name.setText(Creator.string);
        reg1InVBox2.setPrefWidth(435*scale);
        reg1InVBox2.setPrefHeight(25*scale);
        vBox2InMainHBox.setPrefWidth(435*scale);
        vBox2InMainHBox.setPrefHeight(150*scale);
        reg1InMainHBox.setPrefWidth(15*scale);
        reg1InMainHBox.setPrefHeight(150*scale);
        mainHBox.setPrefWidth(600*scale);
        mainHBox.setPrefHeight(150*scale);
        pane.setPrefWidth(600*scale);
        pane.setPrefHeight(150*scale);
        reg2InMainHBox.setPrefWidth(20*scale);
        reg2InMainHBox.setPrefHeight(150*scale);
        vBox1InMainHBox.setPrefWidth(130*scale);
        vBox1InMainHBox.setPrefHeight(150*scale);
        regInVBox1.setPrefWidth(130*scale);
        regInVBox1.setPrefHeight(10*scale);
        cir.setFill(new ImagePattern(image));
        switch (DataBase.theme){
            case 1 :
                mainHBox.setStyle("-fx-background-color: #78a1d1");
                imgLabel.setImage(new Image(MainGraphic.class.getResource("Photo/Project/GroupLabelWhite.png").toExternalForm()));
                name.setStyle("-fx-text-fill : #000000");
                lastMessage.setStyle("-fx-text-fill : #000000");
                break;
            case 2 :
                mainHBox.setStyle("-fx-background-color: #385068");
                imgLabel.setImage(new Image(MainGraphic.class.getResource("Photo/Project/GroupLabelDark.png").toExternalForm()));
                name.setStyle("-fx-text-fill : #ffffff");
                lastMessage.setStyle("-fx-text-fill : #ffffff");
                break;
            case 3 :
                mainHBox.setStyle("-fx-background-color: #f5cdcd");
                imgLabel.setImage(new Image(MainGraphic.class.getResource("Photo/Project/GroupLabelWhite.png").toExternalForm()));
                name.setStyle("-fx-text-fill : #000000");
                lastMessage.setStyle("-fx-text-fill : #000000");
                break;
            case 4 :
                mainHBox.setStyle("-fx-background-color: #c3a3a3");
                imgLabel.setImage(new Image(MainGraphic.class.getResource("Photo/Project/GroupLabelDark.png").toExternalForm()));
                name.setStyle("-fx-text-fill : #ffffff");
                lastMessage.setStyle("-fx-text-fill : #ffffff");
                break;
        }
    }

    public void addGroup(MouseEvent mouseEvent) {
        LiveState.group = group;
    }
}
