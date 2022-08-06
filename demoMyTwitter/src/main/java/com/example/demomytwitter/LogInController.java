package com.example.demomytwitter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initialValues();
        this.mainPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                initial(mainPane.widthProperty().doubleValue() / 600);
            }
        });
    }

    public void initial(double scale) {
        this.mainPane.setPrefWidth(600 * scale);
        this.anchorPane.setPrefWidth(600 * scale);
        this.usernameField.setPrefWidth(227d * scale);
        this.usernameField.setPrefHeight(35d * scale);
        this.usernameField.setFont(Font.font(16D * scale));
        this.usernameField.setLayoutX(190d * scale);
        this.usernameField.setLayoutY(141d * scale);
        this.signInText.setLayoutX (188d* scale);
        this.signInText.setLayoutY(131d * scale);
        this.signInText.setFont(Font.font(25D * scale));
        this.notFound.setLayoutX(182d * scale);
        this.notFound.setLayoutY(214d * scale);
        this.notFound.setFont(Font.font(12D * scale));
        this.nextCirc1.setLayoutX(391d * scale);
        this.nextCirc1.setLayoutY(255d * scale);
        this.nextCirc1.setRadius(19d * scale);
        this.nextCirc2.setLayoutX(199d * scale);
        this.nextCirc2.setLayoutY(255d * scale);
        this.nextCirc2.setRadius(19d * scale);
        this.nextRect.setLayoutX(198d * scale);
        this.nextRect.setLayoutY(236d * scale);
        this.nextRect.setHeight(38d * scale);
        this.nextRect.setWidth(193d * scale);
        this.nextText.setFont(Font.font(20D * scale));
        this.nextText.setLayoutX(275d * scale);
        this.nextText.setLayoutY(262d * scale);
        this.forgetCirc1.setLayoutX(391d * scale);
        this.forgetCirc1.setLayoutY(308d * scale);
        this.forgetCirc1.setRadius(19d * scale);
        this.forgetCirc2.setLayoutX(198d * scale);
        this.forgetCirc2.setLayoutY(308d * scale);
        this.forgetCirc2.setRadius(19d * scale);
        this.forgetRect.setLayoutX(198d * scale);
        this.forgetRect.setLayoutY(290d * scale);
        this.forgetRect.setHeight(38d * scale);
        this.forgetRect.setWidth(193d * scale);
        this.forgetText.setFont(Font.font(20D * scale));
        this.forgetText.setLayoutX(225d * scale);
        this.forgetText.setLayoutY(316d * scale);
        this.accountText.setFont(Font.font(16D * scale));
        this.accountText.setLayoutX(183d * scale);
        this.accountText.setLayoutY(366d * scale);
        this.signUpText.setFont(Font.font(16D * scale));
        this.signUpText.setLayoutX(348d * scale);
        this.signUpText.setLayoutY(366d * scale);
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
        notFound.setVisible(false);
    }
    @FXML
    public void onNextClicked (MouseEvent e) throws IOException{
        String username = usernameField.getText();

        if(!username.isEmpty()){
//            if (!DataBase.getUserNames().contains(username)){
//                // DataBase.getUserNames().indexOf(username) یا این !
//                notFound.setDisable(true);
//                usernameField.clear();
//            }
//            else{
//                Parent root;
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
//                root = loader.load();
//                SignInController signInController = loader.getController();
//                signInController.fillUsername (username);
//                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//                scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//            }
        }
    }
    @FXML
    public void onForgetClicked(MouseEvent e) throws IOException{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("ForgetPassword.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onSignUpClicked (MouseEvent e) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onExitClicked (MouseEvent e) throws IOException {
        System.exit(0);
    }

}
