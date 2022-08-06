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
import java.util.Collections;
import java.util.ResourceBundle;

public class ViewCommentsController implements Initializable {
    @FXML
    private ScrollPane mainPane;
    public VBox myVBox;

    private Color themeColor;
    private Color mode;
    private Color opposite;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.scale);
        try{
            this.myVBox.setPrefHeight(myVBox.getPrefHeight() + 420 * Creator.scale);
            this.myVBox.getChildren().add((Pane) addComment(Creator.comment));
            Collections.sort(Creator.post.getComments());
            for (int i = 0; i < Creator.post.getComments().size(); i++) {
                this.myVBox.setPrefHeight(myVBox.getPrefHeight() + 420 * Creator.scale);
                this.myVBox.getChildren().add((Pane) addComment (Creator.comment.getComments().get(i)));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initial(double scale) {
        theme();
        this.mainPane.setPrefWidth(600 * scale);
        this.mainPane.setPrefHeight(600 * scale);
        this.myVBox.setPrefWidth(600 * scale);
        this.myVBox.setPrefHeight(600 * scale);
        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.myVBox.setStyle("-fx-background-color: #" + mode.toString().substring(2));
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

    public Node addComment(Comment comment) throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TextComment.fxml"));
        TextCommentController textCommentController = fxmlLoader.getController();
        textCommentController.fillComment(comment, Creator.scale);
        node = fxmlLoader.load();
        return node;
    }
}

