package com.example.mytwitterphase2.FXMLController.Objects;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Creator;
import com.example.mytwitterphase2.FXMLController.LiveState;
import com.example.mytwitterphase2.entity.Message;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShortMessage implements Initializable {

    public Pane pane;
    public Circle cir;

    public Message message;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        message = Creator.m;
        double scale = Creator.subScale;
        cir.setRadius(40*scale);
        cir.setCenterX(50*scale);
        cir.setCenterY(0);
        cir.setLayoutX(0);
        pane.setPrefWidth(600*scale);
        if(Creator.aBoolean){
            cir.setLayoutX(500 * scale);
            Node node = null;
            if (Creator.m.isForwarded()){
                try {
                    node = Creator.showForwardMessageR(Creator.m, scale);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                if (Creator.m.isReply()){
                    try {
                        node = Creator.showReplyMessageR(Creator.m, scale);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        node = Creator.showMessageR(Creator.m, scale);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            pane.getChildren().add(node);
            node.setLayoutX(0);
            node.setLayoutY(0);
        } else {
            Node node = null;
            if (Creator.m.isForwarded()){
                try {
                    node = Creator.showForwardMessage(Creator.m, scale);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                if (Creator.m.isReply()){
                    try {
                        node = Creator.showReplyMessage(Creator.m, scale);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        node = Creator.showMessage(Creator.m, scale);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            pane.getChildren().add(node);
            node.setLayoutX(100*scale);
            node.setLayoutY(0);
        }
        pane.setPrefHeight(Creator.size);
        cir.setLayoutY(pane.getPrefHeight()-50*scale);
        cir.setFill(new ImagePattern(Creator.image));
    }

    public void goU(MouseEvent mouseEvent) throws IOException {
        if(ControllerManager.getMessageUser(message).equals(DataBase.getUser())){
            LiveState.user = message.getUser();
            LiveState.state = 10;
            DataBase.main.showProfile();
        } else {
            LiveState.user = message.getUser();
            LiveState.state = 15;
            DataBase.main.showUser();
        }
    }
}
