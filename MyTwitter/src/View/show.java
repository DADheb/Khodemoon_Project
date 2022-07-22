package View;

import Controller.ControllerManager;
import DataBase.DataBase;
import entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Show {
    public static Scanner scan = DataBase.scanner;
    static public void printLine() {
        for (int i = 0; i < 100; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static public void showSecurityQuestion() {
        System.out.print("What is your favorite animal? ");
    }

    static public void showSpace(int space) {
        for (int i = 0; i < space; i++) {
            System.out.print("\t");
        }
    }

    static public void showShortUser(User u, int space) {
        printLine();
        showSpace(space);
        System.out.println(u.getUserName());
        showSpace(space);
        System.out.println(u.getName() + " " + u.getLastName());
        printLine();
    }

    static public void showLongUser(User u) {
        printLine();
        System.out.println(u.getUserName());
        System.out.println(u.getName() + " " + u.getLastName());
        System.out.println("Bio : " + u.getBio());
        System.out.println();
        System.out.println(u.getNumberOfPosts() + " Posts \t \t" + u.getNumberOfFollowings() + " Followings \t \t" + u.getNumberOfFollowers() + " Followers");
        System.out.println();
        printLine();
        if (DataBase.getUser().equals(u) || (!u.isPrivacy()) || DataBase.getUser().getFollowings().contains(u)) {
            showPostList(u.getPosts(), 0, 10, 1);
        } else {
            System.out.println("this account is private");
        }
    }

    static public void showSettingUser(User u) {
        if (!DataBase.getUser().equals(u)) {
            System.out.println("invalid command");
            return;
        }
        printLine();
        System.out.println("Username : " + u.getUserName());
        System.out.println("Name : " + u.getName());
        System.out.println("Lastname : " + u.getLastName());
        System.out.println("Bio : " + u.getBio());
        System.out.println("Email : " + u.getEmail());
        System.out.println("Birthday : " + u.getBirthday());
        showSecurityQuestion();
        System.out.println(u.getSecurityQuestionsAnswers());
        System.out.print("Your account is ");
        if (u.isPrivacy()) {
            System.out.println("private");
        } else {
            System.out.println("public");
        }
        if (u.isUserType()) {
            System.out.println("Your account is Business account");
        }
        printLine();
    }

    static public void showShortPost(Post p, int space) {
        if (p.getUser().equals(DataBase.getUser())) {
            printLine();
            showSpace(space);
            System.out.println("Me :");
            showSpace(space);
            System.out.println(p.getText());
            showSpace(space);
            System.out.println();
            showSpace(space);
            System.out.println(p.getNumberOfLikes() + " Likes \t \t" + p.getNumberOfView() + " Views \t \t" + p.getComments().size() + " Comments");
            System.out.println();
            System.out.println("ID : " + (DataBase.getPosts().indexOf(p) + 1));
            showSpace(space);
            if (p.isEdited()) {
                System.out.println("this post was edited");
            }
            printLine();
        } else if ((!p.getUser().isPrivacy()) || DataBase.getUser().getFollowings().contains(p.getUser())) {
            printLine();
            if (p.getUser().isUserType()) {
                showSpace(space - 1);
                System.out.println("AD");
            }
            showSpace(space);
            System.out.println(p.getUser().getUserName() + " :");
            showSpace(space);
            System.out.println(p.getText());
            System.out.println();
            showSpace(space);
            System.out.println(p.getNumberOfLikes() + " Likes \t \t" + p.getNumberOfView() + " Views \t \t" + p.getComments().size() + " Comments");
            System.out.println();
            System.out.println("ID : " + (DataBase.getPosts().indexOf(p) + 1));
            showSpace(space);
            if (p.isEdited()) {
                System.out.println("this post was edited");
            }
            printLine();
        } else {
            printLine();
            System.out.println("this post is private");
            printLine();
        }
    }

    static public void showLongPost(Post p) {
        if (p.getUser().equals(DataBase.getUser())) {
            printLine();
            System.out.println("Me on " + p.getDate() + " :");
            System.out.println(p.getText());
            System.out.println();
            System.out.println(p.getNumberOfLikes() + " Likes \t \t" + p.getNumberOfView() + " Views");
            System.out.println();
            System.out.println("ID : " + (DataBase.getPosts().indexOf(p) + 1));
            if (p.isEdited()) {
                System.out.println("this post was edited");
            }
            printLine();
            showCommentList(p.getComments(), 0, 5, 1);
        } else if ((!p.getUser().isPrivacy()) || DataBase.getUser().getFollowings().contains(p.getUser())) {
            printLine();
            if (p.getUser().isUserType()) {
                System.out.println("AD");
            }
            System.out.println(p.getUser().getUserName() + "on " + p.getDate() + " :");
            System.out.println(p.getText());
            System.out.println();
            System.out.println(p.getNumberOfLikes() + " Likes \t \t" + p.getNumberOfView() + " Views");
            System.out.println();
            System.out.println("ID : " + (DataBase.getPosts().indexOf(p) + 1));
            if (p.isEdited()) {
                System.out.println("this post was edited");
            }
            printLine();
            showCommentList(p.getComments(), 0, 5, 1);
        } else {
            printLine();
            System.out.println("this post is private");
            printLine();
        }
    }

    static public void showShortComment(Comment c, int space) {
        User u = ControllerManager.getMother(c).getUser();
        if ((!u.equals(DataBase.getUser())) && u.isPrivacy() && (!DataBase.getUser().getFollowings().contains(u))) {
            printLine();
            showSpace(space);
            System.out.println("This comment is private");
            printLine();
            return;
        }
        if (c.getUser().equals(DataBase.getUser())) {
            printLine();
            showSpace(space);
            System.out.println("Me :");
            showSpace(space);
            System.out.println(c.getText());
            showSpace(space);
            System.out.println();
            showSpace(space);
            System.out.println(c.getNumberOfLikes() + " Likes \t \t" + c.getComments().size() + " Comments");
            System.out.println();
            System.out.println("ID : " + (DataBase.getComments().indexOf(c) + 1));
            showSpace(space);
            if (c.isEdited()) {
                System.out.println("this post was edited");
            }
            printLine();
        } else {
            printLine();
            showSpace(space);
            System.out.println(c.getUser().getUserName() + " :");
            showSpace(space);
            System.out.println(c.getText());
            showSpace(space);
            System.out.println();
            showSpace(space);
            System.out.println(c.getNumberOfLikes() + " Likes \t \t" + c.getComments().size() + " Comments");
            System.out.println();
            System.out.println("ID : " + (DataBase.getComments().indexOf(c) + 1));
            showSpace(space);
            if (c.isEdited()) {
                System.out.println("this post was edited");
            }
            printLine();
        }
    }

    static public void showLongComment(Comment c) {
        User u = ControllerManager.getMother(c).getUser();
        if ((!u.equals(DataBase.getUser())) && u.isPrivacy() && (!DataBase.getUser().getFollowings().contains(u))) {
            printLine();
            System.out.println("This comment is private");
            printLine();
            return;
        }
        if (c.getUser().equals(DataBase.getUser())) {
            printLine();
            System.out.println("Me on " + c.getDate() + " :");
            System.out.println(c.getText());
            System.out.println();
            System.out.println(c.getNumberOfLikes() + " Likes");
            System.out.println();
            System.out.println("ID : " + (DataBase.getComments().indexOf(c) + 1));
            if (c.isEdited()) {
                System.out.println("this post was edited");
            }
            printLine();
            showCommentList(c.getComments(), 0, 5, 1);
        } else {
            printLine();
            System.out.println(c.getUser().getUserName() + "on " + c.getDate() + " :");
            System.out.println(c.getText());
            System.out.println();
            System.out.println(c.getNumberOfLikes() + " Likes");
            System.out.println();
            System.out.println("ID : " + (DataBase.getComments().indexOf(c) + 1));
            if (c.isEdited()) {
                System.out.println("this post was edited");
            }
            printLine();
            showCommentList(c.getComments(), 0, 5, 1);
        }
    }

    static public void showShortChat(Chat c, int space) {
        if (c.getA().equals(DataBase.getUser())) {
            printLine();
            showSpace(space);
            System.out.println("Chat with : " + c.getB().getUserName());
            showSpace(space);
            System.out.println("ID : " + DataBase.getComments().indexOf(c));
            printLine();
        } else if (c.getB().equals(DataBase.getUser())) {
            printLine();
            showSpace(space);
            System.out.println("Chat with : " + c.getA().getUserName());
            showSpace(space);
            System.out.println("ID : " + DataBase.getComments().indexOf(c));
            printLine();
        } else {
            System.out.println("invalid command");
            return;
        }
    }

    static public void showLongChat(Chat c) {
        if (c.getA().equals(DataBase.getUser())) {
            printLine();
            System.out.println("Chat whit : " + c.getB().getName() + " " + c.getB().getLastName());
            System.out.println(c.getB().getUserName());
            printLine();
            showMessageList(c.getMessages(), 0, 5);
        } else if (c.getB().equals(DataBase.getUser())) {
            printLine();
            System.out.println("Chat whit : " + c.getA().getName() + " " + c.getA().getLastName());
            System.out.println(c.getA().getUserName());
            printLine();
            showMessageList(c.getMessages(), 0, 5);
        } else {
            System.out.println("invalid command");
            return;
        }
    }

    static public void showShortGroup(Group g, int space) {
        printLine();
        showSpace(space);
        System.out.println("Group Name : " + g.getName());
        showSpace(space);
        System.out.println("Group ID : " + DataBase.getGroups().indexOf(g));
        printLine();
    }

    static public void showLongGroup(Group g) {
        printLine();
        System.out.println("Group Name : " + g.getName());
        System.out.println("Number of members : " + g.getMembers().size());
        printLine();
        showMessageList(g.getMessages(), 0, 5);
    }

    static public void showGroupInfo(Group g) {
        printLine();
        System.out.println("Group Name : " + g.getName());
        System.out.println("Bio : " + g.getBio());
        System.out.println("Creat Date : " + g.getCreatDate());
        System.out.println("Group Member :");
        printLine();
        showGroupMember(g.getMembers(), g);
    }

    static public void showGroupMember(ArrayList<User> members, Group group) {
        for (User u : members) {
            showMember(u, group);
        }
    }

    static public void showMember(User member, Group g) {
        printLine();
        System.out.println(member.getUserName());
        switch (ControllerManager.getGrade(g, member)) {
            case 1:
                System.out.println("Ban");
                break;
            case 2:
                System.out.println("Creator");
                break;
            case 3:
                System.out.println("Admin");
                break;
            case 0:
                System.out.println("Member");
        }
        printLine();
    }

    static public void showMessage(Message m) {
        printLine();
        if (m.isForwarded()) {
            if (m.getForwarder().equals(DataBase.getUser())) {
                System.out.println("Me :");
            } else {
                System.out.println(m.getForwarder().getUserName() + " :");
            }
        } else {
            if (m.getUser().equals(DataBase.getUser())) {
                System.out.println("Me :");
            } else {
                System.out.println(m.getForwarder().getUserName() + " :");
            }
        }
        if (m.isForwarded()) {
            System.out.println("Forwarded from " + m.getUser().getUserName());
        }
        if (m.isReply()) {
            System.out.println("Reply on : " + m.getMessage().getUser().getUserName() + " : " + m.getMessage().getText().substring(0, 50));
        }
        System.out.println(m.getText());
        if (m.isEdited()) {
            System.out.println("this message was edited");
        }
        if (m.isSeen()) {
            System.err.println("SEEN");
        }
        printLine();
    }

    static public void showUserList(ArrayList<User> users, int start, int limit, int space) {
        limit = Math.min(users.size()-start,limit);
        for (int i = start; i < start + limit; i++) {
            showShortUser(users.get(i), space);
        }
    }

    static public void showMessageList(ArrayList<Message> messages, int start, int limit) {
        limit = Math.min(messages.size()-start,limit);
        Collections.sort(messages);
        for (int i = start; i < start + limit; i++) {
            showMessage(messages.get(i));
        }
    }

    static public void showPostList(ArrayList<Post> posts, int start, int limit, int space) {
        limit = Math.min(posts.size()-start,limit);
        Collections.sort(posts);
        for (int i = start; i < start + limit; i++) {
            showShortPost(posts.get(i), space);
        }
    }

    static public void showCommentList(ArrayList<Comment> comments, int start, int limit, int space) {
        Collections.sort(comments);
        limit = Math.min(comments.size()-start,limit);
        for (int i = start; i < start + limit; i++) {
            showShortComment(comments.get(i), space);
        }
    }

    static public void showUserFollowers(User u){
        printLine();
        showShortUser(u,0);
        printLine();
        showUserList(u.getFollowers(),0,5,1);
    }

    static public void showUserFollowings(User u){
        printLine();
        showShortUser(u,0);
        printLine();
        showUserList(u.getFollowings(),0,5,1);
    }

}
