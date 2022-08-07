//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.users.Controller;

import com.example.users.DataBase.DataBase;
import com.example.users.Models.User;

import java.time.LocalDate;

public class UserController {
    public UserController() {
    }

    public static int follow(User u, User a) {
        if (a.getBlock().contains(u)) {
            return 1;
        } else if (a.getPrivacy()) {
            a.getFollowRequests().add(u);
            u.getRequests().add(a);
            u.getInterest().remove(a);
            u.getInterestAD().remove(a);
            return 2;
        } else {
            a.getFollowers().add(u);
            u.getFollowings().add(a);
            u.setNumberOfFollowings(u.getNumberOfFollowings() + 1);
            a.setNumberOfFollowers(a.getNumberOfFollowers() + 1);
            u.getInterest().remove(a);
            u.getInterestAD().remove(a);
            return 0;
        }
    }

    public static void unFollow(User u, User a) {
        a.getFollowers().remove(u);
        u.getFollowings().remove(a);
        u.setNumberOfFollowings(u.getNumberOfFollowings() - 1);
        a.setNumberOfFollowers(a.getNumberOfFollowers() - 1);
    }

    public static void unRequest(User u, User a) {
        a.getFollowRequests().remove(u);
        u.getRequests().remove(a);
    }

    public static void acceptRequest(User u, User a) {
        u.getRequests().remove(a);
        a.getFollowRequests().remove(u);
        a.getFollowers().add(u);
        u.getFollowings().add(a);
        u.setNumberOfFollowings(u.getNumberOfFollowings() + 1);
        a.setNumberOfFollowers(a.getNumberOfFollowers() + 1);
    }

//    public static void newPost(User u, Post p) {
//        u.getPosts().add(p);
//        u.setNumberOfPosts(u.getNumberOfPosts() + 1);
//    }
//
//    public static void newGroup(User u, Group g) {
//        u.getGroups().add(g);
//    }
//
//    public static void newChat(User u, Chat c) {
//        u.getChats().add(c);
//    }
//
//    public static void deleteChat(User u, Chat c) {
//        u.getChats().remove(c);
//    }
//
//    public static void deleteGroup(User u, Group g) {
//        u.getGroups().remove(g);
//    }
//
//    public static void deletePost(User u, Post p) {
//        u.getPosts().remove(p);
//        u.setNumberOfPosts(u.getNumberOfPosts() - 1);
//    }

    public static void changeUserName(User u, String s) {
        int index = DataBase.getUserNames().indexOf(u.getUserName());
        u.setUserName(s);
        DataBase.getUserNames().remove(index);
        DataBase.getUserNames().add(index, s);
    }

    public static void changeName(User u, String s) {
        u.setName(s);
    }

    public static void changeLastName(User u, String s) {
        u.setLastName(s);
    }

    public static void changeEmail(User u, String s) {
        u.setEmail(s);
    }

    public static void changeBio(User u, String s) {
        u.setBio(s);
    }

    public static void changeBirthDay(User u, String s) {
        u.setBirthday(s);
    }

    public static void changePrivacy(User u, Boolean b) {
        u.setPrivacy(b);
    }

    public static void changePassword(User u, String s) {
        int index = DataBase.getUserNames().indexOf(u.getUserName());
        u.setPassword(s);
        DataBase.getUserPasswords().remove(index);
        DataBase.getUserPasswords().add(index, s);
    }

    public static void changeSecurityQuestionsAnswers(User u, String s) {
        u.setSecurityQuestionsAnswers(s);
    }

    public static User getUser(String userName) {
        return (User) DataBase.getUsers().get(DataBase.getUserID(userName));
    }

    public static void setDate(User u) {
        u.setDate(LocalDate.now().toString());
    }

    public static void view(User u, User a) {
        if (u.getViewPD().keySet().contains(LocalDate.now().toString())) {
            u.getViewPD().replace(LocalDate.now().toString(), (Integer) u.getViewPD().get(LocalDate.now().toString()) + 1);
        } else {
            u.getViewPD().put(LocalDate.now().toString(), 1);
        }

        if (a.getInterest().keySet().contains(u)) {
            a.getInterest().replace(u, (Integer) a.getInterest().get(u) + 1);
            if (u.isUserType()) {
                a.getInterestAD().replace(u, (Integer) a.getInterestAD().get(u) + 1);
            }
        } else {
            if (a.getFollowings().contains(u)) {
                return;
            }

            a.getInterest().put(u, 1);
            if (u.isUserType()) {
                a.getInterestAD().put(u, 1);
            }
        }

    }

    public static void interestLike(User u, User a) {
        if (a.getInterest().containsKey(u)) {
            a.getInterest().replace(u, (Integer) a.getInterest().get(u) + 5);
            if (u.isUserType()) {
                a.getInterestAD().replace(u, (Integer) a.getInterestAD().get(u) + 5);
            }
        } else {
            if (a.getFollowings().contains(u)) {
                return;
            }

            a.getInterest().put(u, 5);
            if (u.isUserType()) {
                a.getInterestAD().put(u, 5);
            }
        }

    }

    public static void interestDislike(User u, User a) {
        if (a.getInterest().containsKey(u)) {
            a.getInterest().replace(u, (Integer) a.getInterest().get(u) - 5);
            if (u.isUserType()) {
                a.getInterestAD().replace(u, (Integer) a.getInterestAD().get(u) - 5);
            }
        } else {
            if (a.getFollowings().contains(u)) {
                return;
            }

            a.getInterest().put(u, -5);
            if (u.isUserType()) {
                a.getInterestAD().put(u, -5);
            }
        }

    }

    public static void interestComment(User u, User a) {
        if (a.getInterest().containsKey(u)) {
            a.getInterest().replace(u, (Integer) a.getInterest().get(u) + 10);
            if (u.isUserType()) {
                a.getInterestAD().replace(u, (Integer) a.getInterestAD().get(u) + 10);
            }
        } else {
            if (a.getFollowings().contains(u)) {
                return;
            }

            a.getInterest().put(u, 10);
            if (u.isUserType()) {
                a.getInterestAD().put(u, 10);
            }
        }

    }

    public static void interestDeleteComment(User u, User a) {
        if (a.getInterest().containsKey(u)) {
            a.getInterest().replace(u, (Integer) a.getInterest().get(u) - 10);
            if (u.isUserType()) {
                a.getInterestAD().replace(u, (Integer) a.getInterestAD().get(u) - 10);
            }
        } else {
            if (a.getFollowings().contains(u)) {
                return;
            }

            a.getInterest().put(u, -10);
            if (u.isUserType()) {
                a.getInterestAD().put(u, -10);
            }
        }

    }

    public static void block(User a, User b) {
        a.getBlock().add(b);
        a.getInterest().remove(b);
        a.getInterestAD().remove(b);
    }

    public static void unblock(User a, User b) {
        a.getBlock().remove(b);
    }
}
