package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ChatAndGroup;
import com.example.mytwitterphase2.Controller.Sort;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class JustGroups implements Initializable {
    @FXML
    public Pane pane;
    @FXML

    public ScrollPane scrollPane;
    @FXML

    public VBox vBox;
    public Pane top;
    public Label all;
    public Label chat;
    public Label group;
    public Line line;
    public Separator sep1;
    public Separator sep2;
    public Separator sep3;
    public ImageView backImage;
    public Circle groupCir;
    public ImageView groupImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double scale = Creator.menuScale;
        pane.setPrefWidth(400 * scale);
        pane.setPrefHeight(600 * scale);
        scrollPane.setPrefWidth(400*scale);
        scrollPane.setPrefHeight(550*scale);
        scrollPane.setLayoutY(50*scale);
        vBox.setPrefWidth(385*scale);
        vBox.setPrefHeight(0);
        top.setPrefHeight(50*scale);
        top.setPrefWidth(400*scale);
        all.setFont(Font.font(20*scale));
        all.setLayoutX(100*scale);
        all.setLayoutY(10*scale);
        chat.setFont(Font.font(20*scale));
        chat.setLayoutY(10*scale);
        chat.setLayoutX(205*scale);
        group.setFont(Font.font(20*scale));
        group.setLayoutX(310*scale);
        group.setLayoutY(10*scale);
        line.setStartX(288*scale);
        line.setEndX(400*scale);
        line.setStartY(49*scale);
        line.setEndY(49*scale);
        sep1.setPrefHeight(50*scale);
        sep2.setPrefHeight(50*scale);
        sep3.setPrefHeight(50*scale);
        sep1.setLayoutX(55*scale);
        sep2.setLayoutX(170*scale);
        sep3.setLayoutX(285*scale);
        backImage.setFitWidth(40*scale);
        backImage.setFitHeight(40*scale);
        backImage.setLayoutX(10*scale);
        backImage.setLayoutY(5*scale);

        groupCir.setCenterX(340*scale);
        groupCir.setCenterY(550*scale);
        groupCir.setRadius(40*scale);
        groupImage.setFitHeight(65*scale);
        groupImage.setFitWidth(65*scale);
        groupImage.setLayoutX(307.5*scale);
        groupImage.setLayoutY(517.5*scale);
        ArrayList<ChatAndGroup> chatGroups = Sort.sortChatGroup();
        for (ChatAndGroup c : chatGroups){
            Node node;
            if(c.getType()!=1){
                try {
                    node = Creator.showShortGroup(c.getGroup(),vBox.getPrefWidth()/600.0);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                node.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        try {
                            LiveState.group = c.getGroup();
                            goToGroup();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                vBox.setPrefHeight(vBox.getPrefHeight()+150*scale);
                vBox.getChildren().add(node);
            }
        }
        switch (DataBase.theme){
            case 1 :
                vBox.setStyle("-fx-background-color: #0096ff");
                top.setStyle("-fx-background-color: #0096ff");
                groupCir.setFill(Color.web("#0437f2"));
                break;
            case 2 :
                vBox.setStyle("-fx-background-color: #191970");
                top.setStyle("-fx-background-color: #191970");
                all.setTextFill(Color.web("#ffffff"));
                chat.setTextFill(Color.web("#ffffff"));
                group.setTextFill(Color.web("#ffffff"));
                line.setStroke(Color.web("#ffffff"));
                backImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm()));
                groupCir.setFill(Color.web("#00008b"));
                groupImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/newGroupWhite.png")).toExternalForm()));
                break;
            case 3 :
                vBox.setStyle("-fx-background-color: #f88379");
                top.setStyle("-fx-background-color: #f88379");
                groupCir.setFill(Color.web("#c21e56"));
                break;
            case 4 :
                vBox.setStyle("-fx-background-color: #4a0404");
                top.setStyle("-fx-background-color: #4a0404");
                all.setTextFill(Color.web("#ffffff"));
                chat.setTextFill(Color.web("#ffffff"));
                group.setTextFill(Color.web("#ffffff"));
                line.setStroke(Color.web("#ffffff"));
                backImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm()));
                groupCir.setFill(Color.web("#8b0000"));
                groupImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/newGroupWhite.png")).toExternalForm()));
                break;
        }
    }


    public void goNewGroup(MouseEvent mouseEvent) throws SQLException, IOException, InterruptedException {
        LiveState.CGState = 4;
        DataBase.main.refresh();
    }

    public void goJustChat(MouseEvent mouseEvent) throws SQLException, IOException, InterruptedException {
        LiveState.state = 9;
        LiveState.chatMenuState = 2;
        DataBase.main.refresh();
    }

    public void goChatGroup(MouseEvent mouseEvent) throws SQLException, IOException, InterruptedException {
        LiveState.state = 9;
        LiveState.chatMenuState = 1;
        DataBase.main.refresh();
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 1;
        DataBase.main.showHome();
    }

    public void goToGroup() throws InterruptedException, SQLException, IOException {
        Thread.sleep(10);
        LiveState.CGState = 2;
        LiveState.groupState = 0;
        DataBase.main.refresh();
    }
}
