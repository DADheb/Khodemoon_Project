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

public class SignInController implements Initializable {

    public ScrollPane mainPane;
    public AnchorPane anchorPane;
    public ImageView twitterImg;
    public Text usernameText;
    public TextField usernameField;
    public PasswordField passwordField;
    public Text enterText;
    public Text forgetText;
    public Text accountText;
    public Text signUpText;
    public Text logInText;
    public Text wrongText;
    public Rectangle logInRect;
    public Circle circ1;
    public Circle circ2;
    public ImageView exitImg;

    @FXML
    private Scene scene;
    private Stage stage;

    String username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initialValues();
        initial(Creator.scale);
        this.username = Creator.setUsername;
    }

    public void initial(double scale) {
        this.mainPane.setPrefWidth(600 * scale);
        this.anchorPane.setPrefWidth(600 * scale);
        this.twitterImg.setLayoutX(252d * scale);
        this.twitterImg.setLayoutY(0d * scale);
        this.twitterImg.setFitHeight(107d * scale);
        this.twitterImg.setFitWidth(119d * scale);
        this.usernameField.setPrefWidth(227d * scale);
        this.usernameField.setPrefHeight(35d * scale);
        this.usernameField.setFont(Font.font(20D * scale));
        this.usernameField.setLayoutX(186d * scale);
        this.usernameField.setLayoutY(150d * scale);
        this.passwordField.setPrefWidth(227d * scale);
        this.passwordField.setPrefHeight(35d * scale);
        this.passwordField.setFont(Font.font(20D * scale));
        this.passwordField.setLayoutX(186d * scale);
        this.passwordField.setLayoutY(196d * scale);
        this.forgetText.setFont(Font.font(15D * scale));
        this.forgetText.setLayoutX(239d * scale);
        this.forgetText.setLayoutY(270d * scale);
        this.enterText.setFont(Font.font(30D * scale));
        this.enterText.setLayoutX(171d * scale);
        this.enterText.setLayoutY(117d * scale);
        this.accountText.setFont(Font.font(16D * scale));
        this.accountText.setLayoutX(190d * scale);
        this.accountText.setLayoutY(355d * scale);
        this.signUpText.setFont(Font.font(16D * scale));
        this.signUpText.setLayoutX(352d * scale);
        this.signUpText.setLayoutY(355d * scale);
        this.circ1.setLayoutX(203d * scale);
        this.circ1.setLayoutY(296d * scale);
        this.circ1.setRadius(20d * scale);
        this.circ2.setLayoutX(396d * scale);
        this.circ2.setLayoutY(296d * scale);
        this.circ2.setRadius(20d * scale);
        this.logInRect.setLayoutX(203d * scale);
        this.logInRect.setLayoutY(276d * scale);
        this.logInRect.setHeight(40d * scale);
        this.logInRect.setWidth(193d * scale);
        this.logInText.setFont(Font.font(20D * scale));
        this.logInText.setLayoutX(274d * scale);
        this.logInText.setLayoutY(303d * scale);
        this.wrongText.setFont(Font.font(12D * scale));
        this.wrongText.setLayoutX(186d * scale);
        this.wrongText.setLayoutY(248d * scale);
        this.usernameText.setFont(Font.font(15D * scale));
        this.usernameText.setLayoutX(186d * scale);
        this.usernameText.setLayoutY(146d * scale);
        this.exitImg.setLayoutX(0d * scale);
        this.exitImg.setLayoutY(1d * scale);
        this.exitImg.setFitHeight(54d * scale);
        this.exitImg.setFitWidth(51d * scale);

    }

    public void initialValues() {
        wrongText.setVisible(false);
    }

    @FXML
    protected void onLogInClicked (MouseEvent e) throws IOException {
        initialValues();
        String password = passwordField.getText();
        Creator.setPassword = password;
        int index = DataBase.getUserNames().indexOf(username);
        if(DataBase.getUserPasswords().get(index).equals(password)){
            // بره توی منوی اصلی
        }
        else{
           passwordField.clear();
           wrongText.setVisible(true);
        }
    }
    @FXML
    protected void onSignUpClicked (MouseEvent e) throws IOException {
        // with node
    }

    @FXML
    protected void onForgetClicked (MouseEvent e) throws IOException {
        // with node
    }

    @FXML
    protected void onExitClicked (MouseEvent e) throws IOException {
        System.exit(0);
    }



}
