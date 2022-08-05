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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowUsersPostsController implements Initializable {

    @FXML
    private ScrollPane mainPane;
    public VBox myBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            int t = DataBase.getUser().getPosts().size() - 1;
            for (int i = t; i >= 0; i--) {
                this.myBox.getChildren().add((Pane) addPost(DataBase.getUser().getPosts().get(i)));
                for (int j = 0; j < DataBase.getUser().getPosts().get(i).getComments().size(); j++) {
                    this.myBox.getChildren().add((Pane) addComment (DataBase.getUser().getPosts().get(i).getComments().get(j)));
                }
                // شاید بهتر باشه که نشون ندیمش!
            }
        } catch (IOException e){
            e.printStackTrace();
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
