package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.Controller.MessageController;
import com.example.mytwitterphase2.Controller.UserController;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Chat;
import com.example.mytwitterphase2.entity.Message;
import com.example.mytwitterphase2.entity.User;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChatF implements Initializable {
    public Pane chat;
    public VBox mainVbox;
    public Pane infoPane;
    public Circle cir;
    public Label nameLabel;
    public ImageView search;
    public ImageView back;
    public ImageView barImage;
    public ScrollPane main;
    public Pane textPane;
    public TextArea textInput;
    public ImageView sendImage;
    public Rectangle messageInfoBack;
    public VBox messageInfo;
    public Pane reply;
    public Label replyLabel;
    public ImageView replyImage;
    public Separator sep;
    public Pane forward;
    public Label forwardLabel;
    public ImageView forwardImage;
    public Separator sep1;
    public Pane cancel;
    public Label cancelLabel;
    public ImageView cancelImage;
    public Rectangle chatInfoBack;
    public VBox chatInfo;
    public Pane block;
    public Label blockLabel;
    public ImageView blockImage;
    public Separator sep2;
    public Pane delete;
    public Label deleteLabel;
    public ImageView deleteImage;
    public VBox messageVBox;

    public Chat mainChat;
    public User secUser;
    public ImageView cancelImage1;
    public Label cancelLabel1;
    public Pane cancel1;
    public Separator sep5;
    public ImageView editImage;
    public Label editLabel;
    public Pane edit;
    public Separator sep4;
    public ImageView forwardImage1;
    public Label forwardLabel1;
    public Pane forward1;
    public Separator sep3;
    public ImageView replyImage1;
    public Label replyLabel1;
    public Pane reply1;
    public VBox messageInfo1;
    public Rectangle messageInfoBack1;

    public int sendType =0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double scale = Creator.mainScale*600.0/615.0;
        mainChat = Creator.c;
        secUser = ControllerManager.getSecUserChat(mainChat);

        chat.setPrefWidth(600*scale);
        chat.setPrefHeight(600*scale);

        mainVbox.setPrefWidth(600*scale);
        mainVbox.setPrefHeight(600*scale);

        infoPane.setPrefWidth(600*scale);
        infoPane.setPrefHeight(70*scale);

        cir.setRadius(30*scale);
        cir.setCenterX(105*scale);
        cir.setLayoutY(35*scale);
        cir.setFill(new ImagePattern(secUser.getProfileImage()));

        nameLabel.setFont(Font.font(24*scale));
        nameLabel.setLayoutX(155*scale);
        nameLabel.setLayoutY(18*scale);
        nameLabel.setText(secUser.getUserName());

        search.setFitWidth(70*scale);
        search.setFitHeight(70*scale);
        search.setLayoutX(460*scale);

        back.setFitWidth(50*scale);
        back.setFitHeight(50*scale);
        back.setLayoutX(10*scale);
        back.setLayoutY(10*scale);
        if(LiveState.subState==1){
            back.setVisible(false);
        } else {
            back.setVisible(true);
        }

        barImage.setFitWidth(60*scale);
        barImage.setFitHeight(60*scale);
        barImage.setLayoutX(535*scale);
        barImage.setLayoutY(5*scale);

        main.setPrefWidth(600*scale);
        main.setPrefHeight(600*scale-120*scale);

        textPane.setPrefWidth(600*scale);
        textPane.setPrefHeight(50*scale);

        textInput.setPrefWidth(540*scale);
        textInput.setPrefHeight(40*scale);
        textInput.setLayoutX(5*scale);
        textInput.setLayoutY(5*scale);

        sendImage.setFitWidth(50*scale);
        sendImage.setFitHeight(50*scale);
        sendImage.setLayoutX(550*scale);

        messageInfoBack.setWidth(150*scale);
        messageInfoBack.setHeight(150*scale);
        messageInfoBack.setLayoutX(225*scale);
        messageInfoBack.setLayoutY(225*scale);
        messageInfoBack.setVisible(false);
        messageInfoBack.setArcWidth(40*scale);
        messageInfoBack.setArcHeight(40*scale);

        messageInfo.setPrefWidth(150*scale);
        messageInfo.setPrefHeight(150*scale);
        messageInfo.setLayoutX(225*scale);
        messageInfo.setLayoutY(225*scale);
        messageInfo.setStyle("-fx-border-color: #000000; -fx-border-width: "+4*scale+"; -fx-border-radius: "+20*scale+";");

        reply.setPrefWidth(150*scale);
        reply.setPrefHeight(50*scale);

        replyLabel.setFont(Font.font(24*scale));
        replyLabel.setLayoutX(5*scale);
        replyLabel.setLayoutY(7*scale);

        replyImage.setFitWidth(50*scale);
        replyImage.setFitHeight(50*scale);
        replyImage.setLayoutX(95*scale);

        sep.setPrefWidth(150*scale);

        forward.setPrefWidth(150*scale);
        forward.setPrefHeight(50*scale);

        forwardLabel.setFont(Font.font(24*scale));
        forwardLabel.setLayoutX(5*scale);
        forwardLabel.setLayoutY(7*scale);

        forwardImage.setFitWidth(40*scale);
        forwardImage.setFitHeight(40*scale);
        forwardImage.setLayoutX(100*scale);
        forwardImage.setLayoutY(5*scale);

        sep1.setPrefWidth(150*scale);

        cancel.setPrefWidth(150*scale);
        cancel.setPrefHeight(50*scale);

        cancelLabel.setFont(Font.font(24*scale));
        cancelLabel.setLayoutX(5*scale);
        cancelLabel.setLayoutY(7*scale);

        cancelImage.setFitWidth(40*scale);
        cancelImage.setFitHeight(40*scale);
        cancelImage.setLayoutX(100*scale);
        cancelImage.setLayoutY(5*scale);

        chatInfoBack.setWidth(150*scale);
        chatInfoBack.setHeight(100*scale);
        chatInfoBack.setLayoutX(450*scale);
        chatInfoBack.setLayoutY(70*scale);
        chatInfoBack.setArcWidth(40*scale);
        chatInfoBack.setArcHeight(40*scale);
        chatInfoBack.setVisible(false);

        chatInfo.setPrefWidth(150*scale);
        chatInfo.setPrefHeight(100*scale);
        chatInfo.setLayoutX(450*scale);
        chatInfo.setLayoutY(70*scale);
        chatInfo.setStyle("-fx-border-color: #000000; -fx-border-width: "+4*scale+"; -fx-border-radius: "+20*scale+";");
        chatInfo.setVisible(false);

        block.setPrefWidth(150*scale);
        block.setPrefHeight(50*scale);

        blockLabel.setFont(Font.font(24*scale));
        blockLabel.setLayoutX(5*scale);
        blockLabel.setLayoutY(7*scale);
        if(DataBase.getUser().getBlock().contains(secUser)){
            blockLabel.setText("Unblock");
        }

        blockImage.setFitWidth(50*scale);
        blockImage.setFitHeight(50*scale);
        blockImage.setLayoutX(95*scale);

        sep2.setPrefWidth(150*scale);

        delete.setPrefWidth(150*scale);
        delete.setPrefHeight(50*scale);

        deleteLabel.setFont(Font.font(24*scale));
        deleteLabel.setLayoutX(5*scale);
        deleteLabel.setLayoutY(7*scale);

        deleteImage.setFitWidth(40*scale);
        deleteImage.setFitHeight(40*scale);
        deleteImage.setLayoutX(100*scale);
        deleteImage.setLayoutY(5*scale);

        messageVBox.setPrefWidth(585*scale);
        messageVBox.setPrefHeight(480*scale);

        cancelImage1.setFitWidth(40*scale);
        cancelImage1.setFitHeight(40*scale);
        cancelImage1.setLayoutX(100*scale);
        cancelImage1.setLayoutY(5*scale);

        cancelLabel1.setFont(Font.font(24*scale));
        cancelLabel1.setLayoutX(5*scale);
        cancelLabel1.setLayoutY(7*scale);

        cancel1.setPrefWidth(150*scale);
        cancel1.setPrefHeight(50*scale);

        sep5.setPrefWidth(150*scale);

        editImage.setFitWidth(50*scale);
        editImage.setFitHeight(50*scale);
        editImage.setLayoutX(95*scale);

        editLabel.setFont(Font.font(24*scale));
        editLabel.setLayoutX(5*scale);
        editLabel.setLayoutY(7*scale);

        edit.setPrefWidth(150*scale);
        edit.setPrefHeight(50*scale);

        sep4.setPrefWidth(150*scale);

        messageInfoBack1.setWidth(150*scale);
        messageInfoBack1.setHeight(200*scale);
        messageInfoBack1.setLayoutX(225*scale);
        messageInfoBack1.setLayoutY(200*scale);
        messageInfoBack1.setVisible(false);
        messageInfoBack1.setArcWidth(40*scale);
        messageInfoBack1.setArcHeight(40*scale);

        messageInfo1.setPrefWidth(150*scale);
        messageInfo1.setPrefHeight(200*scale);
        messageInfo1.setLayoutX(225*scale);
        messageInfo1.setLayoutY(200*scale);
        messageInfo1.setStyle("-fx-border-color: #000000; -fx-border-width: "+4*scale+"; -fx-border-radius: "+20*scale+";");

        reply1.setPrefWidth(150*scale);
        reply1.setPrefHeight(50*scale);

        replyLabel1.setFont(Font.font(24*scale));
        replyLabel1.setLayoutX(5*scale);
        replyLabel1.setLayoutY(7*scale);

        replyImage1.setFitWidth(50*scale);
        replyImage1.setFitHeight(50*scale);
        replyImage1.setLayoutX(95*scale);

        sep3.setPrefWidth(150*scale);

        forward1.setPrefWidth(150*scale);
        forward1.setPrefHeight(50*scale);

        forwardLabel1.setFont(Font.font(24*scale));
        forwardLabel1.setLayoutX(5*scale);
        forwardLabel1.setLayoutY(7*scale);

        forwardImage1.setFitWidth(40*scale);
        forwardImage1.setFitHeight(40*scale);
        forwardImage1.setLayoutX(100*scale);
        forwardImage1.setLayoutY(5*scale);

        if(secUser.getBlock().contains(DataBase.getUser())){
            sendImage.setVisible(false);
            textInput.setPromptText("you are BLOCK");
        }

        Collections.sort(mainChat.getMessages());
        messageVBox.setPrefHeight(600*scale);
        for(int i = mainChat.getMessages().size()-1 ; i>=0;i--){
            Message message = mainChat.getMessages().get(i);
            Node node ;
            try {
                node = Creator.showShortMessage(message,messageVBox.getPrefWidth()/600.0);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            node.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        LiveState.message = message;
                        selectM();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            messageVBox.setPrefHeight(messageVBox.getPrefHeight()+Creator.size);
            messageVBox.getChildren().add(node);
        }

        switch (DataBase.theme){
            case 1 :
                chat.setStyle("-fx-background-color: #0096ff");
                messageVBox.setStyle("-fx-background-color: #0096ff");
                messageInfoBack.setFill(Color.web("#0437f2"));
                messageInfoBack1.setFill(Color.web("#0437f2"));
                chatInfoBack.setFill(Color.web("#0437f2"));
                break;
            case 2 :
                chat.setStyle("-fx-background-color: #191970");
                messageVBox.setStyle("-fx-background-color: #191970");
                messageInfoBack.setFill(Color.web("#00008b"));
                messageInfoBack1.setFill(Color.web("#00008b"));
                chatInfoBack.setFill(Color.web("#00008b"));
                search.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/SearchWhite.png")).toExternalForm()));
                back.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm()));
                barImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BarWhite.png")).toExternalForm()));
                sendImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/SendWhite.png")).toExternalForm()));
                replyImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ReplyWhite.png")).toExternalForm()));
                replyImage1.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ReplyWhite.png")).toExternalForm()));
                forwardImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ForwardWhite.png")).toExternalForm()));
                forwardImage1.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ForwardWhite.png")).toExternalForm()));
                cancelImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/CancelWhite.png")).toExternalForm()));
                cancelImage1.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/CancelWhite.png")).toExternalForm()));
                blockImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/CancelWhite.png")).toExternalForm()));
                deleteImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/DeleteWhite.png")).toExternalForm()));
                editImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/EditWhite.png")).toExternalForm()));
                messageInfo.setStyle("-fx-border-color: #ffffff; -fx-border-width: "+4*scale+"; -fx-border-radius: "+20*scale+";");
                messageInfo1.setStyle("-fx-border-color: #ffffff; -fx-border-width: "+4*scale+"; -fx-border-radius: "+20*scale+";");
                chatInfo.setStyle("-fx-border-color: #ffffff; -fx-border-width: "+4*scale+"; -fx-border-radius: "+20*scale+";");
                nameLabel.setTextFill(Color.web("#ffffff"));
                replyLabel.setTextFill(Color.web("#ffffff"));
                replyLabel1.setTextFill(Color.web("#ffffff"));
                forwardLabel.setTextFill(Color.web("#ffffff"));
                forwardLabel1.setTextFill(Color.web("#ffffff"));
                cancelLabel.setTextFill(Color.web("#ffffff"));
                cancelLabel1.setTextFill(Color.web("#ffffff"));
                blockLabel.setTextFill(Color.web("#ffffff"));
                deleteLabel.setTextFill(Color.web("#ffffff"));
                editLabel.setTextFill(Color.web("#ffffff"));
                break;
            case 3 :
                chat.setStyle("-fx-background-color: #f88379");
                messageVBox.setStyle("-fx-background-color: #f88379");
                messageInfoBack.setFill(Color.web("#c21e56"));
                messageInfoBack1.setFill(Color.web("#c21e56"));
                chatInfoBack.setFill(Color.web("#c21e56"));
                break;
            case 4 :
                chat.setStyle("-fx-background-color: #4a0404");
                messageVBox.setStyle("-fx-background-color: #4a0404");
                messageInfoBack.setFill(Color.web("#8b0000"));
                messageInfoBack1.setFill(Color.web("#8b0000"));
                chatInfoBack.setFill(Color.web("#8b0000"));
                search.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/SearchWhite.png")).toExternalForm()));
                back.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm()));
                barImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BarWhite.png")).toExternalForm()));
                sendImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/SendWhite.png")).toExternalForm()));
                replyImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ReplyWhite.png")).toExternalForm()));
                replyImage1.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ReplyWhite.png")).toExternalForm()));
                forwardImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ForwardWhite.png")).toExternalForm()));
                forwardImage1.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ForwardWhite.png")).toExternalForm()));
                cancelImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/CancelWhite.png")).toExternalForm()));
                cancelImage1.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/CancelWhite.png")).toExternalForm()));
                blockImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/CancelWhite.png")).toExternalForm()));
                deleteImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/DeleteWhite.png")).toExternalForm()));
                editImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/EditWhite.png")).toExternalForm()));
                messageInfo.setStyle("-fx-border-color: #ffffff; -fx-border-width: "+4*scale+"; -fx-border-radius: "+20*scale+";");
                messageInfo1.setStyle("-fx-border-color: #ffffff; -fx-border-width: "+4*scale+"; -fx-border-radius: "+20*scale+";");
                chatInfo.setStyle("-fx-border-color: #ffffff; -fx-border-width: "+4*scale+"; -fx-border-radius: "+20*scale+";");
                nameLabel.setTextFill(Color.web("#ffffff"));
                replyLabel.setTextFill(Color.web("#ffffff"));
                replyLabel1.setTextFill(Color.web("#ffffff"));
                forwardLabel.setTextFill(Color.web("#ffffff"));
                forwardLabel1.setTextFill(Color.web("#ffffff"));
                cancelLabel.setTextFill(Color.web("#ffffff"));
                cancelLabel1.setTextFill(Color.web("#ffffff"));
                blockLabel.setTextFill(Color.web("#ffffff"));
                deleteLabel.setTextFill(Color.web("#ffffff"));
                editLabel.setTextFill(Color.web("#ffffff"));
                break;
        }
    }
    public void selectM() throws InterruptedException {
        Thread.sleep(10);
        if(ControllerManager.getMessageUser(LiveState.message).equals(DataBase.getUser())){
            if(LiveState.message.isForwarded()){
                messageInfo.setVisible(true);
                messageInfoBack.setVisible(true);
            } else {
                messageInfo1.setVisible(true);
                messageInfoBack1.setVisible(true);
            }
        } else {
            messageInfo.setVisible(true);
            messageInfoBack.setVisible(true);
        }
    }

    public void cCancel(MouseEvent mouseEvent) throws SQLException, IOException, InterruptedException {
        DataBase.main.refresh();
    }

    public void cEdit(MouseEvent mouseEvent) {
        sendType = 1;
        textInput.setText(LiveState.message.getText());
        messageInfo1.setVisible(false);
        messageInfoBack1.setVisible(false);
        messageInfo.setVisible(false);
        messageInfoBack.setVisible(false);
    }

    public void cForward(MouseEvent mouseEvent) throws SQLException, IOException, InterruptedException {
        LiveState.CGState = 6;
        DataBase.main.refresh();
    }

    public void cReply(MouseEvent mouseEvent) {
        sendType = 2;
        messageInfo1.setVisible(false);
        messageInfoBack1.setVisible(false);
        messageInfo.setVisible(false);
        messageInfoBack.setVisible(false);
    }

    public void cDelete(MouseEvent mouseEvent) throws SQLException, IOException, InterruptedException {
        ControllerManager.deleteChat(mainChat);
        LiveState.CGState = 0;
        DataBase.main.refresh();
    }

    public void cBlock(MouseEvent mouseEvent) {
        if(DataBase.getUser().getBlock().contains(secUser)){
            UserController.unblock(DataBase.getUser(),secUser);
        } else {
            UserController.block(DataBase.getUser(),secUser);
        }
    }

    public void cSend(MouseEvent mouseEvent) throws SQLException, IOException, InterruptedException {
        String s =textInput.getText();
        if(s.length()!=0){
            switch (sendType){
                case 0 :
                    ControllerManager.messageOnChat(DataBase.getUser(),s,mainChat);
                    break;
                case 1 :
                    MessageController.editText(LiveState.message,s);
                    break;
                case 2 :
                    ControllerManager.messageReplyOnChat(DataBase.getUser(),s,mainChat,LiveState.message);
                    break;
            }
        }
        sendType = 0;
        DataBase.main.refresh();
    }

    public void cBar(MouseEvent mouseEvent) {
        chatInfo.setVisible(!chatInfo.isVisible());
        chatInfoBack.setVisible(!chatInfoBack.isVisible());
    }

    public void cBack(MouseEvent mouseEvent) throws SQLException, IOException, InterruptedException {
        LiveState.CGState = 0;
        DataBase.main.refresh();
    }

    public void cSearch(MouseEvent mouseEvent) throws SQLException, IOException, InterruptedException {
        Creator.aBoolean = false;
        LiveState.chat = mainChat;
        LiveState.CGState = 7 ;
        DataBase.main.refresh();
    }
}
