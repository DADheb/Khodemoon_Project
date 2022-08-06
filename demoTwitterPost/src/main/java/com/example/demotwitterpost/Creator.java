package com.example.demotwitterpost;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class Creator {
    static Double scale = 1.0;
    static Post post;
    static Comment comment;
    static int type = 0;
    static User user;
    static Double usersPostVBox;
    // 0 :comment on post  1 :comment on comment

    public static void setType(int type) {
        Creator.type = type;
    }

    public static void setPost(Post post) {
        Creator.post = post;
    }

    public static void setComment(Comment comment) {
        Creator.comment = comment;
    }

    public static Node showUserPosts (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowUsersPost.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showFollowingsPosts (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowFollowingsPost.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node viewPosts (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewPosts.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node viewComments (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewComments.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node morePublicUser (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MoreTextPost.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node morePrivateUser (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MoreImagePost.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node moreComment (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MoreComment.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node createPost (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreatePost.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node createComment (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateComment.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node viewFollowingPosts (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewFollowingPosts.fxml"));
        node = fxmlLoader.load();
        return node;
    }


}
