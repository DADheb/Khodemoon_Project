package com.example.mytwitterphase2.FXMLController.Objects;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Creator;
import com.example.mytwitterphase2.MainGraphic;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

public class ShortChat implements Initializable {
    @FXML
    public ImageView imgLabel;
    @FXML
    public Label lastMessage;
    @FXML
    public Region reg1InHBox;
    @FXML
    public Region reg2InVBox2;
    @FXML
    public HBox hBox;
    @FXML
    public Label name;
    @FXML
    public Region reg1InVBox2;
    @FXML
    public VBox vBox2InMainHBox;
    @FXML
    public Region reg2InMainHBox;
    @FXML
    public Circle cir;
    @FXML
    public Region regInVBox1;
    @FXML
    public VBox vBox1InMainHBox;
    @FXML
    public Region reg1InMainHBox;
    @FXML
    public HBox mainHBox;
    @FXML
    public Pane pane;
    public Region reg3InVBox2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = Creator.image;
        double scale = Creator.scale;
        cir.setRadius(65*scale);
        imgLabel.setFitWidth(60*scale);
        imgLabel.setFitHeight(60*scale);
        reg3InVBox2.setPrefWidth(435*scale);
        reg3InVBox2.setPrefHeight(45*scale);
        imgLabel.setLayoutX(500*scale);
        imgLabel.setLayoutY(45*scale);
        lastMessage.setFont(Font.font("System",20*scale));
        lastMessage.setText(Creator.string1);
        reg1InHBox.setPrefWidth(30*scale);
        reg1InHBox.setPrefHeight(30*scale);
        reg2InVBox2.setPrefWidth(435*scale);
        reg2InVBox2.setPrefHeight(15*scale);
        hBox.setPrefWidth(435*scale);
        hBox.setPrefHeight(30*scale);
        name.setFont(Font.font("System",24*scale));
        name.setText(Creator.string);
        if(!Creator.aBoolean){
            name.setFont(Font.font("System", FontWeight.BOLD,24*scale));
        }
        reg1InVBox2.setPrefWidth(435*scale);
        reg1InVBox2.setPrefHeight(25*scale);
        vBox2InMainHBox.setPrefWidth(435*scale);
        vBox2InMainHBox.setPrefHeight(150*scale);
        reg1InMainHBox.setPrefWidth(15*scale);
        reg1InMainHBox.setPrefHeight(150*scale);
        mainHBox.setPrefWidth(600*scale);
        mainHBox.setPrefHeight(150*scale);
        pane.setPrefWidth(600*scale);
        pane.setPrefHeight(150*scale);
        reg2InMainHBox.setPrefWidth(20*scale);
        reg2InMainHBox.setPrefHeight(150*scale);
        vBox1InMainHBox.setPrefWidth(130*scale);
        vBox1InMainHBox.setPrefHeight(150*scale);
        regInVBox1.setPrefWidth(130*scale);
        regInVBox1.setPrefHeight(10*scale);
        cir.setFill(new ImagePattern(image));
        if(DataBase.theme % 2== 0){
            mainHBox.setStyle("-fx-background-color: #000000");
            imgLabel.setImage(new Image(MainGraphic.class.getResource("Photo/Project/UserLabelDark.png").toExternalForm()));
            name.setStyle("-fx-text-fill : #ffffff");
            lastMessage.setStyle("-fx-text-fill : #ffffff");
        }

        /*pane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                Image image = new Image(MainGraphic.class.getResource("Photo/Project/UserProfWhite.png").toExternalForm());
                DataBase.setScale(MainGraphic.window.getWidth()/600.0);
                double scale = DataBase.getScale();
                cir.setRadius(65*scale);
                imgLabel.setFitWidth(60*scale);
                imgLabel.setFitHeight(60*scale);
                imgLabel.setLayoutX(500*scale);
                imgLabel.setLayoutY(45*scale);
                lastMessage.setFont(Font.font("System",20*scale));
                reg1InHBox.setPrefWidth(30*scale);
                reg1InHBox.setPrefHeight(30*scale);
                reg2InVBox2.setPrefWidth(435*scale);
                reg2InVBox2.setPrefHeight(25*scale);
                hBox.setPrefWidth(435*scale);
                hBox.setPrefHeight(30*scale);
                name.setFont(Font.font("System",24*scale));
                name.setLayoutX(0);
                reg1InVBox2.setPrefWidth(435*scale);
                reg1InVBox2.setPrefHeight(15*scale);
                vBox2InMainHBox.setPrefWidth(435*scale);
                vBox2InMainHBox.setPrefHeight(150*scale);
                reg1InMainHBox.setPrefWidth(15*scale);
                reg1InMainHBox.setPrefHeight(150*scale);
                mainHBox.setPrefWidth(600*scale);
                mainHBox.setPrefHeight(150*scale);
                pane.setPrefWidth(600*scale);
                pane.setPrefHeight(150*scale);
                reg2InMainHBox.setPrefWidth(20*scale);
                reg2InMainHBox.setPrefHeight(150*scale);
                vBox1InMainHBox.setPrefWidth(130*scale);
                vBox1InMainHBox.setPrefHeight(150*scale);
                regInVBox1.setPrefWidth(130*scale);
                regInVBox1.setPrefHeight(10*scale);
                cir.setFill(new ImagePattern(image));
            }
        });*/
    }
}
