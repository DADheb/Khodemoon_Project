package com.example.demotwitterpost;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class ShowFollowingsPostsController implements Initializable {
    @FXML
    private ScrollPane mainPane;
    @FXML
    private AnchorPane anchorPane;
    public VBox myVBox;
    @FXML
    private Text seeText;
    @FXML
    private Button backButton;

    private Color themeColor;
    private Color mode;
    private Color opposite;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.scale);
        try{
            this.myVBox.setPrefHeight(myVBox.getPrefHeight() + 420 * Creator.scale);
            this.anchorPane.setPrefHeight(anchorPane.getPrefHeight() + 420 * Creator.scale);
            this.myVBox.getChildren().add((Pane) addPost(Creator.post));
            Collections.sort(Creator.post.getComments());
            for (int i = 0; i < Creator.post.getComments().size(); i++) {
                this.myVBox.setPrefHeight(myVBox.getPrefHeight() + 420 * Creator.scale);
                this.anchorPane.setPrefHeight(anchorPane.getPrefHeight() + 420 * Creator.scale);
                this.myVBox.getChildren().add((Pane) addComment (Creator.post.getComments().get(i)));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initial(double scale) {
        theme();
        myVBox.setPrefHeight(0.0);
        anchorPane.setPrefHeight(59.0 * scale);
        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.anchorPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.mainPane.setPrefWidth(600 * scale);
        this.anchorPane.setPrefWidth(600 * scale);
        this.mainPane.setPrefHeight(450 * scale);
        this.anchorPane.setPrefHeight(450 * scale);;
        this.myVBox.setPrefWidth(600 * scale);
        this.myVBox.setPrefHeight(600 * scale);
        this.myVBox.setStyle("-fx-background-color: #" + mode.toString().substring(2));

        this.seeText.setFill(themeColor);
        this.seeText.setFont(Font.font(30D * scale));
        this.seeText.setLayoutX (81d* scale);
        this.seeText.setLayoutY(45d * scale);

        this.backButton.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.backButton.setTextFill(mode);
        this.backButton.setFont(Font.font(20D * scale));
        this.backButton.setLayoutX (469d* scale);
        this.backButton.setLayoutY(14d * scale);
        this.backButton.setPrefWidth(91d * scale);
        this.backButton.setPrefHeight(40d * scale);


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
    protected void onBackClicked (ActionEvent e) throws IOException {
        //todo برگرده عقب
    }

    public Node addPost(Post post) throws IOException {
        Node node;
        if(post.getPostType() != 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ImagePost.fxml"));
            ImagePostController imagePostController = fxmlLoader.getController();
            imagePostController.fillPost(Creator.post, Creator.scale);
            node = fxmlLoader.load();
            return node;
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TextPost.fxml"));
            TextPostController textPostController = fxmlLoader.getController();
            textPostController.fillPost(Creator.post, Creator.scale);
            node = fxmlLoader.load();
            return node;
        }
    }

    public Node addComment(Comment comment) throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TextComment.fxml"));
        TextCommentController textCommentController = fxmlLoader.getController();
        textCommentController.fillComment(comment, Creator.scale);
        node = fxmlLoader.load();
        return node;
    }
}
