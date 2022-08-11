package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Objects.ImagePostController;
import com.example.mytwitterphase2.FXMLController.Objects.TextPostController;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Post;
import com.example.mytwitterphase2.entity.User;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class ViewFollowingPostsController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ScrollPane mainPane;
    public VBox myVBox;
    @FXML
    private Text seeText;
    @FXML
    private Button backButton;

    private Color themeColor;
    private Color mode;
    private Color opposite;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.mainScale);
        try {
            ArrayList<Post> posts = new ArrayList<>();
            for (User u : DataBase.getUser().getFollowings()) {
                posts.addAll(u.getPosts());
            }
            Collections.sort(posts);
            for (int i = 0; i < posts.size(); i++) {
                this.myVBox.setPrefHeight(myVBox.getPrefHeight() + 420 * Creator.mainScale);
                this.anchorPane.setPrefHeight(anchorPane.getPrefHeight() + 420 * Creator.mainScale);
                this.myVBox.getChildren().add( addPost(posts.get(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initial(double scale) {
        theme();
        myVBox.setPrefHeight(0.0);
        anchorPane.setPrefHeight(59.0 * scale);
        this.anchorPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.anchorPane.setPrefWidth(600 * scale);
        this.anchorPane.setPrefHeight(600 * scale);
        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.mainPane.setPrefWidth(600 * scale);
        this.mainPane.setPrefHeight(600 * scale);

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
        if(LiveState.subState==1){
            this.backButton.setVisible(false);
        } else {
            this.backButton.setVisible(true);
        }
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
        Creator.post = post;
        Node node;
        if(post.getPostType() != 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ImagePost.fxml"));
            node = fxmlLoader.load();
            return node;
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/TextPost.fxml"));
            node = fxmlLoader.load();
            return node;
        }
    }
    @FXML
    protected void onBackClicked (ActionEvent e) throws IOException {
        LiveState.state = 7;
        DataBase.main.setMenuPane();
    }
}
