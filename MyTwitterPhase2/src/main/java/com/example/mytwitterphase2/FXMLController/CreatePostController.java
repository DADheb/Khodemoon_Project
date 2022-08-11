package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.entity.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreatePostController implements Initializable {

    @FXML
    private ScrollPane mainPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Text createText;
    @FXML
    private Button createButton;
    @FXML
    private Button cancelButton;
    @FXML
    private RadioButton textRadio;
    @FXML
    private RadioButton imageRadio;
    @FXML
    private TextArea textArea;
    @FXML
    private Text urlText;
    @FXML
    private TextArea urlField;

    private Color themeColor;
    private Color mode;
    private Post post;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.mainScale);
        urlText.setVisible(false);
        urlField.setVisible(false);
        if(DataBase.theme == 1) {
            this.urlField.setStyle("-fx-control-inner-background:White; -fx-font-family: Consolas; -fx-highlight-fill: #78a1d1; -fx-highlight-text-fill: #78a1d1; -fx-text-fill: #78a1d1; ");
            this.textArea.setStyle("-fx-control-inner-background:White; -fx-font-family: Consolas; -fx-highlight-fill: #78a1d1; -fx-highlight-text-fill: #78a1d1; -fx-text-fill: #78a1d1; ");
        }
        if(DataBase.theme == 2){
            this.urlField.setStyle("-fx-control-inner-background:Black; -fx-font-family: Consolas; -fx-highlight-fill: #78a1d1; -fx-highlight-text-fill: #78a1d1; -fx-text-fill: #78a1d1; ");
            this.textArea.setStyle("-fx-control-inner-background:Black; -fx-font-family: Consolas; -fx-highlight-fill: #78a1d1; -fx-highlight-text-fill: #78a1d1; -fx-text-fill: #78a1d1; ");
        }

    }

    public void initial(double scale) {
        theme();
        this.createText.setFill(themeColor);
        this.createText.setLayoutX (191d* scale);
        this.createText.setLayoutY(157d * scale);
        this.createText.setFont(Font.font(30D * scale));

        this.cancelButton.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.cancelButton.setTextFill(mode);
        this.cancelButton.setFont(Font.font(20D * scale));
        this.cancelButton.setLayoutX (191d* scale);
        this.cancelButton.setLayoutY(419d * scale);
        this.cancelButton.setPrefWidth(91d * scale);
        this.cancelButton.setPrefHeight(40d * scale);
        this.createButton.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.createButton.setTextFill(mode);
        this.createButton.setFont(Font.font(20D * scale));
        this.createButton.setLayoutX (325d* scale);
        this.createButton.setLayoutY(419d * scale);
        this.createButton.setPrefWidth(91d * scale);
        this.createButton.setPrefHeight(40d * scale);

        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.anchorPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.mainPane.setPrefWidth(600 * scale);
        this.anchorPane.setPrefWidth(600 * scale);
        this.mainPane.setPrefHeight(600 * scale);
        this.anchorPane.setPrefHeight(600 * scale);


        this.urlText.setFill(themeColor);
        this.urlText.setFont(Font.font(20D * scale));
        this.urlText.setLayoutX (108d* scale);
        this.urlText.setLayoutY(266d * scale);

        this.textRadio.setTextFill(themeColor);
        this.imageRadio.setTextFill(themeColor);
        this.textRadio.setFont(Font.font(20D * scale));
        this.imageRadio.setFont(Font.font(20D * scale));
        this.textRadio.setLayoutX (191d* scale);
        this.textRadio.setLayoutY(350d * scale);
        this.textRadio.setPrefWidth(170d * scale);
        this.textRadio.setPrefHeight(27d * scale);
        this.imageRadio.setLayoutX (326d* scale);
        this.imageRadio.setLayoutY(350d * scale);
        this.imageRadio.setPrefWidth(170d * scale);
        this.imageRadio.setPrefHeight(27d * scale);

        if(DataBase.theme > 2) {
            this.urlField.setStyle("-fx-control-inner-background: #" + mode.toString().substring(2) + ";-fx-font-family: Consolas; -fx-highlight-fill:" + themeColor.toString().substring(2) + ";-fx-highlight-fill:" + themeColor.toString().substring(2) + "; -fx-text-fill:" + themeColor.toString().substring(2));
            this.textArea.setStyle("-fx-control-inner-background: #" + mode.toString().substring(2) + ";-fx-font-family: Consolas; -fx-highlight-fill:" + themeColor.toString().substring(2) + ";-fx-highlight-fill:" + themeColor.toString().substring(2) + "; -fx-text-fill:" + themeColor.toString().substring(2));
        }
        this.urlField.setPrefWidth(325d * scale);
        this.urlField.setPrefHeight(45d * scale);
        this.urlField.setFont(Font.font(20D * scale));
        this.urlField.setLayoutX(170d * scale);
        this.urlField.setLayoutY(237d * scale);

        this.textArea.setPrefWidth(304d * scale);
        this.textArea.setPrefHeight(161d * scale);
        this.textArea.setFont(Font.font(20D * scale));
        this.textArea.setLayoutX(149d * scale);
        this.textArea.setLayoutY(179d * scale);


    }

    public void theme() {
        switch (DataBase.theme) {
            case 1:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.WHITE;
                break;
            case 2:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.BLACK;
                break;
            case 3:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.WHITE;
                break;
            case 4:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.BLACK;
                break;
        }
    }

    @FXML
    protected void Choose (ActionEvent e) throws IOException {
        if(textRadio.isSelected()) {
            textArea.setVisible(true);
            urlText.setVisible(false);
            urlField.setVisible(false);
        }
        else{
            textArea.setVisible(false);
            urlText.setVisible(true);
            urlField.setVisible(true);
        }
    }

    @FXML
    protected void onCreateClicked (ActionEvent e) throws IOException {
        if(textRadio.isSelected()) {
            String text = textArea.getText();
            post = ControllerManager.post(DataBase.getUser(),text,0);
            Creator.setPost(post);
            LiveState.post = post;
            LiveState.state = 10;
            DataBase.main.showProfile();
        }
        else{
            String url = urlField.getText();
            post = ControllerManager.post(DataBase.getUser(),url,1);
            Creator.setPost(post);
            LiveState.post = post;
            LiveState.state = 10;
            DataBase.main.showProfile();
        }
    }

    @FXML
    protected void onCancelClicked (ActionEvent e) throws IOException {
        LiveState.state = 10;
        DataBase.main.showProfile();
    }
}
