package com.example.users.DataBase;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.users.Models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


    //private static Connection connection;
    public static Scanner scanner;
    private static ArrayList<User> users;
    private static ArrayList<User> businessUsers;
    //        private static ArrayList<Post> posts;
//        private static ArrayList<Comment> comments;
//        private static ArrayList<Like> likes;
//        private static ArrayList<Message> messages;
//        private static ArrayList<Group> groups;
//        private static ArrayList<Chat> chats;
    private static ArrayList<String> userNames;
    private static ArrayList<String> userPasswords;
    private static User mainUser;
    private static double scale;
    public static int theme;

    public DataBase() {
    }

    public static double getScale() {
        return scale;
    }

    public static void setScale(double scale) {
        DataBase.scale = scale;
    }

    public static int getTheme() {
        return theme;
    }

    public static void setTheme(int theme) {
        DataBase.theme = theme;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getUser() {
        return mainUser;
    }

    public static void setUser(User user) {
        mainUser = user;
    }

    public static ArrayList<User> getBusinessUsers() {
        return businessUsers;
    }

    public static ArrayList<String> getUserNames() {
        return userNames;
    }

    public static ArrayList<String> getUserPasswords() {
        return userPasswords;
    }

    public static int getUserID(String userName) {
        return userNames.indexOf(userName);
    }

    public static int getUserID(User user) {
        return users.indexOf(user);
    }


    static {
        scanner = new Scanner(System.in);
        users = new ArrayList();
        businessUsers = new ArrayList();
//        posts = new ArrayList();
//        comments = new ArrayList();
//        likes = new ArrayList();
//        messages = new ArrayList();
//        groups = new ArrayList();
//        chats = new ArrayList();
        userNames = new ArrayList();
        userPasswords = new ArrayList();
        scale = 1.0D;
        theme = 3;
    }

}


