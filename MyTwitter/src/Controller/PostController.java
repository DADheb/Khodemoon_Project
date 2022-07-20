package Controller;

import entity.Comment;
import entity.Like;
import entity.Post;
import entity.User;

import java.time.Clock;

public class PostController {
    public static void newLike(Post p, Like l){
        p.getLikes().add(l);
        p.setNumberOfLikes(p.getNumberOfLikes()+1);
    }
    public static void newView(Post p, User u){
        p.getViewers().add(u);
        p.setNumberOfView(p.getNumberOfView()+1);
    }
    public static void newComment(Post p, Comment c){
        p.getComments().add(c);
    }
    public static void setTime(Post p){
        p.setTime((int) (Clock.systemUTC().millis()));
        p.setDate(Clock.systemUTC().toString());
    }
    public static void disLiki(Post p, Like l){
        p.getLikes().remove(l);
        p.setNumberOfLikes(p.getNumberOfLikes()-1);
    }
    public static void deleteComment(Post p, Comment c){
        p.getComments().remove(c);
    }
    public static void editText(Post p,String nText){
        p.setText(nText);
        p.setEdited(true);
        p.setDate(Clock.systemUTC().toString());
    }
}
