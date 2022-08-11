package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.entity.Group;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreatGroup implements Initializable {
    public Pane mainPane;
    public ScrollPane scrollPane;
    public Pane paneIn;
    public Label headLabel;
    public Label nameLabel;
    public TextField nameField;
    public Label bioLabel;
    public TextField bioField;
    public Label selectLabel;
    public Circle cir;
    public Button choose;
    public Button next;
    public Group group;
    public Image image;
    public final FileChooser fileChooser = new FileChooser();
    public void selectMember(ActionEvent actionEvent) throws SQLException, IOException, InterruptedException {
        Group g = ControllerManager.newGroup(DataBase.getUser(),nameField.getText());
        g.setBio(bioField.getText());
        g.setProfileImage(group.getProfileImage());
        Creator.g = g;
        LiveState.group = g;
        LiveState.CGState = 5;
        DataBase.main.refresh();
    }

    public void choosePhoto(ActionEvent actionEvent) {
        fileChooser.setTitle("choose group photo");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter( "Image Files","*.png","*.jpg"));
        File file = fileChooser.showOpenDialog(null);
        if (file !=null){
            image = new Image(file.toURI().toString());
            group.setProfileImage(image);
            cir.setFill(new ImagePattern(image));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        group = new Group();
        double scale = Creator.mainScale;
        mainPane.setPrefWidth(600*scale);
        mainPane.setPrefHeight(Creator.size);

        scrollPane.setPrefWidth(600*scale);
        scrollPane.setPrefHeight(Creator.size);

        paneIn.setPrefWidth(585*scale);
        paneIn.setPrefHeight(600*scale);

        headLabel.setFont(Font.font(38d*scale));
        headLabel.setLayoutX(152*scale);
        headLabel.setLayoutY(43*scale);

        nameLabel.setFont(Font.font(30*scale));
        nameLabel.setLayoutX(66*scale);
        nameLabel.setLayoutY(356*scale);

        nameField.setPrefWidth(220*scale);
        nameField.setPrefHeight(30*scale);
        nameField.setLayoutX(322*scale);
        nameField.setLayoutY(363*scale);

        bioField.setPrefWidth(220*scale);
        bioField.setPrefHeight(30*scale);
        bioField.setLayoutX(322*scale);
        bioField.setLayoutY(459*scale);

        bioLabel.setFont(Font.font(30*scale));
        bioLabel.setLayoutX(131*scale);
        bioLabel.setLayoutY(452*scale);

        selectLabel.setFont(Font.font(30*scale));
        selectLabel.setLayoutX(24*scale);
        selectLabel.setLayoutY(287*scale);

        cir.setRadius(60*scale);
        cir.setLayoutX(292*scale);
        cir.setLayoutY(164*scale);
        cir.setFill(new ImagePattern(group.getProfileImage()));

        choose.setFont(Font.font(20*scale));
        choose.setLayoutX(386*scale);
        choose.setLayoutY(288*scale);

        next.setFont(Font.font(20*scale));
        next.setLayoutX(187*scale);
        next.setLayoutY(526*scale);

        switch (DataBase.theme){
            case 1 :
                paneIn.setStyle("-fx-background-color: #0096ff");
                choose.setStyle("-fx-background-color: #0437f2");
                next.setStyle("-fx-background-color: #0437f2");
                break;
            case 2 :
                paneIn.setStyle("-fx-background-color: #191970");
                choose.setStyle("-fx-background-color: #00008b");
                next.setStyle("-fx-background-color: #00008b");
                headLabel.setTextFill(Color.web("#ffffff"));
                nameLabel.setTextFill(Color.web("#ffffff"));
                bioLabel.setTextFill(Color.web("#ffffff"));
                selectLabel.setTextFill(Color.web("#ffffff"));
                break;
            case 3 :
                paneIn.setStyle("-fx-background-color: #f88379");
                choose.setStyle("-fx-background-color: #c21e56");
                next.setStyle("-fx-background-color: #c21e56");
                break;
            case 4 :
                paneIn.setStyle("-fx-background-color: #4a0404");
                choose.setStyle("-fx-background-color: #8b0000");
                next.setStyle("-fx-background-color: #8b0000");
                headLabel.setTextFill(Color.web("#ffffff"));
                nameLabel.setTextFill(Color.web("#ffffff"));
                bioLabel.setTextFill(Color.web("#ffffff"));
                selectLabel.setTextFill(Color.web("#ffffff"));
                break;
        }
    }
}
