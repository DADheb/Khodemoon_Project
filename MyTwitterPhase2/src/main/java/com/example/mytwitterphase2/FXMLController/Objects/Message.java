package com.example.mytwitterphase2.FXMLController.Objects;

import com.example.mytwitterphase2.FXMLController.Creator;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Message implements Initializable {
    public Pane pane;
    public ImageView BImage;
    public ImageView TImage;
    public Rectangle rect;
    public Label username;
    public Text text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setText(Creator.string);
        text.setText(Creator.string1);
        double scale = Creator.scale;
        BImage.setLayoutX(70*scale);
        BImage.setLayoutY(pane.getPrefHeight()-60*scale);
        BImage.setFitWidth(500*scale);
        BImage.setFitHeight(50*scale);
        TImage.setLayoutX(70*scale);
        TImage.setLayoutY(-10*scale);
        TImage.setFitWidth(500*scale);
        TImage.setFitHeight(50*scale);
        username.setFont(Font.font("System", FontWeight.BOLD,18*scale));
        username.setLayoutX(141*scale);
        username.setLayoutY(5*scale);
        username.setPrefWidth(241*scale);
        text.setFont(Font.font("System",16*scale));
        text.setLayoutX(143*scale);
        text.setLayoutY(52*scale);
        text.setWrappingWidth(380*scale);
        rect.setLayoutX(132*scale);
        rect.setLayoutY(34*scale);
        rect.setWidth(403*scale);
        rect.setHeight(text.getLayoutBounds().getHeight()-25*scale);

    }
}
