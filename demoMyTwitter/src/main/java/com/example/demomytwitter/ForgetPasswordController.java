package com.example.demomytwitter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
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

public class ForgetPasswordController implements Initializable {

    public ScrollPane mainPane;
    public AnchorPane anchorPane;
    public ImageView twitterImg;
    public Text changeText;
    public TextField usernameField;
    public TextField questionField;
    public PasswordField passwordField;
    public Text animalText;
    public Text accountText;
    public Text signUpText;
    public Text tooShortText;
    public Text WrongText;
    public Text noUserText;
    public Text answerText;
    public Text logInText;
    public Rectangle logInRect;
    public Circle circ1;
    public Circle circ2;
    public ImageView exitImg;

    String username, question, password;

    @FXML
    private Scene scene;
    private Stage stage;
    private Double myScale =1.0 ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initialValues();
        initial(Creator.scale);

    }

    public void initial(double scale) {
        myScale = scale;
        scale *= 1.5;
        this.mainPane.setPrefWidth(1000 * myScale);
        this.anchorPane.setPrefWidth(1000 * myScale);
        this.mainPane.setPrefHeight(600 * myScale);
        this.anchorPane.setPrefHeight(600 * myScale);
        this.twitterImg.setLayoutX(292d * scale);
        this.twitterImg.setLayoutY(0d * scale);
        this.twitterImg.setFitHeight(107d * scale);
        this.twitterImg.setFitWidth(119d * scale);
        this.changeText.setFont(Font.font(26D * scale));
        this.changeText.setLayoutX(208d * scale);
        this.changeText.setLayoutY(121d * scale);
        this.animalText.setFont(Font.font(15D * scale));
        this.animalText.setLayoutX(225d * scale);
        this.animalText.setLayoutY(208d * scale);
        this.accountText.setFont(Font.font(16D * scale));
        this.accountText.setLayoutX(230d * scale);
        this.accountText.setLayoutY(386d * scale);
        this.signUpText.setFont(Font.font(16D * scale));
        this.signUpText.setLayoutX(397d * scale);
        this.signUpText.setLayoutY(386d * scale);
        this.logInText.setFont(Font.font(20D * scale));
        this.logInText.setLayoutX(314d * scale);
        this.logInText.setLayoutY(354d * scale);
        this.tooShortText.setFont(Font.font(12D * scale));
        this.tooShortText.setLayoutX(229d * scale);
        this.tooShortText.setLayoutY(321d * scale);
        this.WrongText.setFont(Font.font(12D * scale));
        this.WrongText.setLayoutX(229d * scale);
        this.WrongText.setLayoutY(321d * scale);
        this.noUserText.setFont(Font.font(12D * scale));
        this.noUserText.setLayoutX(225d * scale);
        this.noUserText.setLayoutY(385d * scale);
        this.answerText.setFont(Font.font(12D * scale));
        this.answerText.setLayoutX(225d * scale);
        this.answerText.setLayoutY(263d * scale);
        this.circ1.setLayoutX(243d * scale);
        this.circ1.setLayoutY(347d * scale);
        this.circ1.setRadius(20d * scale);
        this.circ2.setLayoutX(436d * scale);
        this.circ2.setLayoutY(347d * scale);
        this.circ2.setRadius(20d * scale);
        this.logInRect.setLayoutX(243d * scale);
        this.logInRect.setLayoutY(327d * scale);
        this.logInRect.setHeight(40d * scale);
        this.logInRect.setWidth(193d * scale);

        this.usernameField.setPrefWidth(227d * scale);
        this.usernameField.setPrefHeight(40d * scale);
        this.usernameField.setFont(Font.font(20D * scale));
        this.usernameField.setLayoutX(225d * scale);
        this.usernameField.setLayoutY(134d * scale);
        this.passwordField.setPrefWidth(227d * scale);
        this.passwordField.setPrefHeight(40d * scale);
        this.passwordField.setFont(Font.font(20D * scale));
        this.passwordField.setLayoutX(225d * scale);
        this.passwordField.setLayoutY(269d * scale);

        this.questionField.setPrefWidth(227d * scale);
        this.questionField.setPrefHeight(40d * scale);
        this.questionField.setFont(Font.font(20D * scale));
        this.questionField.setLayoutX(225d * scale);
        this.questionField.setLayoutY(211d * scale);

        this.exitImg.setLayoutX(0d * scale);
        this.exitImg.setLayoutY(1d * scale);
        this.exitImg.setFitHeight(54d * scale);
        this.exitImg.setFitWidth(51d * scale);
        Creator.scale = myScale;
    }

    public void initialValues() {
        noUserText.setVisible(false);
        WrongText.setVisible(false);
        answerText.setVisible(false);
        tooShortText.setVisible(false);
    }

    private void clearALL(){
        usernameField.clear();
        passwordField.clear();
        questionField.clear();
    }

    public Boolean passwordCheck1(String password){
        if(password.length() < 8){
            tooShortText.setVisible(true);
            clearALL();
            return false;
        }
        else
            return true;
    }

    public Boolean passwordCheck2(String password){
        if(!password.matches("([a-zA-Z1-9])\\w+")){
            WrongText.setVisible(true);
            clearALL();
            return false;
        }
        else
            return true;
    }

    @FXML
    protected void onSignUpClicked (MouseEvent e) throws IOException {
        // with node
    }

    @FXML
    protected void onLogInClicked (MouseEvent e) throws IOException {
        initialValues();
        Creator.setUsername = usernameField.getText();
        Creator.setPassword = passwordField.getText();
        Creator.setQuestion = questionField.getText();
        int index = DataBase.getUserNames().indexOf(username);
        if (index == -1){
            clearALL();
            noUserText.setVisible(true);
        }
        else {
            if(!DataBase.getUsers().get(DataBase.getUserID(username)).getSecurityQuestionsAnswers().equals(question)){
                clearALL();
                answerText.setVisible(true);
            }
            else{
                if(passwordCheck1(password) && passwordCheck2(password)){
                    // بره تو صفحه اصلی اکانت
                }
                else{
                    clearALL();
                }
            }
        }
    }

    @FXML
    protected void onExitClicked (MouseEvent e) throws IOException {
        System.exit(0);
    }

}
