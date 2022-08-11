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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ForwardMessage implements Initializable {
    public Pane pane;
    public ImageView BImage;
    public ImageView TImage;
    public Rectangle rect;
    public Label username;
    public Text text;
    public Label forwardLabel;
    public ImageView forwardImage;
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
        rect.setHeight(text.getLayoutBounds().getHeight()-5*scale);
        pane.setPrefHeight(170*scale+text.getLayoutBounds().getHeight()-85.125*scale);
        pane.setPrefWidth(500*scale);
        BImage.setLayoutY(pane.getPrefHeight()-60*scale);
        forwardLabel.setPrefWidth(350*scale);
        forwardLabel.setFont(Font.font(18*scale));
        forwardLabel.setText(Creator.string2);
        forwardLabel.setLayoutY(30*scale);
        forwardLabel.setLayoutX(100*scale);
        forwardImage.setFitWidth(50*scale);
        forwardImage.setFitHeight(50*scale);
        forwardImage.setLayoutX(55*scale);
        forwardImage.setLayoutY(20*scale);
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
                forwardLabel.setTextFill(Color.web("#ffffff"));
                forwardImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ForwardOnWhite.png")).toExternalForm()));
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
                forwardLabel.setTextFill(Color.web("#ffffff"));
                forwardImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/ForwardOnWhite.png")).toExternalForm()));
                break;
        }

    }

    public void addM(MouseEvent mouseEvent) {
        LiveState.message = message;
    }

    public void goF(MouseEvent mouseEvent) throws IOException, InterruptedException {
        LiveState.user = message.getForwarder();
        if(message.getForwarder().equals(DataBase.getUser())){
            LiveState.state = 10;
            DataBase.main.showProfile();
        } else {
            LiveState.state = 15;
            DataBase.main.showUser();
        }
    }

    public void goU(MouseEvent mouseEvent) throws IOException, InterruptedException {
        LiveState.user = message.getUser();
        LiveState.state = 15;
        DataBase.main.showUser();
    }
}
