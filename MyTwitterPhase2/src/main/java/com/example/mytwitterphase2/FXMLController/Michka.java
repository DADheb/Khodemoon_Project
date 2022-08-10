package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Michka implements Initializable {
    @FXML
    private AnchorPane mainPane;
    @FXML
    private ImageView michkaBack;
    @FXML
    private ImageView enterImage;
    @FXML
    private Label enterL;
    private double scale=1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scale = Creator.subScale;
        //Scale ro bekhoon az ye ja
        mainPane.setPrefHeight(600 * scale);
        mainPane.setPrefWidth(1000 * scale);
        michkaBack.setLayoutX(20 * scale);
        michkaBack.setFitHeight(750 * scale);
        michkaBack.setFitWidth(1000 * scale);
        enterImage.setLayoutX(881 * scale);
        enterImage.setLayoutY(471 * scale);
        enterImage.setFitHeight(100 * scale);
        enterImage.setFitWidth(112 * scale);
        enterL.setLayoutX(905 * scale);
        enterL.setLayoutY(495 * scale);
        enterL.setFont(Font.font(16 *scale));
        enterL.setPrefHeight(22 * scale);
        enterL.setPrefHeight(53 * scale);


    }

    public void enterProgram(MouseEvent mouseEvent) throws SQLException, IOException {
        LiveState.state = 1;
        DataBase.main.refresh();
    }
}
