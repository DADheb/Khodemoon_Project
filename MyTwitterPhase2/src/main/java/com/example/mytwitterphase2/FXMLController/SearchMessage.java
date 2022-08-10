package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.SQL.SQL;
import com.example.mytwitterphase2.entity.Chat;
import com.example.mytwitterphase2.entity.Group;
import com.example.mytwitterphase2.entity.Message;
import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class SearchMessage implements Initializable {

    public Pane mainPane;
    public ScrollPane scrollPane;
    public VBox vbox;
    public TextField textField;
    public Label textLabel;
    public ImageView search;
    public ImageView back;
    public boolean type;
    public Chat chat;
    public Group group;


    public void show(MouseEvent mouseEvent) throws SQLException, IOException {
        String s = textField.getText();
        if(s.length()!=0){
            ArrayList<Message> messages = new ArrayList<>();
            if(type){
                messages = SQL.searchMessage(group,s,DataBase.getConnection());
            } else {
                messages = SQL.searchMessage(chat,s,DataBase.getConnection());
            }
            vbox.getChildren().clear();
            for (Message m : messages){
                Node node ;
                node = Creator.showShortMessage(m,vbox.getPrefWidth()/600.0);
                vbox.setPrefHeight(vbox.getPrefHeight()+Creator.size);
                vbox.getChildren().add(node);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double scale = Creator.mainScale;

        type = Creator.aBoolean;
        if(type){
            group = Creator.g;
        } else {
            chat = Creator.c;
        }

        mainPane.setPrefWidth(600 * scale);
        mainPane.setPrefHeight(Creator.size);

        scrollPane.setPrefWidth(600 * scale);
        scrollPane.setPrefHeight(Creator.size-70*scale);
        scrollPane.setLayoutY(70*scale);

        vbox.setPrefWidth(585*scale);
        vbox.setPrefHeight(0);

        textField.setPrefWidth(300*scale);
        textField.setPrefHeight(30*scale);
        textField.setLayoutX(221*scale);
        textField.setLayoutY(20*scale);

        textLabel.setFont(Font.font(24*scale));
        textLabel.setLayoutX(88*scale);
        textLabel.setLayoutY(17*scale);

        search.setFitWidth(60*scale);
        search.setFitHeight(60*scale);
        search.setLayoutX(535*scale);
        search.setLayoutY(5*scale);

        back.setFitWidth(50*scale);
        back.setFitHeight(50*scale);
        back.setLayoutX(10*scale);
        back.setLayoutY(50*scale);

        switch (DataBase.theme){
            case 1 :
                mainPane.setStyle("-fx-background-color: #0096ff");
                vbox.setStyle("-fx-background-color: #0096ff");
                break;
            case 2 :
                mainPane.setStyle("-fx-background-color: #191970");
                vbox.setStyle("-fx-background-color: #191970");
                textLabel.setTextFill(Color.web("#ffffff"));
                back.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm()));
                search.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/SearchWhite.png")).toExternalForm()));
                break;
            case 3 :
                mainPane.setStyle("-fx-background-color: #f88379");
                vbox.setStyle("-fx-background-color: #f88379");
                break;
            case 4 :
                mainPane.setStyle("-fx-background-color: #4a0404");
                vbox.setStyle("-fx-background-color: #4a0404");
                textLabel.setTextFill(Color.web("#ffffff"));
                back.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm()));
                search.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/SearchWhite.png")).toExternalForm()));
                break;
        }
    }

    public void close(MouseEvent mouseEvent) throws SQLException, IOException {
        if (type){
            LiveState.group = group;
            LiveState.CGState = 2;
            LiveState.groupState = 0;
            DataBase.main.refresh();
        } else {
            LiveState.chat = chat;
            LiveState.CGState = 1;
            LiveState.chatState = 0;
            DataBase.main.refresh();
        }
    }
}
