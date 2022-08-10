package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.Controller.GroupController;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.entity.Group;
import com.example.mytwitterphase2.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddMembers implements Initializable {

    public Pane mainPane;
    public ScrollPane scrollPane;
    public VBox vbox;
    public Button add;
    public Label select;
    public Group group;
    public void addAndGo(ActionEvent actionEvent) throws SQLException, IOException {
        for (User u : Creator.selectedUsers){
            GroupController.newMember(group,u);
        }
        LiveState.group = group;
        LiveState.CGState = 2;
        LiveState.groupState = 0;
        DataBase.main.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Creator.selectedUsers.clear();
        group = Creator.g;
        double scale = Creator.mainScale;

        mainPane.setPrefWidth(600*scale);
        mainPane.setPrefHeight(Creator.size);

        scrollPane.setPrefWidth(600*scale);
        scrollPane.setPrefHeight(Creator.size-120*scale);
        scrollPane.setLayoutY(70*scale);

        vbox.setPrefWidth(585*scale);

        add.setFont(Font.font(15*scale));
        add.setLayoutX(228*scale);
        add.setLayoutY(Creator.size-45*scale);

        select.setFont(Font.font(24*scale));
        select.setLayoutX(243*scale);
        select.setLayoutY(23*scale);

        switch (DataBase.theme){
            case 1 :
                mainPane.setStyle("-fx-background-color: #0096ff");
                vbox.setStyle("-fx-background-color: #0096ff");
                add.setStyle("-fx-background-color: #0437f2");
                break;
            case 2 :
                mainPane.setStyle("-fx-background-color: #191970");
                vbox.setStyle("-fx-background-color: #191970");
                add.setStyle("-fx-background-color: #00008b");
                add.setTextFill(Color.web("#ffffff"));
                select.setTextFill(Color.web("#ffffff"));
                break;
            case 3 :
                mainPane.setStyle("-fx-background-color: #f88379");
                vbox.setStyle("-fx-background-color: #f88379");
                add.setStyle("-fx-background-color: #c21e56");
                break;
            case 4 :
                mainPane.setStyle("-fx-background-color: #4a0404");
                vbox.setStyle("-fx-background-color: #4a0404");
                add.setStyle("-fx-background-color: #8b0000");
                add.setTextFill(Color.web("#ffffff"));
                select.setTextFill(Color.web("#ffffff"));
                break;
        }
    }
}
