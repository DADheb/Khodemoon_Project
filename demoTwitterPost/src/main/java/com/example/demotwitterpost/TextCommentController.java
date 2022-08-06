package com.example.demotwitterpost;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TextCommentController implements Initializable {
    @FXML
    private ScrollPane mainPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Circle profilePic;
    @FXML
    private Label usernameLabel;
    @FXML
    private TextArea textArea;
    @FXML
    private ImageView likeImg;
    @FXML
    private ImageView unLikeImg;
    @FXML
    private ImageView commentImg;
    @FXML
    private ImageView moreImg;
    @FXML
    private Text likeNo;
    @FXML
    private Text commentNo;
    @FXML
    private Text viewText;

    private Color themeColor;
    private Color mode;
    private Color opposite;
    private Image image;
    private Comment comment;
    private Double scale = 1.0;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.scale);
        //fillComment(Creator.comment, Creator.scale);
        if(DataBase.getTheme() == 1) {
            this.textArea.setStyle("-fx-control-inner-background:White; -fx-font-family: Consolas; -fx-highlight-fill: #78a1d1; -fx-highlight-text-fill: #78a1d1; -fx-text-fill: #78a1d1; ");
        }
        if(DataBase.getTheme() == 2){
            this.textArea.setStyle("-fx-control-inner-background:Black; -fx-font-family: Consolas; -fx-highlight-fill: #78a1d1; -fx-highlight-text-fill: #78a1d1; -fx-text-fill: #78a1d1; ");
        }
    }

    public void initial(double scale) {
        theme();
        this.mainPane.setPrefWidth(600 * scale);
        this.anchorPane.setPrefWidth(600 * scale);
        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.anchorPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));

        this.usernameLabel.setTextFill(themeColor);
        this.usernameLabel.setLayoutX (92d* scale);
        this.usernameLabel.setLayoutY(33d * scale);
        this.usernameLabel.setFont(Font.font(20D * scale));

        this.likeNo.setFill(themeColor);
        this.likeNo.setLayoutX (78d* scale);
        this.likeNo.setLayoutY(390d * scale);
        this.likeNo.setFont(Font.font(20D * scale));

        this.commentNo.setFill(themeColor);
        this.commentNo.setLayoutX (181d* scale);
        this.commentNo.setLayoutY(390d * scale);
        this.commentNo.setFont(Font.font(20D * scale));

        this.viewText.setFill(themeColor);
        this.viewText.setLayoutX (433d* scale);
        this.viewText.setLayoutY(389d * scale);
        this.viewText.setFont(Font.font(20D * scale));

        this.moreImg.setLayoutX(521d * scale);
        this.moreImg.setLayoutY(21d * scale);
        this.moreImg.setFitHeight(40d * scale);
        this.moreImg.setFitWidth(40d * scale);

        this.likeImg.setLayoutX(25d * scale);
        this.likeImg.setLayoutY(358d * scale);
        this.likeImg.setFitHeight(50d * scale);
        this.likeImg.setFitWidth(50d * scale);

        this.unLikeImg.setLayoutX(25d * scale);
        this.unLikeImg.setLayoutY(358d * scale);
        this.unLikeImg.setFitHeight(50d * scale);
        this.unLikeImg.setFitWidth(50d * scale);

        this.commentImg.setLayoutX(131d * scale);
        this.commentImg.setLayoutY(358d * scale);
        this.commentImg.setFitHeight(50d * scale);
        this.commentImg.setFitWidth(50d * scale);

        this.profilePic.setLayoutX(44d * scale);
        this.profilePic.setLayoutY(44d * scale);
        this.profilePic.setRadius(34d * scale);

        if(DataBase.getTheme() > 2) {
            this.textArea.setStyle("-fx-control-inner-background: #" + mode.toString().substring(2) + ";-fx-font-family: Consolas; -fx-highlight-fill:" + themeColor.toString().substring(2) + ";-fx-highlight-fill:" + themeColor.toString().substring(2) + "; -fx-text-fill:" + themeColor.toString().substring(2));
        }
        this.textArea.setPrefWidth(600d * scale);
        this.textArea.setPrefHeight(261d * scale);
        this.textArea.setFont(Font.font(20D * scale));
        this.textArea.setLayoutX(0d * scale);
        this.textArea.setLayoutY(87d * scale);
    }

    public void fillComment(Comment comment, Double scale) {
        int liked = 0;
        this.comment = comment;
        this.scale = scale;
        this.image = comment.getUser().getProfileImage();
        textArea.setText(comment.getText());
        usernameLabel.setText(comment.getUser().getUserName());
        likeNo.setText(String.valueOf(comment.getLikes().size()));
        commentNo.setText(String.valueOf(comment.getComments().size()));
        this.profilePic.setFill(new ImagePattern(image));
        for (int i = 0; i < comment.getLikes().size(); i++) {
            if(comment.getLikes().get(i).getUser() == DataBase.getUser())
                liked = 1;
        }
        if(liked == 0)
            likeImg.setVisible(false);
        else
            unLikeImg.setVisible(false);
        if(comment.getUser().equals(DataBase.getUser()))
            moreImg.setVisible(true);
        else
            moreImg.setVisible(false);
    }

    public void theme() {
        switch (DataBase.getTheme()) {
            case 1:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.WHITE;
                this.opposite = Color.BLACK;
                break;
            case 2:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.BLACK;
                this.opposite = Color.WHITE;
                break;
            case 3:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.WHITE;
                this.opposite = Color.BLACK;
                break;
            case 4:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.BLACK;
                this.opposite = Color.WHITE;
                break;
        }
    }

    @FXML
    protected void onUsernameClicked (MouseEvent e) throws IOException {
        Creator.setComment(comment);
        // برگرده به صفحه یوزر!
    }
    @FXML
    protected void onMoreClicked (MouseEvent e) throws IOException {
        Creator.setComment(comment);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MoreComment.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("New Comment");
        stage.setScene(new Scene(root1));
        stage.show();
    }
    @FXML
    protected void onLikeClicked (MouseEvent e) throws IOException {
        Creator.setComment(comment);
        likeImg.setVisible(true);
        unLikeImg.setVisible(false);
        //ControllerManager.likeC(DataBase.getUser(), comment);
    }
    @FXML
    protected void onUnlikeClicked (MouseEvent e) throws IOException {
        Creator.setComment(comment);
        likeImg.setVisible(false);
        unLikeImg.setVisible(true);
        //ControllerManager.dislikeC(DataBase.getUser(), comment);
    }
    @FXML
    protected void onCommentClicked (MouseEvent e) throws IOException {
        Creator.setComment(comment);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateComment.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("New Comment");
        stage.setScene(new Scene(root1));
        stage.show();
    }
    @FXML
    protected void onViewClicked (MouseEvent e) throws IOException {
        Creator.setComment(comment);
        // برگرده به صفحه نمایش کامنت!
    }

}
