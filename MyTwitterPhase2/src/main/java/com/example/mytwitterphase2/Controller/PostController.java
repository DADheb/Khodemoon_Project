package com.example.mytwitterphase2.Controller;

import com.example.mytwitterphase2.entity.Comment;
import com.example.mytwitterphase2.entity.Like;
import com.example.mytwitterphase2.entity.Post;
import com.example.mytwitterphase2.entity.User;

import java.time.Clock;
import java.time.LocalDate;

public class PostController {
    public static void newLike(Post p, Like l) {
        p.getLikes().add(l);
        p.getUserLikes().add(l.getUser());
        p.setNumberOfLikes(p.getNumberOfLikes() + 1);
        likeD(p);
    }

    public static void newView(Post p, User u) {
        p.getViewers().add(u);
        p.setNumberOfView(p.getNumberOfView() + 1);
        viewD(p);
    }

    public static void newComment(Post p, Comment c) {
        p.getComments().add(c);
    }

    public static void setTime(Post p) {
        p.setTime((int) (Clock.systemUTC().millis()));
        p.setDate(Clock.systemUTC().toString());
    }

    public static void disLike(Post p, Like l) {
        p.getLikes().remove(l);
        p.getUserLikes().remove(l.getUser());
        p.setNumberOfLikes(p.getNumberOfLikes() - 1);
        unLikeD(p);
    }

    public static void deleteComment(Post p, Comment c) {
        p.getComments().remove(c);
    }

    public static void editText(Post p, String nText) {
        p.setText(nText);
        p.setEdited(true);
        p.setDate(Clock.systemUTC().toString());
    }

    public static void viewD(Post p){
        if(p.getViewPD().keySet().contains(LocalDate.now().toString())){
            p.getViewPD().replace(LocalDate.now().toString(),p.getViewPD().get(LocalDate.now().toString())+1);
        } else {
            p.getViewPD().put(LocalDate.now().toString(),1);
        }
    }

    public static void likeD(Post p){
        if(p.getLikePD().keySet().contains(LocalDate.now().toString())){
            p.getLikePD().replace(LocalDate.now().toString(),p.getLikePD().get(LocalDate.now().toString())+1);
        } else {
            p.getLikePD().put(LocalDate.now().toString(),1);
        }
    }

    public static void unLikeD(Post p){
        if(p.getLikePD().keySet().contains(LocalDate.now().toString())){
            p.getLikePD().replace(LocalDate.now().toString(),p.getLikePD().get(LocalDate.now().toString())-1);
        } else {
            p.getLikePD().put(LocalDate.now().toString(),-1);
        }
    }
}
