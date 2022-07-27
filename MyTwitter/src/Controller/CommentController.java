package Controller;

import entity.Comment;
import entity.Like;
import entity.User;

import java.time.Clock;
import java.time.LocalDateTime;


public class CommentController {
    public static void newLike(Comment c, Like l){
        c.getLikes().add(l);
        c.getUserLikes().add(l.getUser());
        c.setNumberOfLikes(c.getNumberOfLikes()+1);
    }
    public static void newView(Comment c, User u){
        c.setNumberOfView(c.getNumberOfView()+1);
    }
    public static void newComment(Comment c, Comment cc){
        c.getComments().add(cc);
    }
    public static void setTime(Comment c){
        c.setTime(Clock.systemUTC().millis());
        c.setDate(LocalDateTime.now().toString());
    }
    public static void disLike(Comment c, Like l){
        c.getLikes().remove(l);
        c.getUserLikes().remove(l.getUser());
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
