package com.example.mytwitterphase2.FXMLController.Objects;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Creator;
import com.example.mytwitterphase2.FXMLController.LiveState;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Message;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ReplyMessage implements Initializable {
    public Pane pane;
    public ImageView BImage;
    public ImageView TImage;
    public Rectangle rect;
    public Label username;
    public Text text;
    public Line line;
    public Rectangle rectHide;
    public Label replyUser;
    public Label replyMessage;
    public ImageView replyImage;
    public Message message;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        message = Creator.m;

        username.setText(Creator.string);
        double scale = Creator.subScale;
        text.setWrappingWidth(350*scale);
        text.setText(Creator.string1);
        BImage.setLayoutX(0);
        BImage.setFitWidth(500*scale);
        BImage.setFitHeight(50*scale);
        TImage.setLayoutX(0);
        TImage.setLayoutY(-10*scale);
        TImage.setFitWidth(500*scale);
        TImage.setFitHeight(50*scale);
        username.setFont(Font.font("System", FontWeight.BOLD,18*scale));
        username.setLayoutX(70*scale);
        username.setLayoutY(5*scale);
        if(scale<0.9){
            username.setLayoutY(0);
        }
        text.setFont(Font.font("System",16*scale));
        text.setLayoutX(70 *scale);
        text.setLayoutY(55*scale);
        rect.setLayoutX(62*scale);
        rect.setLayoutY(40*scale);
        rect.setWidth(403*scale);
        rect.setHeight(text.getLayoutBounds().getHeight()+25*scale);
        pane.setPrefHeight(200*scale+text.getLayoutBounds().getHeight()-85.125*scale);
        pane.setPrefWidth(500*scale);
        BImage.setLayoutY(pane.getPrefHeight()-60*scale);
        line.setStartX(70*scale);
        line.setEndX(70*scale);
        line.setStartY(36*scale);
        line.setEndY(85*scale);
        replyUser.setText(Creator.string2);
        replyUser.setFont(Font.font(15*scale));
        replyMessage.setText(Creator.string3);
        replyMessage.setFont(Font.font(12*scale));
        rectHide.setHeight(50*scale);
        rectHide.setWidth(350*scale);
        rectHide.setLayoutY(36*scale);
        rectHide.setLayoutX(73*scale);
        replyImage.setFitHeight(50*scale);
        replyImage.setFitWidth(50*scale);
        replyImage.setLayoutY(35*scale);
        replyImage.setLayoutX(70*scale);
        line.setStrokeWidth(3*scale);
        Creator.size = pane.getPrefHeight();
        switch (DataBase.theme){
            case 1 :
                TImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/TMessageA.png")).toExternalForm()));
                BImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BMessageA.png")).toExternalForm()));
                rect.setFill(Color.web("#0437f2"));
                break;
            case 2 :
                TImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/TMessageB.png")).toExternalForm()));
                BImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BMessageB.png")).toExternalForm()));
                rect.setFill(Color.web("#00008b"));
                username.setTextFill(Color.web("#ffffff"));
                text.setFill(Color.web("#ffffff"));
                replyUser.setTextFill(Color.web("#ffffff"));
                replyMessage.setTextFill(Color.web("#ffffff"));
                line.setStroke(Color.web("#ffffff"));
                replyImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ReplyOnWhite.png")).toExternalForm()));
                break;
            case 3 :
                TImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/TMessageC.png")).toExternalForm()));
                BImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BMessageC.png")).toExternalForm()));
                rect.setFill(Color.web("#c21e56"));
                break;
            case 4 :
                TImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/TMessageD.png")).toExternalForm()));
                BImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BMessageD.png")).toExternalForm()));
                rect.setFill(Color.web("#8b0000"));
                username.setTextFill(Color.web("#ffffff"));
                text.setFill(Color.web("#ffffff"));
                replyUser.setTextFill(Color.web("#ffffff"));
                replyMessage.setTextFill(Color.web("#ffffff"));
                line.setStroke(Color.web("#ffffff"));
                replyImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ReplyOnWhite.png")).toExternalForm()));
                break;
        }
    }
    public void addM(MouseEvent mouseEvent) {
        LiveState.message = message;
    }

    public void goU(MouseEvent mouseEvent) throws IOException {
        LiveState.user = message.getUser();
        LiveState.state = 15;
        DataBase.main.showUser();
    }
}
