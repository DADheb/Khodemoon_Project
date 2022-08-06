package com.example.demomytwitter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInDetailController implements Initializable {
    @FXML
    public ScrollPane mainPane;
    public AnchorPane anchorPane;
    public ImageView twitterImg;
    public TextField nameField;
    public TextField lastnameField;
    public TextField bioField;
    public TextField emailField;
    public Text completeText;
    public Text nameText;
    public Text doneText;
    public Text lastnameText;
    public Text birthdayText;
    public Text bioText;
    public Text gmailText;
    public Text typeText;
    public DatePicker birthdayPick;
    public RadioButton publicButton;
    public RadioButton privateButton;
    public Rectangle doneRect;
    public Circle doneCirc1;
    public Circle doneCirc2;
    public ToggleGroup accountType;
    public ImageView exitImg;

    String username, question, password, name, lastname, birthday, bio, email;
    Boolean type = true;
    private Double myScale = 1.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.scale);
        initialValues();
        this.username = Creator.setUsername;
        this.question = Creator.setQuestion;
        this.password = Creator.setPassword;
    }

    public void initial(double scale) {
        initialValues();
        myScale = scale;
        scale *= 1.5;
        this.mainPane.setPrefWidth(1000 * myScale);
        this.anchorPane.setPrefWidth(1000 * myScale);
        this.mainPane.setPrefHeight(600 * myScale);
        this.anchorPane.setPrefHeight(600 * myScale);
        this.twitterImg.setLayoutX(0d * scale);
        this.twitterImg.setLayoutY(0d * scale);
        this.twitterImg.setFitHeight(107d * scale);
        this.twitterImg.setFitWidth(119d * scale);

        this.nameText.setLayoutX (228d* scale);
        this.nameText.setLayoutY(88d * scale);
        this.nameText.setFont(Font.font(20D * scale));
        this.lastnameText.setLayoutX (222d* scale);
        this.lastnameText.setLayoutY(134d * scale);
        this.lastnameText.setFont(Font.font(20D * scale));
        this.birthdayText.setLayoutX (228d* scale);
        this.birthdayText.setLayoutY(182d * scale);
        this.birthdayText.setFont(Font.font(20D * scale));
        this.gmailText.setLayoutX (239d* scale);
        this.gmailText.setLayoutY(230d * scale);
        this.gmailText.setFont(Font.font(20D * scale));
        this.bioText.setLayoutX (221d* scale);
        this.bioText.setLayoutY(278d * scale);
        this.bioText.setFont(Font.font(20D * scale));
        this.typeText.setLayoutX (242d* scale);
        this.typeText.setLayoutY(324d * scale);
        this.typeText.setFont(Font.font(20D * scale));
        this.completeText.setLayoutX (155d* scale);
        this.completeText.setLayoutY(43d * scale);
        this.completeText.setFont(Font.font(30D * scale));
        this.doneText.setLayoutX (303d* scale);
        this.doneText.setLayoutY(273d * scale);
        this.doneText.setFont(Font.font(20D * scale));
        this.nameField.setPrefWidth(227d * scale);
        this.nameField.setPrefHeight(35d * scale);
        this.nameField.setFont(Font.font(20D * scale));
        this.nameField.setLayoutX(325d * scale);
        this.nameField.setLayoutY(60d * scale);
        this.lastnameField.setPrefWidth(227d * scale);
        this.lastnameField.setPrefHeight(35d * scale);
        this.lastnameField.setFont(Font.font(20D * scale));
        this.lastnameField.setLayoutX(325d * scale);
        this.lastnameField.setLayoutY(107d * scale);
        this.emailField.setPrefWidth(227d * scale);
        this.emailField.setPrefHeight(35d * scale);
        this.emailField.setFont(Font.font(20D * scale));
        this.emailField.setLayoutX(325d * scale);
        this.emailField.setLayoutY(203d * scale);
        this.bioField.setPrefWidth(227d * scale);
        this.bioField.setPrefHeight(35d * scale);
        this.bioField.setFont(Font.font(20D * scale));
        this.bioField.setLayoutX(325d * scale);
        this.bioField.setLayoutY(251d * scale);
        this.birthdayPick.setPrefWidth(227d * scale);
        this.birthdayPick.setPrefHeight(40d * scale);
        this.birthdayPick.setLayoutX(325d * scale);
        this.birthdayPick.setLayoutY(155d * scale);
        this.publicButton.setLayoutX(330d * scale);
        this.publicButton.setLayoutY(296d * scale);
        this.publicButton.setPrefWidth(90d * scale);
        this.publicButton.setPrefHeight(40d * scale);
        this.publicButton.setFont(Font.font(16D * scale));
        this.privateButton.setFont(Font.font(16D * scale));
        this.privateButton.setLayoutX(439d * scale);
        this.privateButton.setLayoutY(296d * scale);
        this.privateButton.setPrefWidth(90d * scale);
        this.privateButton.setPrefHeight(40d * scale);
        this.doneCirc1.setLayoutX(229d * scale);
        this.doneCirc1.setLayoutY(366d * scale);
        this.doneCirc1.setRadius(20d * scale);
        this.doneCirc2.setLayoutX(419d * scale);
        this.doneCirc2.setLayoutY(366d * scale);
        this.doneCirc2.setRadius(20d * scale);
        this.doneRect.setLayoutX(229d * scale);
        this.doneRect.setLayoutY(346d * scale);
        this.doneRect.setHeight(40d * scale);
        this.doneRect.setWidth(193d * scale);
        this.doneText.setFont(Font.font(20D * scale));
        this.doneText.setLayoutX(303d * scale);
        this.doneText.setLayoutY(373d * scale);
        this.exitImg.setLayoutX(0d * scale);
        this.exitImg.setLayoutY(343d * scale);
        this.exitImg.setFitHeight(54d * scale);
        this.exitImg.setFitWidth(51d * scale);
        Creator.scale = myScale;
    }

    public void initialValues() {
        publicButton.setSelected(true);
    }

    @FXML
    protected void onDoneClicked (MouseEvent e) throws IOException {
        birthday = "";
        name = nameField.getText();
        lastname = lastnameField.getText();
        if(birthdayPick.getValue() != null)
            birthday = birthdayPick.getValue().toString();
        email = emailField.getText();
        bio = bioField.getText();
        if(privateButton.isSelected()){
            type = false;
            System.out.println(1);
        }
        else {
            type = true;
            ControllerManager.newUser(username, password, type, name, lastname, bio, question, birthday, email);
            // وارد اکانت شود*/
        }

    }

    @FXML
    protected void onExitClicked (MouseEvent e) throws IOException {
        System.exit(0);
    }

}
