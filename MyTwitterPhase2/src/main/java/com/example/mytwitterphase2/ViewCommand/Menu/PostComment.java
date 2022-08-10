package com.example.mytwitterphase2.ViewCommand.Menu;

import com.example.mytwitterphase2.Controller.CommentController;
import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.Controller.PostController;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.ViewCommand.Show;
import com.example.mytwitterphase2.entity.Comment;
import com.example.mytwitterphase2.entity.Post;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PostComment {
    public static Scanner scan = DataBase.scanner;
    public static void editPost(Post post,int n) throws SQLException {
        System.out.println("Enter new text :");
        String text = Show.getString();
        PostController.editText(post,text);
        System.out.println("Done");
        System.out.println("Enter anything for back");
        scan.nextLine();
        Profile.showPost(post,n);
    }
    public static void editComment(Comment comment,int n) throws SQLException {
        System.out.println("Enter new text :");
        String text = Show.getString();
        CommentController.editText(comment,text);
        System.out.println("Done");
        System.out.println("Enter anything for back");
        scan.nextLine();
        Profile.showComment(comment,n);
    }
    public static void deletePost(Post post,int n) throws SQLException {
        Show.printLine();
        System.out.println("Are you sure ?");
        System.out.println("1) YES");
        System.out.println("2) NO and back to post");
        switch (Show.inputProcessor(1,2)){
            case 1 :
                ControllerManager.deletePost(post);
                System.out.println("Done");
                System.out.println("Enter anything for back to profile");
                scan.nextLine();
                Profile.showProfileMenu();
                break;
            case 2 : Profile.showPost(post,n);
                break;
        }
    }
    public static void creatComment(Post post,int n) throws SQLException {
        System.out.println("Enter text :");
        String text = Show.getString();
        ControllerManager.commentOnPost(DataBase.getUser(),text,post);
        System.out.println("Done");
        System.out.println("Enter anything for back");
        scan.nextLine();
        Profile.showPost(post,n);
    }
    public static void creatComment(Comment comment,int n) throws SQLException {
        System.out.println("Enter text :");
        String text = Show.getString();
        ControllerManager.commentOnComment(DataBase.getUser(),text,comment);
        System.out.println("Done");
        System.out.println("Enter anything for back");
        scan.nextLine();
        Profile.showComment(comment,n);
    }
    public static void seeLike(Post post,int n) throws SQLException {
        Show.printLine();
        Show.showUserList(post.getUserLikes(),0,10,0);
        System.out.println("Choose one of the options below:");
        System.out.println("1) See some user");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 : Profile.selectUser(4+n);
                break;
            case 2 : Profile.showPost(post,n);
                break;
        }
    }
    public static void seeLike(Comment comment,int n) throws SQLException {
        Show.printLine();
        Show.showUserList(comment.getUserLikes(),0,10,0);
        System.out.println("Choose one of the options below:");
        System.out.println("1) See some user");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 : Profile.selectUser(4+n);
                break;
            case 2 : Profile.showComment(comment,n);
                break;
        }
    }
    public static void deleteComment(Comment comment,int n) throws SQLException {
        Show.printLine();
        System.out.println("Are you sure ?");
        System.out.println("1) YES");
        System.out.println("2) NO and back to post");
        switch (Show.inputProcessor(1,2)){
            case 1 :
                if(comment.isType()){
                    ControllerManager.deleteCommentP(comment.getPost(),comment);
                } else {
                    ControllerManager.deleteCommentC(comment.getComment(),comment);
                }
                System.out.println("Done");
                System.out.println("Enter anything for back");
                scan.nextLine();
                if(comment.isType()){
                    Profile.showPost(comment.getPost(),n);
                } else {
                    Profile.showComment(comment.getComment(),n);
                }
                break;
            case 2 : Profile.showComment(comment,n);
                break;
        }
    }
    public static void seePD(Post post,int n) throws SQLException {
        Show.printLine();
        ArrayList<String> all = new ArrayList<>();
        all.addAll(post.getLikePD().keySet());
        all.addAll(post.getViewPD().keySet());
        Collections.sort(all);
        for (String s : all){
            if(post.getLikePD().containsKey(s) && post.getViewPD().containsKey(s)){
                System.out.println("Date : " + s + ", number of like : " + post.getLikePD().get(s)+", number of view : "+ post.getViewPD().get(s));
            } else if(post.getLikePD().containsKey(s)){
                System.out.println("Date : " + s + ", number of like : " + post.getLikePD().get(s));
            } else {
                System.out.println("Date : " + s + ", number of view : " + post.getViewPD().get(s));
            }
        }
        Show.printLine();
        System.out.println("Enter anything for back");
        scan.nextLine();
        Profile.showPost(post,n);
    }

}
