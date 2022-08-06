package com.example.demotwitterpost;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewPostsController implements Initializable {
    @FXML
    private ScrollPane mainPane;
    public VBox myBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            this.myBox.setPrefHeight(myBox.getPrefHeight() + 420 * Creator.scale);
            this.myBox.getChildren().add((Pane) addPost(Creator.post.getPostType()));
            for (int i = 0; i < Creator.post.getComments().size(); i++) {
                this.myBox.setPrefHeight(myBox.getPrefHeight() + 420 * Creator.scale);
                this.myBox.getChildren().add((Pane) addComment (Creator.post.getComments().get(i)));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Node addPost(int No) throws IOException {
        Node node;
        if(No == 1) {
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
        //پست استاتیک رو جدید ساختم تو کریتور واسه همین دیگه اون fill هارو تغییر ندادم :))
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
