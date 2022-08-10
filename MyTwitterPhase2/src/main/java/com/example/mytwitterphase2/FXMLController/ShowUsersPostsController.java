package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Objects.ImagePostController;
import com.example.mytwitterphase2.FXMLController.Objects.TextCommentController;
import com.example.mytwitterphase2.FXMLController.Objects.TextPostController;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Comment;
import com.example.mytwitterphase2.entity.Post;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class ShowUsersPostsController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    public VBox myBox;

    private Color themeColor;
    private Color mode;
    private Color opposite;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.mainScale);
        try{
            Collections.sort(Creator.user.getPosts());
            for (int i = 0; i < Creator.user.getPosts().size(); i++) {
                this.myBox.setPrefHeight(myBox.getPrefHeight() + 420 * Creator.mainScale);
                this.mainPane.setPrefHeight(mainPane.getPrefHeight() + 420 * Creator.mainScale);
                this.myBox.getChildren().add((Pane) addPost(Creator.user.getPosts().get(i)));
            }
            Creator.usersPostVBox = myBox.getPrefHeight();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initial(double scale) {
        theme();
        myBox.setPrefHeight(0.0);
        mainPane.setPrefHeight(0.0);
        this.mainPane.setPrefWidth(600 * scale);
        this.mainPane.setPrefHeight(600 * scale);
        this.myBox.setPrefHeight(600 * scale);
        this.myBox.setPrefWidth(600 * scale);
        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.myBox.setStyle("-fx-background-color: #" + mode.toString().substring(2));
    }

    public void theme() {
        switch (DataBase.theme) {
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
            FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObjects/ImagePost.fxml"));
            ImagePostController imagePostController = fxmlLoader.getController();
            imagePostController.fillPost(Creator.post, Creator.subScale);
            node = fxmlLoader.load();
            return node;
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObjects/TextPost.fxml"));
            TextPostController textPostController = fxmlLoader.getController();
            textPostController.fillPost(Creator.post, Creator.subScale);
            node = fxmlLoader.load();
            return node;
        }
    }
}
