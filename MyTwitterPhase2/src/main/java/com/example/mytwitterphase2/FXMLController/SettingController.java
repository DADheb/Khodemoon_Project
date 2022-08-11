package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.UserController;
import com.example.mytwitterphase2.DataBase.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SettingController implements Initializable {

    private Image image;
    private ImageView imageView;
    @FXML
    private Pane mainPane;
    @FXML
    private ScrollPane mainScrollPane;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private GridPane mainGridPane;

    @FXML
    private Label titleSettingL;
    @FXML
    private Label cancelL;

    @FXML
    private Label themeL;
    @FXML
    private Label passL;
    @FXML
    private Label usernameL;
    @FXML
    private Label userNameErrorL;
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
    private Circle proPhoto;
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
    private DatePicker birthPicker;
    @FXML
    private RadioButton publicRadio;
    @FXML
    private RadioButton privateRadio;

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
    private Region leftR;
    @FXML
    private Region rightR;
    @FXML
    private Pane topPane;
    @FXML
    private Pane bottomPane;
    @FXML
    private Pane themePane;

    @FXML
    private VBox passBox;
    @FXML
    private Label titlePassL;
    @FXML
    private PasswordField oldPassField;
    @FXML
    private PasswordField newPassField;
    @FXML
    private PasswordField verifyField;
    @FXML
    private Button passDoneB;
    @FXML
    private Button passBackB;
    @FXML
    private HBox passHBox;
    @FXML
    private Region passHBoxRegion;

    @FXML
    private Button darkBlueB;
    @FXML
    private Button darkRedB;
    @FXML
    private Button lightBlueB;
    @FXML
    private Button lightRedB;

    private Color themeColor;
    private Color mode;

    final FileChooser fileChooser = new FileChooser();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.subScale);
    }

    public void initial(double scale) {
        theme();
        initialValues();

        //RESPONSIVE
        this.mainScrollPane.setPrefWidth(1000 * scale);
        this.mainBorderPane.setPrefWidth(1000 * scale);
        this.mainScrollPane.setPrefHeight(600 * scale);
        this.mainBorderPane.setPrefHeight(600 * scale);

        this.titleSettingL.setFont(Font.font(24D * scale));
        this.proL.setFont(Font.font(18D * scale));
        this.usernameL.setFont(Font.font(18D * scale));
        this.userNameErrorL.setFont(Font.font(18D * scale));
        this.passL.setFont(Font.font(18D * scale));
        this.nameL.setFont(Font.font(18D * scale));
        this.lastnameL.setFont(Font.font(18D * scale));
        this.bioL.setFont(Font.font(18D * scale));
        this.passL.setFont(Font.font(18D * scale));
        this.emailL.setFont(Font.font(18D * scale));
        this.birthL.setFont(Font.font(18D * scale));
        this.privacyL.setFont(Font.font(18D * scale));
        this.questionL.setFont(Font.font(18D * scale));
        this.cancelL.setFont(Font.font(16D * scale));
        this.themeL.setFont(Font.font(18D * scale));

        this.privateRadio.setFont(Font.font(18D * scale));
        this.publicRadio.setFont(Font.font(18D * scale));
        this.usernameField.setFont(Font.font(18D * scale));
        this.nameField.setFont(Font.font(18D * scale));
        this.lastNameField.setFont(Font.font(18D * scale));
        this.bioField.setFont(Font.font(18D * scale));
        this.emailField.setFont(Font.font(18D * scale));
        this.questionField.setFont(Font.font(18D * scale));

        this.birthPicker.setPrefWidth(425D * scale);
        this.birthPicker.setPrefHeight(35 * scale);

        this.titleSettingL.setLayoutX(446 * scale);
        this.titleSettingL.setPrefWidth(109 * scale);
        this.titleSettingL.setPrefHeight(25 * scale);

        this.usernameField.setPrefWidth(442D * scale);
        this.nameField.setPrefWidth(442D * scale);
        this.lastNameField.setPrefWidth(442D * scale);
        this.bioField.setPrefWidth(442D * scale);
        this.emailField.setPrefWidth(442D * scale);
        this.birthPicker.setPrefWidth(442D * scale);
        this.questionField.setPrefWidth(442D * scale);
        this.leftR.setPrefWidth(16D * scale);
        this.rightR.setPrefWidth(32D * scale);

//        this.topPane.setPrefWidth(1000D * scale);
//        this.bottomPane.setPrefWidth(1000D * scale);
        this.proPhoto.setRadius(20D * scale);


        this.usernameField.setPrefHeight(35D * scale);
        this.nameField.setPrefHeight(35D * scale);
        this.lastNameField.setPrefHeight(35D * scale);
        this.bioField.setPrefHeight(35D * scale);
        this.emailField.setPrefHeight(35D * scale);
        this.birthPicker.setPrefHeight(35D * scale);
        this.questionField.setPrefHeight(35D * scale);
        this.leftR.setPrefHeight(565D * scale);
        this.rightR.setPrefHeight(565D * scale);
        this.topPane.setPrefHeight(35D * scale);
        this.bottomPane.setPrefHeight(30D * scale);
        this.themePane.setPrefHeight(35D * scale);

        this.darkBlueB.setLayoutX(15 * scale);
        this.darkRedB.setLayoutX(174 * scale);
        this.lightBlueB.setLayoutX(324 * scale);
        this.darkBlueB.setLayoutY(10 * scale);
        this.darkRedB.setLayoutY(10 * scale);
        this.lightBlueB.setLayoutY(10 * scale);
        this.publicRadio.setLayoutX(76 * scale);
        this.publicRadio.setLayoutY(14 * scale);
        this.privateRadio.setLayoutX(273 * scale);
        this.privateRadio.setLayoutY(14 * scale);


        this.changeProB.setFont(Font.font(16D * scale));
        this.changeUsernameB.setFont(Font.font(16D * scale));
        this.changePassB.setFont(Font.font(16D * scale));
        this.changeNameB.setFont(Font.font(16D * scale));
        this.changeLastB.setFont(Font.font(16D * scale));
        this.changeBioB.setFont(Font.font(16D * scale));
        this.changeEmailB.setFont(Font.font(16D * scale));
        this.changeBirthB.setFont(Font.font(16D * scale));
        this.changeQuestionB.setFont(Font.font(16D * scale));
        this.changePrivacyB.setFont(Font.font(16D * scale));
        this.darkBlueB.setFont(Font.font(14D * scale));
        this.darkRedB.setFont(Font.font(14D * scale));
        this.lightBlueB.setFont(Font.font(14D * scale));
        this.lightRedB.setFont(Font.font(14D * scale));

        //THEME
        this.changeProB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.changeUsernameB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.changePassB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.changeNameB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.changeLastB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.changeBioB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.changeEmailB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.changeBirthB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.changeQuestionB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.changePrivacyB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));

        this.leftR.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));
        this.rightR.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));
        this.topPane.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));
        this.bottomPane.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));
        this.mainPane.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));

        this.proPhoto.setStroke(themeColor);

        this.proL.setTextFill(themeColor);
        this.usernameL.setTextFill(themeColor);
        this.passL.setTextFill(themeColor);
        this.nameL.setTextFill(themeColor);
        this.lastnameL.setTextFill(themeColor);
        this.bioL.setTextFill(themeColor);
        this.passL.setTextFill(themeColor);
        this.emailL.setTextFill(themeColor);
        this.birthL.setTextFill(themeColor);
        this.privacyL.setTextFill(themeColor);
        this.questionL.setTextFill(themeColor);
        this.publicRadio.setTextFill(themeColor);
        this.privateRadio.setTextFill(themeColor);
        this.themeL.setTextFill(themeColor);

        this.usernameField.setStyle("-fx-border-color: #" + themeColor.toString().substring(2));
        this.nameField.setStyle("-fx-border-color: #" + themeColor.toString().substring(2));
        this.lastNameField.setStyle("-fx-border-color: #" + themeColor.toString().substring(2));
        this.bioField.setStyle("-fx-border-color: #" + themeColor.toString().substring(2));
        this.emailField.setStyle("-fx-border-color: #" + themeColor.toString().substring(2));
        this.birthPicker.setStyle("-fx-border-color: #" + themeColor.toString().substring(2));
        this.questionField.setStyle("-fx-border-color: #" + themeColor.toString().substring(2));

        this.mainBorderPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.mainScrollPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.mainGridPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.themePane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
//        this.usernameField.setStyle("-fx-background-color: #" + mode.toString().substring(2));
//        this.nameField.setStyle("-fx-background-color: #" + mode.toString().substring(2));
//        this.lastNameField.setStyle("-fx-background-color: #" + mode.toString().substring(2));
//        this.bioField.setStyle("-fx-background-color: #" + mode.toString().substring(2));
//        this.emailField.setStyle("-fx-background-color: #" + mode.toString().substring(2));
//        this.birthPicker.setStyle("-fx-background-color: #" + mode.toString().substring(2));
//        this.questionField.setStyle("-fx-background-color: #" + mode.toString().substring(2));

        this.titleSettingL.setTextFill(mode);
        this.cancelL.setTextFill(mode);

        this.changeProB.setTextFill(mode);
        this.changeUsernameB.setTextFill(mode);
        this.changePassB.setTextFill(mode);
        this.changeNameB.setTextFill(mode);
        this.changeLastB.setTextFill(mode);
        this.changeBioB.setTextFill(mode);
        this.changeEmailB.setTextFill(mode);
        this.changeBirthB.setTextFill(mode);
        this.changeQuestionB.setTextFill(mode);
        this.changePrivacyB.setTextFill(mode);

    }

    public void initialValues() {
        this.image = DataBase.getUser().getProfileImage();
        this.proPhoto.setFill(new ImagePattern(image));
        this.usernameField.setText(DataBase.getUser().getUserName());
        this.nameField.setText(DataBase.getUser().getName());
        this.lastNameField.setText(DataBase.getUser().getLastName());
        this.bioField.setText(DataBase.getUser().getBio());
        this.emailField.setText(DataBase.getUser().getEmail());
        this.questionField.setText(DataBase.getUser().getSecurityQuestionsAnswers());
        String birthDay[] = DataBase.getUser().getBirthday().split("-");
        this.birthPicker.setValue(LocalDate.of(Integer.parseInt(birthDay[0]), Integer.parseInt(birthDay[1]), Integer.parseInt(birthDay[2])));
        if (DataBase.getUser().getPrivacy() == false) {
            this.publicRadio.setSelected(true);
            this.privateRadio.setSelected(false);
            System.out.println("publice");
        } else {
            this.privateRadio.setSelected(true);
            this.publicRadio.setSelected(false);
            System.out.println("privatee");
        }
    }

    public void passwordVBox() {
        showPasswordVBox(Creator.subScale);
    }

    public void showPasswordVBox(double scale) {
        this.mainScrollPane.setVisible(false);
        this.passBox.setVisible(true);
        this.passBox.setLayoutX(450 * scale);
        this.passBox.setLayoutY(150 * scale);

        this.passBox.setPrefWidth(140 * scale);
        this.passBox.setPrefHeight(200 * scale);
        this.titlePassL.setFont(Font.font(16D * scale));
        this.oldPassField.setFont(Font.font(16 * scale));
        this.oldPassField.setPrefWidth(140 * scale);
        this.newPassField.setFont(Font.font(16 * scale));
        this.newPassField.setPrefWidth(140 * scale);
        this.verifyField.setFont(Font.font(16 * scale));
        this.verifyField.setPrefWidth(140 * scale);
        this.passDoneB.setFont(Font.font(14D * scale));
        this.passBackB.setFont(Font.font(14D * scale));
        this.passHBox.setPrefWidth(140 * scale);
        this.passHBox.setPrefHeight(30 * scale);
        this.passHBoxRegion.setPrefWidth(12 * scale);
        this.passHBoxRegion.setPrefHeight(30 * scale);

        this.passDoneB.setTextFill(themeColor);
        this.passBackB.setTextFill(themeColor);
        this.passHBoxRegion.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));
        this.passHBox.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));

        this.passDoneB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + mode.toString().substring(2));
        this.passBackB.setStyle("-fx-background-radius: 15; -fx-background-color: #" + mode.toString().substring(2));

        this.titlePassL.setTextFill(mode);
    }

    public void changeUserName(ActionEvent event) {
        String newUsername = this.usernameField.getText();
        if (newUsername.length() == 0) {
            this.userNameErrorL.setVisible(true);
            this.userNameErrorL.setText("Enter New UserName");
        } else if (DataBase.getUserNames().contains(newUsername)) {
            this.userNameErrorL.setVisible(true);
            this.userNameErrorL.setText("UserName already exists");
        } else {
            this.userNameErrorL.setVisible(false);
            UserController.changeUserName(DataBase.getUser(), newUsername);
        }
    }

    public void changeName(ActionEvent event) {
        String newName = this.nameField.getText();
        UserController.changeName(DataBase.getUser(), newName);
    }

    public void changeLastname(ActionEvent event) {
        String newLastName = this.lastNameField.getText();
        UserController.changeLastName(DataBase.getUser(), newLastName);
    }

    public void changeBio(ActionEvent event) {
        String newBio = this.bioField.getText();
        UserController.changeBio(DataBase.getUser(), newBio);
    }

    public void changeEmail(ActionEvent event) {
        String newEmail = this.emailField.getText();
        UserController.changeEmail(DataBase.getUser(), newEmail);
    }

    public void changeBirth(ActionEvent event) {
        String newBirth = this.birthPicker.getValue().toString();
        UserController.changeBirthDay(DataBase.getUser(), newBirth);
    }

    public void changePrivacy(ActionEvent event) {
        if (this.publicRadio.isSelected()) {
            UserController.changePrivacy(DataBase.getUser(), false);
            System.out.println("public shod");
        } else if (this.privateRadio.isSelected()) {
            UserController.changePrivacy(DataBase.getUser(), true);
            System.out.println("Private shod");
        }
    }

    public void changeQuestion(ActionEvent event) {
        String newAnswer = this.questionField.getText();
        UserController.changeSecurityQuestionsAnswers(DataBase.getUser(), newAnswer);
    }

    public void quitSetting(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 7;
        DataBase.main.setMenuPane();
    }

    public void changePassword(ActionEvent event) throws IOException {
        String oldPassword = oldPassField.getText();
        String newPass = newPassField.getText();
        String verify = verifyField.getText();
        if (!oldPassword.equals(DataBase.getUser().getPassword())) {
            System.out.println("old error");
            this.titlePassL.setText("old password is incorrect");
            this.titlePassL.setTextFill(mode);
        } else {
            if (newPass.length() < 8) {
                this.titlePassL.setText("password is too short");
                this.titlePassL.setTextFill(mode);
            } else if (!newPass.matches("([a-zA-Z1-9])\\w+")) {
                this.titlePassL.setText("wrong characters are used");
                this.titlePassL.setTextFill(mode);
            } else if (newPass.equals(verify)) {
                this.titlePassL.setText("password changed");
                this.titlePassL.setTextFill(mode);
                UserController.changePassword(DataBase.getUser(), newPass);
                LiveState.state = 1 ;
                DataBase.main.showLogin();
            }
        }
    }

    public void quitChangePass(ActionEvent event) throws IOException {
        LiveState.state = 11;
        DataBase.main.showSetting();
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

    public void themeDarkBlue(ActionEvent event) {
        selectedTheme(this.darkBlueB);
        this.darkBlueB.setStyle("-fx-border-color: #ffff00; -fx-border-radius: 15; -fx-border-width: 2; -fx-background-color:  #78a1d1");
        DataBase.theme = 2;
        initial(Creator.subScale);
    }

    public void themeDarkRed(ActionEvent event) {
        selectedTheme(this.darkRedB);
        this.darkRedB.setStyle("-fx-border-color: #ffff00; -fx-border-radius: 15; -fx-border-width: 2; -fx-background-color:  #E179AD");
        DataBase.theme= 4;
        initial(Creator.subScale);
    }

    public void themeLightBlue(ActionEvent event) {
        selectedTheme(this.lightBlueB);
        this.lightBlueB.setStyle("-fx-border-color: #ffff00; -fx-border-radius: 15; -fx-border-width: 2; -fx-background-color:  #78a1d1");
        DataBase.theme = 1;
        initial(Creator.subScale);
    }

    public void themeLightRed(ActionEvent event) {
        selectedTheme(this.lightRedB);
        this.lightRedB.setStyle("-fx-border-color: #ffff00; -fx-border-radius: 15; -fx-border-width: 2; -fx-background-color:  #E179AD");
        DataBase.theme = 3;
        initial(Creator.subScale);
    }

    public void selectedTheme(Button button) {
        if (!this.darkRedB.equals(button)) {
            darkRedB.setStyle("-fx-background-color:   #E179AD; -fx-background-radius: 15");
        }
        if (!this.darkBlueB.equals(button)) {
            darkBlueB.setStyle("-fx-background-color:  #78a1d1; -fx-background-radius: 15");
        }
        if (!this.lightRedB.equals(button)) {
            lightRedB.setStyle("-fx-background-color:   #E179AD; -fx-background-radius: 15");
        }
        if (!this.lightBlueB.equals(button)) {
            lightBlueB.setStyle("-fx-background-color:   #78a1d1; -fx-background-radius: 15");
        }
    }

    public void changePro(ActionEvent event) {
        fileChooser.setTitle("choose profile photo");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            System.out.println("are");
            this.image = new Image(file.toURI().toString());
            DataBase.getUser().setProfileImage(this.image);
            this.proPhoto.setFill(new ImagePattern(image));
        } else {
            System.out.println("na");
        }
    }
}