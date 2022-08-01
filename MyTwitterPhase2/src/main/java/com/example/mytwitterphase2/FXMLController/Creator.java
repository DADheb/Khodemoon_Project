package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Chat;
import com.example.mytwitterphase2.entity.Group;
import com.example.mytwitterphase2.entity.Message;
import com.example.mytwitterphase2.entity.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.Collections;

public class Creator {
    public static double scale;

    public static String string;
    public static String string1;
    public static Image image;
    public static boolean aBoolean;
    public static Node showShortChat(Chat chat,double s) throws IOException {
        scale = s ;
        Node node;
        User user = ControllerManager.getSecUserChat(chat);
        string =  user.getUserName();
        Collections.sort(chat.getMessages());
        Message message = chat.getMessages().get(0);
        if(ControllerManager.getMessageUser(message).equals(DataBase.getUser())){
            string1 = "You : "+message.getText();
            aBoolean = true;
        } else {
            string1 = string +" : "+ message.getText();
            if(message.isSeen()){
                aBoolean = true;
            } else {
                aBoolean = false;
            }
        }
        image = user.getProfileImage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ShortChat.fxml"));
        node = fxmlLoader.load();
        return node;
    }
    public static Node showShortGroup(Group group,double s) throws IOException {
        scale = s;
        Node node;
        string = group.getName();
        Collections.sort(group.getMessages());
        Message message = group.getMessages().get(0);
        if(ControllerManager.getMessageUser(message).equals(DataBase.getUser())){
            string1 = "You : "+message.getText();
        } else {
            string1 = ControllerManager.getMessageUser(message).getUserName() +" : "+ message.getText();
        }
        image = group.getProfileImage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ShortGroup.fxml"));
        node = fxmlLoader.load();
        return node;
    }
    public static Node showMessage(Message message,double s) throws IOException {
        Node node;
        string = ControllerManager.getMessageUser(message).getUserName();
        string1 = "";
        if(message.isForwarded()){
            string1 +="FORWARDED FROM "+ message.getUser().getUserName()+"\n";
        }
        string1 += message.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/Message.fxml"));
        node = fxmlLoader.load();
        return node;
    }
}
