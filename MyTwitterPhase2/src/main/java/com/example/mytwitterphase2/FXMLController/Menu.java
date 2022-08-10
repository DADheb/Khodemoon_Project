package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Menu implements Initializable {
    @FXML
    private VBox mainVBox;
    @FXML
    private ScrollPane mainScrollPane;
    @FXML
    private Pane backPane;
    @FXML
    private Pane one;
    @FXML
    private Pane two;
    @FXML
    private Pane three;
    @FXML
    private Pane four;
    @FXML
    private Pane five;
    @FXML
    private Pane six;
    @FXML
    private Pane seven;
    @FXML
    private Pane eight;
    @FXML
    private Pane nine;
    @FXML
    private ImageView homeP;
    @FXML
    private ImageView exploreP;
    @FXML
    private ImageView proP;
    @FXML
    private ImageView requestP;
    @FXML
    private ImageView messagesP;
    @FXML
    private ImageView settingP;
    @FXML
    private ImageView suggestP;
    @FXML
    private ImageView logOutP;
    @FXML
    private ImageView postP;
    @FXML
    private ImageView tweeterP;
    @FXML
    private Label homeL;
    @FXML
    private Label exploreL;
    @FXML
    private Label messagesL;
    @FXML
    private Label postL;
    @FXML
    private Label proL;
    @FXML
    private Label settingL;
    @FXML
    private Label requestL;
    @FXML
    private Label suggestL;
    @FXML
    private Label logOutL;
    private double scale;
    private Color themeColor;
    private Color mode;
    private Image image;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scale = Creator.menuScale;
        theme();
        initial();

    }

    public void initial() {
        if (DataBase.getUser().getUserType() == false) {
            mainVBox.getChildren().remove(this.six);
        }

        mainScrollPane.setPrefWidth(400 * scale);
        backPane.setPrefWidth(400 * scale);
        mainVBox.setPrefWidth(400 * scale);
        one.setPrefWidth(400 * scale);
        two.setPrefWidth(400 * scale);
        three.setPrefWidth(400 * scale);
        four.setPrefWidth(400 * scale);
        five.setPrefWidth(400 * scale);
        six.setPrefWidth(400 * scale);
        seven.setPrefWidth(400 * scale);
        eight.setPrefWidth(400 * scale);
        nine.setPrefWidth(400 * scale);

        mainScrollPane.setPrefHeight(600 * scale);
        mainVBox.setPrefHeight(600 * scale);
        backPane.setPrefHeight(600 * scale);
        one.setPrefHeight(200 * scale);
        two.setPrefHeight(200 * scale);
        three.setPrefHeight(200 * scale);
        four.setPrefHeight(200 * scale);
        five.setPrefHeight(200 * scale);
        six.setPrefHeight(200 * scale);
        seven.setPrefHeight(200 * scale);
        eight.setPrefHeight(200 * scale);
        nine.setPrefHeight(200 * scale);

        homeL.setFont(Font.font(16 * scale));
        exploreL.setFont(Font.font(16 * scale));
        requestL.setFont(Font.font(16 * scale));
        postL.setFont(Font.font(16 * scale));
        settingL.setFont(Font.font(16 * scale));
        suggestL.setFont(Font.font(16 * scale));
        logOutL.setFont(Font.font(16 * scale));
        messagesL.setFont(Font.font(16 * scale));
        proL.setFont(Font.font(16 * scale));

        tweeterP.setFitWidth(100 * scale);
        homeP.setFitWidth(52 * scale);
        exploreP.setFitWidth(60 * scale);
        messagesP.setFitWidth(50 * scale);
        requestP.setFitWidth(48 * scale);
        logOutP.setFitWidth(51 * scale);
        proP.setFitWidth(47 * scale);
        settingP.setFitWidth(48 * scale);
        suggestP.setFitWidth(45 * scale);
        postP.setFitWidth(46 * scale);

        tweeterP.setFitHeight(93 * scale);
        homeP.setFitHeight(54 * scale);
        exploreP.setFitHeight(50 * scale);
        messagesP.setFitHeight(51 * scale);
        requestP.setFitHeight(51 * scale);
        logOutP.setFitHeight(52 * scale);
        proP.setFitHeight(45 * scale);
        settingP.setFitHeight(49 * scale);
        suggestP.setFitHeight(46 * scale);
        postP.setFitHeight(50 * scale);

        proP.setLayoutX(6 * scale);

        mainScrollPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        backPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        one.setStyle("-fx-border-width:0.5; -fx-border-color: #" + themeColor.toString().substring(2) + ";-fx-background-color: #" + mode.toString().substring(2));
        two.setStyle("-fx-border-width:0.5; -fx-border-color: #" + themeColor.toString().substring(2) + ";-fx-background-color: #" + mode.toString().substring(2));
        three.setStyle("-fx-border-width:0.5; -fx-border-color: #" + themeColor.toString().substring(2) + ";-fx-background-color: #" + mode.toString().substring(2));
        four.setStyle("-fx-border-width:0.5; -fx-border-color: #" + themeColor.toString().substring(2) + ";-fx-background-color: #" + mode.toString().substring(2));
        five.setStyle("-fx-border-width:0.5; -fx-border-color: #" + themeColor.toString().substring(2) + ";-fx-background-color: #" + mode.toString().substring(2));
        six.setStyle("-fx-border-width:0.5; -fx-border-color: #" + themeColor.toString().substring(2) + ";-fx-background-color: #" + mode.toString().substring(2));
        seven.setStyle("-fx-border-width:0.5; -fx-border-color: #" + themeColor.toString().substring(2) + ";-fx-background-color: #" + mode.toString().substring(2));
        eight.setStyle("-fx-border-width:0.5; -fx-border-color: #" + themeColor.toString().substring(2) + ";-fx-background-color: #" + mode.toString().substring(2));
        nine.setStyle("-fx-border-width:0.5; -fx-border-color: #" + themeColor.toString().substring(2) + ";-fx-background-color: #" + mode.toString().substring(2));

        homeL.setTextFill(themeColor);
        exploreL.setTextFill(themeColor);
        proL.setTextFill(themeColor);
        requestL.setTextFill(themeColor);
        messagesL.setTextFill(themeColor);
        logOutL.setTextFill(themeColor);
        postL.setTextFill(themeColor);
        settingL.setTextFill(themeColor);
        suggestL.setTextFill(themeColor);

    }

    public void theme() {
        switch (DataBase.theme) {
            case 1:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/Menu/tweeterBlue.png")).toExternalForm());
                this.tweeterP.setImage(this.image);
                break;
            case 2:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/Menu/tweeterBlue.png")).toExternalForm());
                this.tweeterP.setImage(this.image);
                break;
            case 3:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/Menu/tweeterRed.png")).toExternalForm());
                this.tweeterP.setImage(this.image);
                break;
            case 4:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/Menu/tweeterRed.png")).toExternalForm());
                this.tweeterP.setImage(this.image);
                break;
        }
    }

    public void showHome(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 6;
        DataBase.main.showHome();
    }

    public void showExplore(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 8;
        DataBase.main.showSearchUser();
    }

    public void showMessages(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 9;
        LiveState.chatMenuState = 1;
        LiveState.CGState = 0;
        DataBase.main.showCG();
    }

    public void showProfile(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 10;
        DataBase.main.showProfile();
    }

    public void showSetting(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 11;
        DataBase.main.showSetting();
    }

    public void showRequests(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 12;
        DataBase.main.showRequests();
    }

    public void showSuggest(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 13;
        DataBase.main.showSuggestions();
    }

    public void addPost(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 14;
        DataBase.main.showCreatPost();
    }

    public void logOut(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 1;
        DataBase.main.showLogin();
    }
}
