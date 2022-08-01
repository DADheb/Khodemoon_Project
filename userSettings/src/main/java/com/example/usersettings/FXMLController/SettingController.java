package com.example.usersettings.FXMLController;

import com.example.usersettings.DataBase.DataBase;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SettingController implements Initializable {

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private GridPane mainGridPane;
    @FXML
    private Label cancelL;
    @FXML
    private Label settingTitle;
    @FXML
    private Label passL;
    @FXML
    private Label usernameL;
    @FXML
    private Label nameL;
    @FXML
    private Label lastnameL;
    @FXML
    private Label bioL;
    @FXML
    private Label birthL;
    @FXML
    private Label privacyL;
    @FXML
    private Label questionL;
    @FXML
    private Label emailL;
    @FXML
    private Label proL;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField bioField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField questionField;
    @FXML
    private ChoiceBox<String> privacyChoice;
    private String[] privacyChoiceItems = {"Public", "Private"};
    @FXML
    private DatePicker birthPicker;
    @FXML
    private Region leftRegion;
    @FXML
    private Region rightRegion;
    @FXML
    private Button changeUsernameB;
    @FXML
    private Button changePassB;
    @FXML
    private Button changeNameB;
    @FXML
    private Button changeLastB;
    @FXML
    private Button changeBioB;
    @FXML
    private Button changeEmailB;
    @FXML
    private Button changeBirthB;
    @FXML
    private Button changePrivacyB;
    @FXML
    private Button changeQuestionB;
    @FXML
    private Button changeProB;
    @FXML
    private Circle proPhoto;

    private double widthScale = 1;
    private double heightScale = 1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.mainBorderPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                SettingController.this.mainBorderPane.setPrefWidth(t1.doubleValue());
                SettingController.this.widthScale = mainBorderPane.getPrefWidth() / 600;
            }
        });
        this.mainBorderPane.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                SettingController.this.mainGridPane.setPrefHeight(t1.doubleValue());
                SettingController.this.widthScale = mainGridPane.getPrefHeight() / 400;
            }
        });
        initial();
    }

    public void initial() {
        // x , y moondeh
        //initialValues();
        double scale = widthScale * heightScale;
        this.settingTitle.setFont(Font.font(17D * scale));
        this.usernameL.setFont(Font.font(14D * scale));
        this.passL.setFont(Font.font(14D * scale));
        this.nameL.setFont(Font.font(14D * scale));
        this.lastnameL.setFont(Font.font(14D * scale));
        this.proL.setFont(Font.font(14D * scale));
        this.bioL.setFont(Font.font(14D * scale));
        this.passL.setFont(Font.font(14D * scale));
        this.emailL.setFont(Font.font(14D * scale));
        this.birthL.setFont(Font.font(14D * scale));
        this.privacyL.setFont(Font.font(14D * scale));
        this.questionL.setFont(Font.font(14D * scale));
        this.cancelL.setFont(Font.font(13D * scale));

        this.usernameField.setFont(Font.font(14D * scale));
        this.passField.setFont(Font.font(14D * scale));
        this.nameField.setFont(Font.font(14D * scale));
        this.lastNameField.setFont(Font.font(14D * scale));
        this.bioField.setFont(Font.font(14D * scale));
        this.emailField.setFont(Font.font(14D * scale));
        this.questionField.setFont(Font.font(14D * scale));

        this.usernameField.setPrefWidth(260D * widthScale);
        this.passField.setPrefWidth(260D * widthScale);
        this.nameField.setPrefWidth(260D * widthScale);
        this.lastNameField.setPrefWidth(260D * widthScale);
        this.bioField.setPrefWidth(260D * widthScale);
        this.emailField.setPrefWidth(260D * widthScale);
        this.birthPicker.setPrefWidth(260D * widthScale);
        this.privacyChoice.setPrefWidth(260D * widthScale);
        this.questionField.setPrefWidth(260D * widthScale);
        this.questionField.setPrefWidth(260D * widthScale);

        this.usernameField.setPrefHeight(25D * heightScale);
        this.passField.setPrefHeight(25D * heightScale);
        this.nameField.setPrefHeight(25D * heightScale);
        this.lastNameField.setPrefHeight(25D * heightScale);
        this.bioField.setPrefHeight(25D * heightScale);
        this.emailField.setPrefHeight(25D * heightScale);
        this.birthPicker.setPrefHeight(25D * heightScale);
        this.privacyChoice.setPrefHeight(25D * heightScale);
        this.questionField.setPrefHeight(25D * heightScale);

        this.changeProB.setFont(Font.font(13D * scale));
        this.changeUsernameB.setFont(Font.font(13D * scale));
        this.changePassB.setFont(Font.font(13D * scale));
        this.changeNameB.setFont(Font.font(13D * scale));
        this.changeLastB.setFont(Font.font(13D * scale));
        this.changeBioB.setFont(Font.font(13D * scale));
        this.changeEmailB.setFont(Font.font(13D * scale));
        this.changeBirthB.setFont(Font.font(13D * scale));
        this.changeQuestionB.setFont(Font.font(13D * scale));
        this.changePrivacyB.setFont(Font.font(13D * scale));


    }

    public void initialValues() {
        //this.usernameField.setText(DataBase.getUser().getUserName());
//        this.passField.setText(DataBase.getUser().getPassword());
//        this.nameField.setText(DataBase.getUser().getName());
//        this.usernameField.setText(DataBase.getUser().getUserName());
    }
}
