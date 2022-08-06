package com.example.demomytwitter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    public ScrollPane mainPane;
    public AnchorPane anchorPane;
    public TextField usernameField;
    public TextField questionField;
    public TextField passwordField;
    public Text existsText;
    public Text tooShortText;
    public Text animalText;
    public Text alreadyHaveText;
    public Text logInText;
    public Text signUpText;
    public Text joinText;
    public Text WrongText;
    public Rectangle signUpRect;
    public Circle Cicl1;
    public Circle Cicl2;
    public ImageView twitterImg;
    public ImageView exitImg;

    @FXML
    private Scene scene;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initialValues();
        initial(Creator.scale);
    }

    public void initial(double scale) {
        this.mainPane.setPrefWidth(600 * scale);
        this.anchorPane.setPrefWidth(600 * scale);
        this.joinText.setLayoutX (195d* scale);
        this.joinText.setLayoutY(121d * scale);
        this.joinText.setFont(Font.font(24D * scale));
        this.usernameField.setPrefWidth(227d * scale);
        this.usernameField.setPrefHeight(35d * scale);
        this.usernameField.setFont(Font.font(16D * scale));
        this.usernameField.setLayoutX(190d * scale);
        this.usernameField.setLayoutY(141d * scale);
        this.passwordField.setPrefWidth(227d * scale);
        this.passwordField.setPrefHeight(35d * scale);
        this.passwordField.setFont(Font.font(16D * scale));
        this.passwordField.setLayoutX(190d * scale);
        this.passwordField.setLayoutY(254d * scale);
        this.questionField.setPrefWidth(227d * scale);
        this.questionField.setPrefHeight(35d * scale);
        this.questionField.setFont(Font.font(16D * scale));
        this.questionField.setLayoutX(190d * scale);
        this.questionField.setLayoutY(212d * scale);
        this.existsText.setLayoutX (191d* scale);
        this.existsText.setLayoutY(188d * scale);
        this.existsText.setFont(Font.font(12D * scale));
        this.animalText.setLayoutX (193d* scale);
        this.animalText.setLayoutY(206d * scale);
        this.animalText.setFont(Font.font(15D * scale));
        this.tooShortText.setLayoutX (193d* scale);
        this.tooShortText.setLayoutY(301d * scale);
        this.tooShortText.setFont(Font.font(12D * scale));
        this.WrongText.setLayoutX (193d* scale);
        this.WrongText.setLayoutY(301d * scale);
        this.WrongText.setFont(Font.font(12D * scale));
        this.Cicl1.setLayoutX(206d * scale);
        this.Cicl1.setLayoutY(333d * scale);
        this.Cicl1.setRadius(20d * scale);
        this.Cicl2.setLayoutX(399d * scale);
        this.Cicl2.setLayoutY(333d * scale);
        this.Cicl2.setRadius(20d * scale);
        this.signUpRect.setLayoutX(206d * scale);
        this.signUpRect.setLayoutY(313d * scale);
        this.signUpRect.setHeight(40d * scale);
        this.signUpRect.setWidth(193d * scale);
        this.signUpText.setFont(Font.font(20D * scale));
        this.signUpText.setLayoutX(270d * scale);
        this.signUpText.setLayoutY(340d * scale);
        this.tooShortText.setLayoutX (193d* scale);
        this.tooShortText.setLayoutY(301d * scale);
        this.tooShortText.setFont(Font.font(12D * scale));
        this.alreadyHaveText.setLayoutX (182d* scale);
        this.alreadyHaveText.setLayoutY(378d * scale);
        this.alreadyHaveText.setFont(Font.font(16D * scale));
        this.logInText.setLayoutX (363d* scale);
        this.logInText.setLayoutY(378d * scale);
        this.logInText.setFont(Font.font(16D * scale));
        this.twitterImg.setLayoutX(252d * scale);
        this.twitterImg.setLayoutY(0d * scale);
        this.twitterImg.setFitHeight(107d * scale);
        this.twitterImg.setFitWidth(119d * scale);
        this.exitImg.setLayoutX(0d * scale);
        this.exitImg.setLayoutY(1d * scale);
        this.exitImg.setFitHeight(54d * scale);
        this.exitImg.setFitWidth(51d * scale);
    }
    public void initialValues() {
        existsText.setVisible(false);
        tooShortText.setVisible(false);
        WrongText.setVisible(false);
    }

    public void clearAll(){
        usernameField.clear();
        questionField.clear();
        passwordField.clear();
    }
    public Boolean passwordCheck1(String password){
        if(password.length() < 8){
            tooShortText.setVisible(true);
            clearAll();
            return false;
        }
        else
            return true;
    }

    public Boolean passwordCheck2(String password){
        if(!password.matches("([a-zA-Z1-9])\\w+")){
            WrongText.setVisible(true);
            clearAll();
            return false;
        }
        else
            return true;
    }

    @FXML
    protected void onSignUpClicked(MouseEvent e) throws IOException {
        initialValues();
        String username, question,password;
        username = usernameField.getText();
        Creator.setUsername = username;
        question = questionField.getText();
        Creator.setQuestion = question;
        password = passwordField.getText();
        Creator.setPassword = password;

        if(!username.isEmpty() && !question.isEmpty() && !password.isEmpty()){
            if(!DataBase.getUserNames().contains(username)) {
                if(passwordCheck1(password) && passwordCheck2(password)){
                    // with node sign in detail
                }
            clearAll();
            }
            else{
                existsText.setVisible(true);
                clearAll();
            }

        }
        else{
            clearAll();
        }
    }
    @FXML
    protected void onLogInClicked(MouseEvent e) throws IOException {
        // with node
    }

    @FXML
    protected void onExitClicked (MouseEvent e) throws IOException {
        System.exit(0);
    }

}
