package Controller;

import entity.*;
import DataBase.DataBase;

public class UserController {

    static public void follow(User u, User a) {
        if (a.getPrivacy()) {
            a.getFollowRequests().add(u);
            u.getRequests().add(a);
        } else {
            a.getFollowers().add(u);
            u.getFollowings().add(a);
            u.setNumberOfFollowings(u.getNumberOfFollowings() + 1);
            a.setNumberOfFollowers(a.getNumberOfFollowers() + 1);
        }
    }

    static public void unFollow(User u, User a) {
        a.getFollowers().remove(u);
        u.getFollowings().remove(a);
        u.setNumberOfFollowings(u.getNumberOfFollowings() - 1);
        a.setNumberOfFollowers(a.getNumberOfFollowers() - 1);
    }

    static public void unRequest(User u, User a) {
        a.getFollowRequests().remove(u);
        u.getRequests().add(a);
    }

    static public void acceptRequest(User u, User a) {
        u.getRequests().remove(a);
        a.getFollowRequests().remove(u);
        a.getFollowers().add(u);
        u.getFollowings().add(a);
        u.setNumberOfFollowings(u.getNumberOfFollowings() + 1);
        a.setNumberOfFollowers(a.getNumberOfFollowers() + 1);
    }

    static public void newPost(User u, Post p) {
        u.getPosts().add(p);
        u.setNumberOfPosts(u.getNumberOfPosts() + 1);
    }

    static public void newGroup(User u, Group g) {
        u.getGroups().add(g);
    }

    static public void newChat(User u, Chat c) {
        u.getChats().add(c);
    }

    static public void deleteChat(User u, Chat c) {
        u.getChats().remove(c);
    }

    static public void deleteGroup(User u, Group g) {
        u.getGroups().remove(g);
    }

    static public void deletePost(User u, Post p) {
        u.getPosts().remove(p);
        u.setNumberOfPosts(u.getNumberOfPosts() - 1);
    }

    static public void changeUserName(User u, String s) {
        u.setUserName(s);
    }

    static public void changeName(User u, String s) {
        u.setName(s);
    }

    static public void changeLastName(User u, String s) {
        u.setLastName(s);
    }

    static public void changeEmail(User u, String s) {
        u.setEmail(s);
    }

    static public void changeBio(User u, String s) {
        u.setBio(s);
    }

    static public void changeBirthDay(User u, String s) {
        u.setBirthday(s);
    }

    static public void changePrivacy(User u, Boolean b) {
        u.setPrivacy(b);
    }

    static public void changePassword(User u, String s) {
        u.setPassword(s);
    }
    static public void changeSecurityQuestionsAnswers(User u, String s) {
        u.setSecurityQuestionsAnswers(s);
    }
    public User getUser(String userName){
        return DataBase.getUsers().get(DataBase.getUserID(userName));
    }
}
