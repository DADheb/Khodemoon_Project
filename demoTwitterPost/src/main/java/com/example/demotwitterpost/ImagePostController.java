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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ImagePostController implements Initializable {
    @FXML
    private ScrollPane mainPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Circle profilePic;
    @FXML
    private Label usernameLabel;
    @FXML
    private Rectangle mainImg;
    @FXML
    private ImageView likeImg;
    @FXML
    private ImageView unLikeImg;
    @FXML
    private ImageView commentImg;
    @FXML
    private ImageView moreImg;
    @FXML
    private ImageView hello;
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
    private Image postImage;
    private Post post;
    private Double scale;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.scale);
        fillPost(Creator.post, Creator.scale);
    }

    public void initial(double scale) {
        theme();

        this.mainPane.setPrefWidth(600 * scale);
        this.mainPane.setPrefHeight(450 * scale);
        this.anchorPane.setPrefWidth(600 * scale);
        this.anchorPane.setPrefHeight(450 * scale);
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
        this.commentNo.setLayoutY(388d * scale);
        this.commentNo.setFont(Font.font(20D * scale));

        this.viewText.setFill(themeColor);
        this.viewText.setLayoutX (433d* scale);
        this.viewText.setLayoutY(389d * scale);
        this.viewText.setFont(Font.font(20D * scale));

        this.hello.setLayoutX(0d * scale);
        this.hello.setLayoutY(89d * scale);
        this.hello.setFitWidth(600d * scale);
        this.hello.setFitHeight(262d * scale);

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
    }

    public void fillPost(Post post, Double scale) {
        String url = post.getText();
        int liked = 0;
        this.post = post;
        this.scale = scale;
        this.image = post.getUser().getProfileImage();
        usernameLabel.setText(post.getUser().getUserName());
        this.postImage = new Image(new File(url).toURI().toString());
        this.hello.setImage(postImage);
        likeNo.setText(String.valueOf(post.getLikes().size()));
        commentNo.setText(String.valueOf(post.getComments().size()));
        this.profilePic.setFill(new ImagePattern(image));
        for (int i = 0; i < post.getLikes().size(); i++) {
            if(post.getLikes().get(i).getUser() == DataBase.getUser())
                liked = 1;
        }
        if(liked == 0)
            likeImg.setVisible(false);
        else
            unLikeImg.setVisible(false);
        if(post.getUser().equals(DataBase.getUser()))
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
        Creator.setPost(post);
        // برگرده به صفحه یوزر!
    }
    @FXML
    protected void onMoreClicked (MouseEvent e) throws IOException {
        Creator.setPost(post);
        // if false == public account..
        if(!post.getUser().getPrivacy()) {
            // with node  morePublicUser
        }
        else{
            // with node morePrivateUser
        }
    }
    @FXML
    protected void onLikeClicked (MouseEvent e) throws IOException {
        likeImg.setVisible(true);
        unLikeImg.setVisible(false);
        Creator.setPost(post);
        ControllerManager.likeP(DataBase.getUser(), post);
    }
    @FXML
    protected void onUnlikeClicked (MouseEvent e) throws IOException {
        likeImg.setVisible(false);
        unLikeImg.setVisible(true);
        Creator.setPost(post);
        ControllerManager.dislikeP(DataBase.getUser(), post);
    }
    @FXML
    protected void onCommentClicked (MouseEvent e) throws IOException {
        Creator.setPost(post);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateComment.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("New Comment");
        stage.setScene(new Scene(root1));
        stage.show();
        // استثنا قرار شد تب جدید باشه!
    }
    @FXML
    protected void onViewClicked (MouseEvent e) throws IOException {
        Creator.setPost(post);
    }
}
