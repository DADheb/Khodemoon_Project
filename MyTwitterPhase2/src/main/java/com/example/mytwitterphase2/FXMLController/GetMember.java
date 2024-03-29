package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.Controller.GroupController;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Group;
import com.example.mytwitterphase2.entity.User;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GetMember implements Initializable {
    public Pane mainPane;
    public ScrollPane scrollPane;
    public VBox vbox;
    public Label select;
    public Group group;
    public ArrayList<User> users = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double scale = Creator.mainScale;
        group = LiveState.group;
        users = Creator.selectedUsers;

        mainPane.setPrefWidth(600*scale);
        mainPane.setPrefHeight(600*scale);

        scrollPane.setPrefWidth(600*scale);
        scrollPane.setPrefHeight(600*scale-70*scale);
        scrollPane.setLayoutY(70*scale);

        vbox.setPrefWidth(585*scale);
        vbox.setPrefHeight(0);

        select.setLayoutX(30*scale);
        select.setLayoutY(17*scale);
        select.setFont(Font.font(24*scale));

        Creator.g = group;
        Creator.subScale = vbox.getPrefWidth()/600;
        for (User u : users){
            Node node;
            Creator.u = u;
            FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/Member.fxml"));
            try {
                node = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            node.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    switch (LiveState.searchMState){
                        case 1 :
                            GroupController.removeMember(group,u);
                            LiveState.CGState = 2;
                            LiveState.groupState = 1;
                            try {
                                DataBase.main.refresh();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 2 :
                            GroupController.newAdmin(group,u);
                            LiveState.CGState = 2;
                            LiveState.groupState = 1;
                            try {
                                DataBase.main.refresh();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 3 :
                            GroupController.removeAdmin(group,u);
                            LiveState.CGState = 2;
                            LiveState.groupState = 1;
                            try {
                                DataBase.main.refresh();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 4 :
                            GroupController.banUser(group,u);
                            LiveState.CGState = 2;
                            LiveState.groupState = 1;
                            try {
                                DataBase.main.refresh();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 5 :
                            GroupController.unBanUser(group,u);
                            LiveState.CGState = 2;
                            LiveState.groupState = 1;
                            try {
                                DataBase.main.refresh();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                    }
                }
            });
            vbox.setPrefWidth(vbox.getPrefHeight()+100*scale);
            vbox.getChildren().add(node);
        }

        switch (DataBase.theme){
            case 1 :
                mainPane.setStyle("-fx-background-color: #0096ff");
                vbox.setStyle("-fx-background-color: #0096ff");
                break;
            case 2 :
                mainPane.setStyle("-fx-background-color: #191970");
                vbox.setStyle("-fx-background-color: #191970");
                select.setTextFill(Color.web("#ffffff"));
                break;
            case 3 :
                mainPane.setStyle("-fx-background-color: #f88379");
                vbox.setStyle("-fx-background-color: #f88379");
                break;
            case 4 :
                mainPane.setStyle("-fx-background-color: #4a0404");
                vbox.setStyle("-fx-background-color: #4a0404");
                select.setTextFill(Color.web("#ffffff"));
                break;
        }
    }
}
