package com.example.mytwitterphase2.ViewCommand;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.Controller.UserController;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

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
    public static int inputProcessor(int start, int end) {
        int inputNumber=0;
        while (true) {
            String input = scan.nextLine();
            if (input.length() == 0) {
                input = scan.nextLine();
            }
            try {
                inputNumber = Integer.parseInt(input.trim());
            } catch (Exception e){
                System.out.println("Invalid number!");
                System.out.println("Please choose again");
                continue;
            }
            if(inputNumber<=end && inputNumber>=start){
                return inputNumber;
            }
            System.out.println("Invalid number!");
            System.out.println("Please choose again");
        }
    }
    static public String getString(){
        while (true) {
            String input = scan.nextLine();
            if (input.length() != 0) {
                return input;
            }
        }
    }
    static public int getInt(){
        return scan.nextInt();
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
        showSpace(space);
        System.out.println("ID : "+DataBase.getUserID(u)+1);
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
            showPostList(u.getPosts(), 0,10, 1);
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
        ArrayList<User> users = new ArrayList<>(c.getUsers());
        if (users.get(0).equals(DataBase.getUser())) {
            printLine();
            showSpace(space);
            System.out.println("Chat with : " + users.get(1).getUserName());
            showSpace(space);
            System.out.println("ID : " + DataBase.getChats().indexOf(c)+1);
            printLine();
        } else if (users.get(1).equals(DataBase.getUser())) {
            printLine();
            showSpace(space);
            System.out.println("Chat with : " + users.get(0).getUserName());
            showSpace(space);
            System.out.println("ID : " + (DataBase.getChats().indexOf(c)+1));
            printLine();
        } else {
            System.out.println("invalid command");
            return;
        }
    }

    static public void showLongChat(Chat c) {
        ArrayList<User> users = new ArrayList<>(c.getUsers());
        if (users.get(0).equals(DataBase.getUser())) {
            printLine();
            System.out.println("Chat whit : " + users.get(1).getName() + " " + users.get(1).getLastName());
            System.out.println(users.get(1).getUserName());
            printLine();
            showMessageList(c.getMessages(), 0, 5);
        } else if (users.get(1).equals(DataBase.getUser())) {
            printLine();
            System.out.println("Chat whit : " +users.get(0).getName() + " " +users.get(0).getLastName());
            System.out.println(users.get(0).getUserName());
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
            case 3:
                System.out.println("Ban");
                break;
            case 1:
                System.out.println("Creator");
                break;
            case 2:
                System.out.println("Admin");
                break;
            case 0:
                System.out.println("Member");
                break;
            case -1 : System.out.println("Removed");
        }
        System.out.println("ID : "+DataBase.getUserID(member)+1);
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
                System.out.println(m.getUser().getUserName() + " :");
            }
        }
        if (m.isForwarded()) {
            System.out.println("Forwarded from " + m.getUser().getUserName());
        }
        if (m.isReply()) {
            System.out.println("Reply on : " + m.getMessage().getUser().getUserName() + " : " + m.getMessage().getText().substring(0, 50));
        }
        System.out.println(m.getText());
        System.out.println(m.getDate());
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
        for (int i = start; i < users.size(); i++) {
            showShortUser(users.get(i), space);
        }
    }

    static public void showMessageList(ArrayList<Message> messages, int start, int limit) {
        limit = Math.min(messages.size()-start,limit);
        Collections.sort(messages);
        for (int i = start; i < messages.size(); i++) {
            showMessage(messages.get(i));
        }
    }

    static public void showPostList(ArrayList<Post> posts, int start, int limit, int space) {
        limit = Math.min(posts.size()-start,limit);
        Collections.sort(posts);
        for (int i = start; i < posts.size(); i++) {
            showShortPost(posts.get(i), space);
        }
    }

    static public void showCommentList(ArrayList<Comment> comments, int start, int limit, int space) {
        Collections.sort(comments);
        limit = Math.min(comments.size()-start,limit);
        for (int i = start; i < comments.size(); i++) {
            showShortComment(comments.get(i), space);
        }
    }
    static public void showChatList(ArrayList<Chat> chats,int start,int limit,int space){
        limit = Math.min(chats.size()-start,limit);
        for (int i = start;i< chats.size();i++){
            showShortChat(chats.get(i),space);
        }
    }
    static public void showGroupList(ArrayList<Group> groups,int start,int limit,int space){
        limit = Math.min(groups.size()-start,limit);
        for (int i = start;i< groups.size();i++){
            showShortGroup(groups.get(i),space);
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
    static public void showAds(User u){
        Stream<Map.Entry<User, Integer>> sorted = u.getInterestAD().entrySet().stream().sorted(Map.Entry.comparingByValue());
        int size = u.getInterestAD().size();
        int limit = Math.min(size,5);
        ArrayList<Post> posts = new ArrayList<>();
        User[] users = (User[]) sorted.toArray();
        for (int i = size-1;i>=size-limit;i--){
            User user = users[i];
            for (Post p : user.getPosts()){
                if(!p.getUserLikes().contains(u)) {
                    posts.add(p);
                }
            }
        }
        limit = Math.min(posts.size(),5);
        ArrayList<Post> selectedPosts = new ArrayList<>();
        for (int i = 0 ; i<limit;i++){
            selectedPosts.add(posts.get(i));
        }
        Collections.sort(DataBase.getPosts());
        int number=0;
        for (Post p : DataBase.getPosts()){
            if(p.getUser().equals(u)){
                continue;
            }
            if(p.getUserLikes().contains(u)){
                continue;
            }
            if(posts.contains(p)){
                continue;
            }
            number++;
        }
        int n = Math.min(5 - limit,number);
        int i=0;
        while (n>0){
            Post p = DataBase.getPosts().get(i);
            if(p.getUser().equals(u)){
                i++;
                continue;
            }
            if(p.getUserLikes().contains(u)){
                i++;
                continue;
            }
            if(posts.contains(p)){
                i++;
                continue;
            }
            n--;
            selectedPosts.add(p);
        }
        showPostList(selectedPosts,0,10,0);
    }
    static public void showInterestUser(User u){
        Stream<Map.Entry<User, Integer>> sorted = u.getInterest().entrySet().stream().sorted(Map.Entry.comparingByValue());
        int size = u.getInterest().size();
        int limit = Math.min(size,5);
        User[] users = (User[]) sorted.toArray();
        ArrayList<User> selectedUsers = new ArrayList<>();
        for (int i=size-1;i>=size-limit;i--){
            selectedUsers.add(users[i]);
        }
        limit = Math.min(5-limit,DataBase.getUsers().size()-1-limit);
        Collections.sort(DataBase.getUsers());
        for (int i = 0 ; i<limit;i++){
            if(DataBase.getUsers().get(i).equals(u)){
                selectedUsers.add(DataBase.getUsers().get(limit));
            } else {
                selectedUsers.add(DataBase.getUsers().get(i));
            }
        }
        showUserList(selectedUsers,0,10,0);
    }
    static public void showAllCG(User u){
        showChatList(u.getChats(),0,10,1);
        showGroupList(u.getGroups(),0,10,1);
    }
    static public void checkAccept(int ID){
        if(ID>=DataBase.getUsers().size()){
            System.out.println("Invalid commands");
        }
        User u = DataBase.getUsers().get(ID -1);
        if(!DataBase.getUser().getFollowRequests().contains(u)){
            System.out.println("Invalid commands");
        } else {
            UserController.acceptRequest(u,DataBase.getUser());
            System.out.println("Done");
        }
    }
    static public void checkIgnore(int ID){
        if(ID>=DataBase.getUsers().size()){
            System.out.println("Invalid commands");
        }
        User u = DataBase.getUsers().get(ID -1);
        if(!DataBase.getUser().getFollowRequests().contains(u)){
            System.out.println("Invalid commands");
        } else {
            UserController.unRequest(u,DataBase.getUser());
            System.out.println("Done");
        }
    }
}
