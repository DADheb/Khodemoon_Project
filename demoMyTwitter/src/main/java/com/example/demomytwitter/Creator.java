package com.example.demomytwitter;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class Creator {
    public static Double scale;
    public static String setUsername;
    public static String setPassword;
    public static String setQuestion;

    public static Node forgetPassword (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ForgetPassword.fxml"));
        node = fxmlLoader.load();
        return node;
    }
    public static Node logIn (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LogIn.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node signIn (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignIn.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node signInDetail (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignInDetail.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node signUp (Double s) throws IOException {
        scale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignUp.fxml"));
        node = fxmlLoader.load();
        return node;
    }
}
