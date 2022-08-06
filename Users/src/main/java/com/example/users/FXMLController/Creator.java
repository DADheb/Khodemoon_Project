package com.example.users.FXMLController;

import com.example.users.Controller.UserController;
import com.example.users.DataBase.DataBase;
import com.example.users.Main;
import com.example.users.Models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class Creator {
    private static User othersProfileHeaderUser;
    private static User shortUser;
    private static User requestShortUser;
    private static double scale;
    private static User userToShow;
    private static String followerOrFollowing;

    public static Node showOthersProfile(User user, double s) throws IOException {
        scale = s;
        othersProfileHeaderUser = user;
        UserController.view(user, DataBase.getUser());
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("OthersProfile.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showMyProfile(double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MyProfile.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showShortUser(User user, double s) throws IOException {
        shortUser = user;
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ShortUser.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showRequestShortUser(User user, double s) throws IOException {
        requestShortUser = user;
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ShortRequest.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showFollowingsOrFollowers(User user, String s, double d) throws IOException {
        followerOrFollowing = s;
        userToShow = user;
        scale = d;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Followings.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showRequests(double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Requests.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showViewers(double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ViewsPerDay.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showSuggestions(double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Suggestions.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static User getOthersProfileHeaderUser() {
        return othersProfileHeaderUser;
    }

    public static User getShortUser() {
        return shortUser;
    }

    public static double getScale() {
        return scale;
    }

    public static User getUserToShow() {
        return userToShow;
    }

    public static String getFollowerOrFollowing() {
        return followerOrFollowing;
    }

    public static User getRequestShortUser() {
        return requestShortUser;
    }

    public static void setOthersProfileHeaderUser(User user) {
        othersProfileHeaderUser = user;
    }
}
