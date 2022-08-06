package com.example.users.FXMLController;

import com.example.users.DataBase.DataBase;
import com.example.users.Main;
import com.example.users.Models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Stream;

public class Suggestions implements Initializable {
    @FXML
    private ScrollPane suggestionScrollPane;
    @FXML
    private Pane topPane;
    @FXML
    private ImageView backImage;
    @FXML
    private Label titleL;
    @FXML
    private VBox mainVBox;
    private double scale;
    private Color themeColor;
    private Color mode;
    private Image image;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scale = Creator.getScale();
        initial();
        ArrayList<Post> myPosts = showAds(DataBase.getUser());
        ArrayList<User> myUsers = showInterestUser(DataBase.getUser());
        try {
            for (int i = 0; i < myUsers.size(); i++) {
                this.mainVBox.setPrefHeight(mainVBox.getPrefHeight() + 90 * scale);
                this.mainVBox.getChildren().add((Pane) addUser(myUsers.get(i)));
            }
            for (int i = 0; i < myPosts.size(); i++) {
                this.mainVBox.setPrefHeight(mainVBox.getPrefHeight() + 420 * scale);
                this.mainVBox.getChildren().add((Pane) addPost(myPosts.get(i)));
                for (int j = 0; j < myPosts.get(i).getComments().size(); j++) {
                    this.mainVBox.setPrefHeight(mainVBox.getPrefHeight() + 420 * scale);
                    this.mainVBox.getChildren().add((Pane) addComment(myPosts.get(i).getComments().get(j)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initial() {
        theme();
        suggestionScrollPane.setPrefWidth(600 * scale);
        suggestionScrollPane.setPrefHeight(600 * scale);
        mainVBox.setPrefWidth(600 * scale);
        topPane.setPrefWidth(600 * scale);
        topPane.setPrefHeight(50 * scale);
        titleL.setFont(Font.font(24 * scale));
        titleL.setLayoutX(239 * scale);
        titleL.setLayoutY(11 * scale);
        backImage.setLayoutX(14 * scale);
        backImage.setLayoutY(4 * scale);
        backImage.setFitWidth(43 * scale);
        backImage.setFitHeight(48 * scale);

        topPane.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));
        titleL.setTextFill(mode);
    }

    public Node addPost(Post post) throws IOException {
        Node node;
        if (post.getPostType() != 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ImagePost.fxml"));
            ImagePostController imagePostController = fxmlLoader.getController();
            imagePostController.fillPost(Creator.post, Creator.scale);
            node = fxmlLoader.load();
            return node;
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TextPost.fxml"));
            TextPostController textPostController = fxmlLoader.getController();
            textPostController.fillPost(Creator.post, Creator.scale);
            node = fxmlLoader.load();
            return node;
        }
    }

    public Node addComment(Comment comment) throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new
                FXMLLoader(HelloApplication.class.getResource("TextComment.fxml"));
        TextCommentController textCommentController =
                fxmlLoader.getController();
￼textCommentController.fillComment(comment, Creator.scale);
        node = fxmlLoader.load();
        return node;
    }

    public Node addUser(User user) throws IOException {
        return Creator.showShortUser(user, this.scale);
    }

    public ArrayList<Post> showAds(User u) {
        Stream<Map.Entry<User, Integer>> sorted =
                u.getInterestAD().entrySet().stream().sorted(Map.Entry.comparingByValue());
        int size = u.getInterestAD().size();
        int limit = Math.min(size, 5);
        ArrayList<Post> posts = new ArrayList<>();
        User[] users = (User[]) sorted.toArray();
        for (int i = size - 1; i >= size - limit; i--) {
            User user = users[i];
            for (Post p : user.getPosts()) {
                if (!p.getUserLikes().contains(u)) {
                    posts.add(p);
                }
            }
        }
        limit = Math.min(posts.size(), 5);
        ArrayList<Post> selectedPosts = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            selectedPosts.add(posts.get(i));
        }
        Collections.sort(DataBase.getPosts());
        int number = 0;
        for (Post p : DataBase.getPosts()) {
            if (p.getUser().equals(u)) {
                continue;
            }
            if (p.getUserLikes().contains(u)) {
                continue;
            }
            if (posts.contains(p)) {
                continue;
            }
            number++;
        }
        int n = Math.min(5 - limit, number);
        int i = 0;
        while (n > 0) {
            Post p = DataBase.getPosts().get(i);
            if (p.getUser().equals(u)) {
                i++;
                continue;
            }
            if (p.getUserLikes().contains(u)) {
                i++;
                continue;
            }
            if (posts.contains(p)) {
                i++;
                continue;
            }
            n--;
            selectedPosts.add(p);
        }
        return selectedPosts;
    }

    public ArrayList<User> showInterestUser(User u) {
        Stream<Map.Entry<User, Integer>> sorted =
                u.getInterest().entrySet().stream().sorted(Map.Entry.comparingByValue());
        int size = u.getInterest().size();
        int limit = Math.min(size, 5);
        User[] users = (User[]) sorted.toArray();
        ArrayList<User> selectedUsers = new ArrayList<>();
        for (int i = size - 1; i >= size - limit; i--) {
            selectedUsers.add(users[i]);
        }
        limit = Math.min(5 - limit, DataBase.getUsers().size() - 1 - limit);
        Collections.sort(DataBase.getUsers());
        for (int i = 0; i < limit; i++) {
            if (DataBase.getUsers().get(i).equals(u)) {
                selectedUsers.add(DataBase.getUsers().get(limit));
            } else {
                selectedUsers.add(DataBase.getUsers().get(i));
            }
        }
        return selectedUsers;
    }


    public void theme() {
        switch (DataBase.getTheme()) {
            case 1:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/BackWhite.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 2:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/BackDark.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 3:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/BackWhite.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 4:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(Main.class.getResource("Photo/Project/BackDark.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
        }
    }
}
