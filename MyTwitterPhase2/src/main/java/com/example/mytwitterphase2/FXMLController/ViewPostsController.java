package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.FXMLController.Objects.ImagePostController;
import com.example.mytwitterphase2.FXMLController.Objects.TextCommentController;
import com.example.mytwitterphase2.FXMLController.Objects.TextPostController;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Comment;
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
            this.myBox.setPrefHeight(myBox.getPrefHeight() + 420 * Creator.mainScale);
            this.myBox.getChildren().add((Pane) addPost(Creator.post.getPostType()));
            for (int i = 0; i < Creator.post.getComments().size(); i++) {
                this.myBox.setPrefHeight(myBox.getPrefHeight() + 420 * Creator.mainScale);
                this.myBox.getChildren().add((Pane) addComment (Creator.post.getComments().get(i)));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Node addPost(int No) throws IOException {
        Node node;
        if(No == 1) {
            FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ImagePost.fxml"));
            node = fxmlLoader.load();
            return node;
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/TextPost.fxml"));
            node = fxmlLoader.load();
            return node;
        }
        //پست استاتیک رو جدید ساختم تو کریتور واسه همین دیگه اون fill هارو تغییر ندادم :))
    }

    public Node addComment(Comment comment) throws IOException {
        Creator.comment = comment;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/TextComment.fxml"));
        node = fxmlLoader.load();
        return node;
    }
}
