package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import java.sql.SQLException;
import java.util.ResourceBundle;


public class LogInController implements Initializable {
    @FXML
    public ScrollPane mainPane;
    public AnchorPane anchorPane;
    public Text signInText;
    public TextField usernameField;
    public Text notFound;
    public Text nextText;
    public Text accountText;
    public Text signUpText;
    public Rectangle nextRect;
    public Rectangle forgetRect;
    public Text forgetText;
    public Circle nextCirc1;
    public Circle nextCirc2;
    public Circle forgetCirc1;
    public Circle forgetCirc2;
    public ImageView twitterImg;
    public ImageView exitImg;

    @FXML
    private Scene scene;
    private Stage stage;
    private Double myScale = 1.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initialValues();
        initial(Creator.subScale);
    }

    public void initial(double scale) {
        myScale = scale;
        scale *= 1.5;
        this.mainPane.setPrefWidth(1000 * myScale);
        this.anchorPane.setPrefWidth(1000 * myScale);
        this.mainPane.setPrefHeight(600 * myScale);
        this.anchorPane.setPrefHeight(600 * myScale);
        this.usernameField.setPrefWidth(227d * scale);
        this.usernameField.setPrefHeight(35d * scale);
        this.usernameField.setFont(Font.font(16D * scale));
        this.usernameField.setLayoutX(221d * scale);
        this.usernameField.setLayoutY(141d * scale);
        this.signInText.setLayoutX (228d* scale);
        this.signInText.setLayoutY(131d * scale);
        this.signInText.setFont(Font.font(25D * scale));
        this.notFound.setLayoutX(222d * scale);
        this.notFound.setLayoutY(214d * scale);
        this.notFound.setFont(Font.font(12D * scale));
        this.nextCirc1.setLayoutX(431d * scale);
        this.nextCirc1.setLayoutY(255d * scale);
        this.nextCirc1.setRadius(19d * scale);
        this.nextCirc2.setLayoutX(239d * scale);
        this.nextCirc2.setLayoutY(255d * scale);
        this.nextCirc2.setRadius(19d * scale);
        this.nextRect.setLayoutX(238d * scale);
        this.nextRect.setLayoutY(236d * scale);
        this.nextRect.setHeight(38d * scale);
        this.nextRect.setWidth(193d * scale);
        this.nextText.setFont(Font.font(20D * scale));
        this.nextText.setLayoutX(315d * scale);
        this.nextText.setLayoutY(262d * scale);
        this.forgetCirc1.setLayoutX(431d * scale);
        this.forgetCirc1.setLayoutY(308d * scale);
        this.forgetCirc1.setRadius(19d * scale);
        this.forgetCirc2.setLayoutX(238d * scale);
        this.forgetCirc2.setLayoutY(308d * scale);
        this.forgetCirc2.setRadius(19d * scale);
        this.forgetRect.setLayoutX(238d * scale);
        this.forgetRect.setLayoutY(290d * scale);
        this.forgetRect.setHeight(38d * scale);
        this.forgetRect.setWidth(193d * scale);
        this.forgetText.setFont(Font.font(20D * scale));
        this.forgetText.setLayoutX(265d * scale);
        this.forgetText.setLayoutY(316d * scale);
        this.accountText.setFont(Font.font(16D * scale));
        this.accountText.setLayoutX(223d * scale);
        this.accountText.setLayoutY(366d * scale);
        this.signUpText.setFont(Font.font(16D * scale));
        this.signUpText.setLayoutX(388d * scale);
        this.signUpText.setLayoutY(366d * scale);
        this.twitterImg.setLayoutX(292d * scale);
        this.twitterImg.setLayoutY(0d * scale);
        this.twitterImg.setFitHeight(107d * scale);
        this.twitterImg.setFitWidth(119d * scale);
        this.exitImg.setLayoutX(0d * scale);
        this.exitImg.setLayoutY(1d * scale);
        this.exitImg.setFitHeight(54d * scale);
        this.exitImg.setFitWidth(51d * scale);
        Creator.subScale = myScale;

    }

    public void initialValues() {
        notFound.setVisible(false);
    }
    @FXML
    public void onNextClicked (MouseEvent e) throws IOException{
        String username = usernameField.getText();
        Creator.setUsername = username;

        if(!username.isEmpty()){
            if (!DataBase.getUserNames().contains(username)){
                // DataBase.getUserNames().indexOf(username) یا این !
                notFound.setDisable(true);
                usernameField.clear();
            }
            else{
                LiveState.state = 2;
                DataBase.main.showSignIn();
            }
        }
    }
    @FXML
    public void onForgetClicked(MouseEvent e) throws IOException{
        LiveState.state = 3;
        DataBase.main.showForgetPassword();
    }
    @FXML
    public void onSignUpClicked (MouseEvent e) throws IOException {
        LiveState.state = 4;
        DataBase.main.showSignUp();
    }

    @FXML
    protected void onExitClicked (MouseEvent e) throws IOException, SQLException {
        LiveState.state = 0;
        DataBase.main.exit();
    }

}
