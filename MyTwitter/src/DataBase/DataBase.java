package DataBase;

import entity.*;

import java.util.ArrayList;

public class DataBase {
    static private ArrayList<User> users = new ArrayList<>();
    static private ArrayList<User> businessUsers = new ArrayList<>();
    static private ArrayList<Post> posts = new ArrayList<>();
    static private ArrayList<Comment> comments = new ArrayList<>();
    static private ArrayList<Like> likes = new ArrayList<>();
    private static ArrayList<Message> messages = new ArrayList<>();
    private static ArrayList<Group> groups = new ArrayList<>();
    private static ArrayList<Chat> chats = new ArrayList<>();
    static private ArrayList<String> userNames = new ArrayList<>();
    static private ArrayList<String> userPasswords = new ArrayList<>();
    static private User mainUser;

    public static ArrayList<Chat> getChats() {
        return chats;
    }
    static public ArrayList<User> getUsers() {
        return users;
    }

    public static User getUser() {
        return mainUser;
    }

    public static void setUser(User user) {
        DataBase.mainUser = user;
    }

    public static ArrayList<User> getBusinessUsers() {
        return businessUsers;
    }

    public static ArrayList<Post> getPosts() {
        return posts;
    }

    public static ArrayList<Comment> getComments() {
        return comments;
    }

    public static ArrayList<Like> getLikes() {
        return likes;
    }

    public static ArrayList<Message> getMessages() {
        return messages;
    }

    public static ArrayList<Group> getGroups() {
        return groups;
    }

    public static ArrayList<String> getUserNames() {
        return userNames;
    }

    public static ArrayList<String> getUserPasswords() {
        return userPasswords;
    }
    public static int getUserID(String userName){
        return userNames.indexOf(userName);
    }
    public static int getUserID(User user){
        return users.indexOf(user);
    }
}
