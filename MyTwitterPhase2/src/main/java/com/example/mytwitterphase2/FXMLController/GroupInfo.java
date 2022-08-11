package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.Controller.GroupController;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Group;
import com.example.mytwitterphase2.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class GroupInfo implements Initializable {
    public Pane mainPane;
    public ScrollPane scrollPane;
    public VBox vbox;
    public Circle cir;
    public ImageView backImage;
    public Label name;
    public Button chane;
    public Separator sep;
    public Button addM;
    public Button addA;
    public Button removeM;
    public Button banM;
    public Button unban;
    public Button leave;
    public Button removeA;
    public Group group;
    public void removeAdmin(ActionEvent actionEvent) throws SQLException, IOException, InterruptedException {
        Creator.selectedUsers = (ArrayList<User>) group.getAdmins().clone();
        Creator.selectedUsers.remove(group.getCreator());
        LiveState.searchMState = 3;
        LiveState.groupState = 2;
        DataBase.main.refresh();
    }

    public void leaveGroup(ActionEvent actionEvent) throws SQLException, IOException, InterruptedException {
        if(group.getCreator().equals(DataBase.getUser())){
            ControllerManager.deleteGroup(group);
            LiveState.CGState = 0;
            DataBase.main.refresh();
        } else {
            GroupController.removeMember(group,DataBase.getUser());
            LiveState.CGState = 0;
            DataBase.main.refresh();
        }
    }

    public void banMember(ActionEvent actionEvent) throws SQLException, IOException, InterruptedException {
        Creator.selectedUsers = (ArrayList<User>) group.getMembers().clone();
        if(group.getCreator().equals(DataBase.getUser())) {
            Creator.selectedUsers.remove(group.getCreator());
        } else {
            Creator.selectedUsers.removeAll(group.getAdmins());
        }
        LiveState.searchMState = 4;
        LiveState.groupState = 2;
        DataBase.main.refresh();
    }

    public void unbanMember(ActionEvent actionEvent) throws SQLException, IOException, InterruptedException {
        Creator.selectedUsers = (ArrayList<User>) group.getBans().clone();
        LiveState.searchMState = 5;
        LiveState.groupState = 2;
        DataBase.main.refresh();
    }

    public void removeMember(ActionEvent actionEvent) throws SQLException, IOException, InterruptedException {
        Creator.selectedUsers = (ArrayList<User>) group.getMembers().clone();
        if(group.getCreator().equals(DataBase.getUser())) {
            Creator.selectedUsers.remove(group.getCreator());
        } else {
            Creator.selectedUsers.removeAll(group.getAdmins());
        }
        LiveState.searchMState = 1;
        LiveState.groupState = 2;
        DataBase.main.refresh();
    }

    public void addAdmin(ActionEvent actionEvent) throws SQLException, IOException, InterruptedException {
        Creator.selectedUsers = (ArrayList<User>) group.getMembers().clone();
        Creator.selectedUsers.removeAll(group.getAdmins());
        LiveState.searchMState = 2;
        LiveState.groupState = 2;
        DataBase.main.refresh();
    }

    public void addMember(ActionEvent actionEvent) {
        Creator.selectedUsers = (ArrayList<User>) DataBase.getUser().getFollowers().clone();
        Creator.selectedUsers.removeAll(group.getMembers());
        LiveState.CGState = 3 ;
        LiveState.typeSelection = 2;
        Creator.aBoolean = true;
    }

    public void changeGroup(ActionEvent actionEvent) throws SQLException, IOException, InterruptedException {
        LiveState.groupState = 4;
        DataBase.main.refresh();
    }

    public void back(MouseEvent mouseEvent) throws SQLException, IOException, InterruptedException {
        LiveState.groupState = 1;
        DataBase.main.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double scale = Creator.mainScale;
        group = Creator.g;

        mainPane.setPrefWidth(600*scale);
        mainPane.setPrefHeight(Creator.height);

        scrollPane.setPrefWidth(600*scale);
        scrollPane.setPrefHeight(Creator.height-150*scale);
        scrollPane.setLayoutY(150*scale);

        vbox.setPrefWidth(585*scale);
        vbox.setPrefHeight(0);

        cir.setRadius(35*scale);
        cir.setLayoutX(120*scale);
        cir.setLayoutY(40*scale);
        cir.setFill(new ImagePattern(group.getProfileImage()));

        backImage.setFitWidth(60*scale);
        backImage.setFitHeight(60*scale);
        backImage.setLayoutX(10*scale);
        backImage.setLayoutY(10*scale);

        name.setText(group.getName());
        name.setFont(Font.font(20*scale));
        name.setLayoutX(172*scale);
        name.setLayoutY(25*scale);

        chane.setFont(Font.font(18*scale));
        chane.setLayoutX(352*scale);
        chane.setLayoutY(21*scale);

        leave.setFont(Font.font(18*scale));
        leave.setLayoutX(496*scale);
        leave.setLayoutY(21*scale);

        addM.setFont(Font.font(15*scale));
        addM.setLayoutX(5*scale);
        addM.setLayoutY(102*scale);

        addA.setFont(Font.font(15*scale));
        addA.setLayoutX(120*scale);
        addA.setLayoutY(102*scale);

        removeM.setFont(Font.font(15*scale));
        removeM.setLayoutX(220*scale);
        removeM.setLayoutY(102*scale);

        banM.setFont(Font.font(15*scale));
        banM.setLayoutX(360*scale);
        banM.setLayoutY(82*scale);

        unban.setFont(Font.font(15*scale));
        unban.setLayoutX(363*scale);
        unban.setLayoutY(118*scale);

        removeA.setFont(Font.font(15*scale));
        removeA.setLayoutX(470*scale);
        removeA.setLayoutY(102*scale);
        Creator.g = group;
        Creator.subScale = vbox.getPrefWidth()/600;

        switch (ControllerManager.getGrade(group,DataBase.getUser())){
            case 2 :
                addA.setVisible(false);
                removeA.setVisible(false);
                break;
            case 3 :
                addA.setVisible(false);
                addM.setVisible(false);
                removeA.setVisible(false);
                removeM.setVisible(false);
                chane.setVisible(false);
                banM.setVisible(false);
                unban.setVisible(false);
                break;
            case 0 :
                addA.setVisible(false);
                removeA.setVisible(false);
                removeM.setVisible(false);
                chane.setVisible(false);
                banM.setVisible(false);
                unban.setVisible(false);
                break;
        }

        for (User u : group.getMembers()){
            Node node;
            Creator.u = u;
            FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/Member.fxml"));
            try {
                node = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            vbox.setPrefHeight(vbox.getPrefHeight()+100*scale);
            vbox.getChildren().add(node);
        }
        switch (DataBase.theme){
            case 1 :
                mainPane.setStyle("-fx-background-color: #0096ff");
                vbox.setStyle("-fx-background-color: #0096ff");
                addA.setStyle("-fx-background-color: #0437f2");
                addM.setStyle("-fx-background-color: #0437f2");
                banM.setStyle("-fx-background-color: #0437f2");
                unban.setStyle("-fx-background-color: #0437f2");
                removeA.setStyle("-fx-background-color: #0437f2");
                removeM.setStyle("-fx-background-color: #0437f2");
                leave.setStyle("-fx-background-color: #0437f2");
                chane.setStyle("-fx-background-color: #0437f2");
                break;
            case 2 :
                mainPane.setStyle("-fx-background-color: #191970");
                vbox.setStyle("-fx-background-color: #191970");
                addA.setStyle("-fx-background-color: #00008b");
                addM.setStyle("-fx-background-color: #00008b");
                banM.setStyle("-fx-background-color: #00008b");
                unban.setStyle("-fx-background-color: #00008b");
                removeA.setStyle("-fx-background-color: #00008b");
                removeM.setStyle("-fx-background-color: #00008b");
                leave.setStyle("-fx-background-color: #00008b");
                chane.setStyle("-fx-background-color: #00008b");
                name.setTextFill(Color.web("#ffffff"));
                addM.setTextFill(Color.web("#ffffff"));
                addA.setTextFill(Color.web("#ffffff"));
                banM.setTextFill(Color.web("#ffffff"));
                removeM.setTextFill(Color.web("#ffffff"));
                removeA.setTextFill(Color.web("#ffffff"));
                leave.setTextFill(Color.web("#ffffff"));
                chane.setTextFill(Color.web("#ffffff"));
                backImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm()));
                break;
            case 3 :
                mainPane.setStyle("-fx-background-color: #f88379");
                vbox.setStyle("-fx-background-color: #f88379");
                addA.setStyle("-fx-background-color: #c21e56");
                addM.setStyle("-fx-background-color: #c21e56");
                banM.setStyle("-fx-background-color: #c21e56");
                unban.setStyle("-fx-background-color: #c21e56");
                removeA.setStyle("-fx-background-color: #c21e56");
                removeM.setStyle("-fx-background-color: #c21e56");
                leave.setStyle("-fx-background-color: #c21e56");
                chane.setStyle("-fx-background-color: #c21e56");
                break;
            case 4 :
                mainPane.setStyle("-fx-background-color: #4a0404");
                vbox.setStyle("-fx-background-color: #4a0404");
                addA.setStyle("-fx-background-color: #8b0000");
                addM.setStyle("-fx-background-color: #8b0000");
                banM.setStyle("-fx-background-color: #8b0000");
                unban.setStyle("-fx-background-color: #8b0000");
                removeA.setStyle("-fx-background-color: #8b0000");
                removeM.setStyle("-fx-background-color: #8b0000");
                leave.setStyle("-fx-background-color: #8b0000");
                chane.setStyle("-fx-background-color: #8b0000");
                name.setTextFill(Color.web("#ffffff"));
                addM.setTextFill(Color.web("#ffffff"));
                addA.setTextFill(Color.web("#ffffff"));
                banM.setTextFill(Color.web("#ffffff"));
                removeM.setTextFill(Color.web("#ffffff"));
                removeA.setTextFill(Color.web("#ffffff"));
                leave.setTextFill(Color.web("#ffffff"));
                chane.setTextFill(Color.web("#ffffff"));
                backImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm()));
                break;
        }
    }
}
