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
        initial(Creator.scale);
        try{
            ArrayList<Post> posts = new ArrayList<>();
            for (User u : DataBase.getUser().getFollowings()){
                posts.addAll(u.getPosts());
            }
            Collections.sort(posts);
            for (int i = 0; i < posts.size(); i++) {
                this.myVBox.setPrefHeight(myVBox.getPrefHeight() + 420 * Creator.scale);
                this.myVBox.getChildren().add((Pane) addPost(posts.get(i)));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initial(double scale) {
        theme();
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

    @FXML
    protected void onBackClicked (ActionEvent e) throws IOException {
        //todo
    }
}
