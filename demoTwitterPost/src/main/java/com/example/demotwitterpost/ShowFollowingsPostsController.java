package com.example.demotwitterpost;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class ShowFollowingsPostsController implements Initializable {
    @FXML
    private ScrollPane mainPane;
    public VBox myBox;

    private Color themeColor;
    private Color mode;
    private Color opposite;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.scale);
        try{
            this.myBox.setPrefHeight(myBox.getPrefHeight() + 420 * Creator.scale);
            this.myBox.getChildren().add((Pane) addPost(Creator.post));
            Collections.sort(Creator.post.getComments());
                for (int j = 0; j < Creator.post.getComments().size(); j++) {
                    this.myBox.setPrefHeight(myBox.getPrefHeight() + 420 * Creator.scale);
                    this.myBox.getChildren().add((Pane) addComment (Creator.post.getComments().get(j)));
                }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initial(double scale) {
        theme();
        this.mainPane.setPrefWidth(600 * scale);
        this.mainPane.setPrefHeight(600 * scale);
        this.myBox.setPrefWidth(600 * scale);
        this.myBox.setPrefHeight(600 * scale);
        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.myBox.setStyle("-fx-background-color: #" + mode.toString().substring(2));
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
