package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ChatAndGroup;
import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.Controller.Sort;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Message;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class GetChatGroup implements Initializable {

    public Pane pane;
    public ScrollPane scrollPane;
    public VBox vBox;
    public Label label;
    public Message message;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double scale = Creator.mainScale;
        message = LiveState.message;

        pane.setPrefWidth(600*scale);
        pane.setPrefHeight(Creator.height);

        scrollPane.setPrefWidth(600*scale);
        scrollPane.setPrefHeight(Creator.height-70*scale);
        scrollPane.setLayoutY(70*scale);

        vBox.setPrefWidth(585*scale);
        vBox.setPrefHeight(0);

        label.setFont(Font.font(30*scale));
        label.setLayoutX(30*scale);
        label.setLayoutY(12*scale);

        ArrayList<ChatAndGroup> chatGroups = Sort.sortChatGroup();
        for (ChatAndGroup c : chatGroups){
            Node node;
            if(c.getType()==1){
                try {
                    node = Creator.showShortChat(c.getChat(),vBox.getPrefWidth()/600.0);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                node.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        try {
                            ControllerManager.forwardMessageToChat(DataBase.getUser(),message,c.getChat());
                            LiveState.CGState = 1;
                            LiveState.chatState = 0;
                            DataBase.main.refresh();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            } else {
                try {
                    node = Creator.showShortGroup(c.getGroup(),vBox.getPrefWidth()/600.0);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                node.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        try {
                            Thread.sleep(10);
                            ControllerManager.forwardMessageToGroup(DataBase.getUser(),message,c.getGroup());
                            LiveState.CGState = 2;
                            LiveState.groupState = 0;
                            DataBase.main.refresh();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
            vBox.setPrefHeight(vBox.getPrefHeight()+150*scale);
            vBox.getChildren().add(node);
        }
        switch (DataBase.theme){
            case 1 :
                vBox.setStyle("-fx-background-color: #0096ff");
                pane.setStyle("-fx-background-color: #0096ff");
                break;
            case 2 :
                vBox.setStyle("-fx-background-color: #191970");
                pane.setStyle("-fx-background-color: #191970");
                label.setTextFill(Color.web("#ffffff"));
                break;
            case 3 :
                vBox.setStyle("-fx-background-color: #f88379");
                pane.setStyle("-fx-background-color: #f88379");
                break;
            case 4 :
                vBox.setStyle("-fx-background-color: #4a0404");
                pane.setStyle("-fx-background-color: #4a0404");
                label.setTextFill(Color.web("#ffffff"));

                break;
        }
    }
}
