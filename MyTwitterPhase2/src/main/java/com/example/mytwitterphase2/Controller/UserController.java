package com.example.mytwitterphase2.Controller;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.entity.*;

import java.time.LocalDate;

public class UserController {

    static public int follow(User u, User a) {
        if (a.getBlock().contains(u)) {
            return 1;
        }
        if (a.getPrivacy()) {
            a.getFollowRequests().add(u);
            u.getRequests().add(a);
            u.getInterest().remove(a);
            u.getInterestAD().remove(a);
            return 2;
        }
        a.getFollowers().add(u);
        u.getFollowings().add(a);
        u.setNumberOfFollowings(u.getNumberOfFollowings() + 1);
        a.setNumberOfFollowers(a.getNumberOfFollowers() + 1);
        u.getInterest().remove(a);
        u.getInterestAD().remove(a);
        return 0;
    }

    static public void unFollow(User u, User a) {
        a.getFollowers().remove(u);
        u.getFollowings().remove(a);
        u.setNumberOfFollowings(u.getNumberOfFollowings() - 1);
        a.setNumberOfFollowers(a.getNumberOfFollowers() - 1);
    }

    static public void unRequest(User u, User a) {
        a.getFollowRequests().remove(u);
        u.getRequests().remove(a);
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
        int index = DataBase.getUserNames().indexOf(u.getUserName());
        u.setUserName(s);
        DataBase.getUserNames().remove(index);
        DataBase.getUserNames().add(index,s);
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
        int index = DataBase.getUserNames().indexOf(u.getUserName());
        u.setPassword(s);
        DataBase.getUserPasswords().remove(index);
        DataBase.getUserPasswords().add(index,s);
    }

    static public void changeSecurityQuestionsAnswers(User u, String s) {
        u.setSecurityQuestionsAnswers(s);
    }

    static public User getUser(String userName) {
        return DataBase.getUsers().get(DataBase.getUserID(userName));
    }

    static public void setDate(User u) {
        u.setDate(LocalDate.now().toString());
    }

    static public void view(User u,User a){
        if(u.getViewPD().keySet().contains(LocalDate.now().toString())){
            u.getViewPD().replace(LocalDate.now().toString(),u.getViewPD().get(LocalDate.now().toString())+1);
        } else {
            u.getViewPD().put(LocalDate.now().toString(),1);
        }
        if(a.getInterest().keySet().contains(u)){
            a.getInterest().replace(u,a.getInterest().get(u)+1);
            if(u.isUserType()){
                a.getInterestAD().replace(u,a.getInterestAD().get(u)+1);
            }
        } else {
            if(a.getFollowings().contains(u)){
                return;
            }
            a.getInterest().put(u , 1);
            if(u.isUserType()){
                a.getInterestAD().put(u , 1);
            }
        }
    }
    static public void interestLike(User u,User a){
        if(a.getInterest().containsKey(u)){
            a.getInterest().replace(u,a.getInterest().get(u)+5);
            if(u.isUserType()){
                a.getInterestAD().replace(u,a.getInterestAD().get(u)+5);
            }
        } else {
            if(a.getFollowings().contains(u)){
                return;
            }
            a.getInterest().put(u , 5);
            if(u.isUserType()){
                a.getInterestAD().put(u , 5);
            }
        }
    }
    static public void interestDislike(User u,User a){
        if(a.getInterest().containsKey(u)){
            a.getInterest().replace(u,a.getInterest().get(u)-5);
            if(u.isUserType()){
                a.getInterestAD().replace(u,a.getInterestAD().get(u)-5);
            }
        } else {
            if(a.getFollowings().contains(u)){
                return;
            }
            a.getInterest().put(u , -5);
            if(u.isUserType()){
                a.getInterestAD().put(u , -5);
            }
        }
    }
    static public void interestComment(User u,User a){
        if(a.getInterest().containsKey(u)){
            a.getInterest().replace(u,a.getInterest().get(u)+10);
            if(u.isUserType()){
                a.getInterestAD().replace(u,a.getInterestAD().get(u)+10);
            }
        } else {
            if(a.getFollowings().contains(u)){
                return;
            }
            a.getInterest().put(u , 10);
            if(u.isUserType()){
                a.getInterestAD().put(u , 10);
            }
        }
    }
    static public void interestDeleteComment(User u,User a){
        if(a.getInterest().containsKey(u)){
            a.getInterest().replace(u,a.getInterest().get(u)-10);
            if(u.isUserType()){
                a.getInterestAD().replace(u,a.getInterestAD().get(u)-10);
            }
        } else {
            if(a.getFollowings().contains(u)){
                return;
            }
            a.getInterest().put(u , -10);
            if(u.isUserType()){
                a.getInterestAD().put(u , -10);
            }
        }
    }
    static public void block(User a,User b){
        a.getBlock().add(b);
        a.getInterest().remove(b);
        a.getInterestAD().remove(b);
    }
    static public void unblock(User a,User b){
        a.getBlock().remove(b);
    }
}
