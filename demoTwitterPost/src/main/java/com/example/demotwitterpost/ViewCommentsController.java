package com.example.demotwitterpost;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewCommentsController implements Initializable {
    @FXML
    private ScrollPane mainPane;
    public VBox myVBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            this.myVBox.getChildren().add((Pane) addComment(Creator.comment));
            for (int i = 0; i < Creator.post.getComments().size(); i++) {
                this.myVBox.getChildren().add((Pane) addComment (Creator.comment.getComments().get(i)));
            }
        } catch (IOException e){
            e.printStackTrace();
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

