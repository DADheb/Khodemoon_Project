package Controller;

import entity.Comment;
import entity.Like;
import entity.User;

import java.time.Clock;

public class CommentController {
    public static void newLike(Comment c, Like l){
        c.getLikes().add(l);
        c.setNumberOfLikes(c.getNumberOfLikes()+1);
    }
    public static void newView(Comment c, User u){
        c.getViewers().add(u);
        c.setNumberOfView(c.getNumberOfView()+1);
    }
    public static void newComment(Comment c, Comment cc){
        c.getComments().add(cc);
    }
    public static void setTime(Comment c){
        c.setTime((int) (Clock.systemUTC().millis()));
        c.setDate(Clock.systemUTC().toString());
    }
    public static void disLiki(Comment c, Like l){
        c.getLikes().remove(l);
        c.setNumberOfLikes(c.getNumberOfLikes()-1);
    }
    public static void deleteComment(Comment c, Comment cc){
        c.getComments().remove(cc);
    }
    public static void editText(Comment c,String nText){
        c.setText(nText);
        c.setEdited(true);
        c.setDate(Clock.systemUTC().toString());
    }
}
