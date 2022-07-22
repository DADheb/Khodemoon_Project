package Controller;

import DataBase.DataBase;
import entity.*;

public class ControllerManager {
    static public void likeP(User a, Post p){
        Like l = new Like(a,true,p);
        DataBase.getLikes().add(l);
        PostController.newLike(p,l);
        UserController.interestLike(p.getUser(),a);
    }
    static public void dislikeP(User a, Post p){
        Like l = p.getLikes().get(p.getUserLikes().indexOf(a));
        PostController.disLike(p,l);
        DataBase.getLikes().remove(l);
        UserController.interestDislike(p.getUser(),a);
    }
    static public void likeC(User a, Comment c){
        Like l = new Like(a,false,c);
        DataBase.getLikes().add(l);
        CommentController.newLike(c,l);
        UserController.interestLike(c.getUser(),a);
    }
    static public void dislikeC(User a, Comment c){
        Like l = c.getLikes().get(c.getUserLikes().indexOf(a));
        CommentController.disLike(c,l);
        DataBase.getLikes().remove(l);
        UserController.interestDislike(c.getUser(),a);
    }
    static public void commentP(Post p, Comment c){
        PostController.newComment(p,c);
        UserController.interestComment(p.getUser(),c.getUser());
    }
    static public void commentC(Comment comment, Comment c){
        CommentController.newComment(comment,c);
        UserController.interestComment(comment.getUser(),c.getUser());
    }
    static public void deleteCommentP(Post p, Comment c){
        PostController.deleteComment(p,c);
        UserController.interestDeleteComment(p.getUser(),c.getUser());
        for (Comment cc : c.getComments()){
            deleteCommentC(c,cc);
        }
        DataBase.getComments().remove(c);
    }
    static public void deleteCommentC(Comment comment, Comment c){
        CommentController.deleteComment(comment,c);
        UserController.interestDeleteComment(comment.getUser(),c.getUser());
        for (Comment cc : c.getComments()){
            deleteCommentC(c,cc);
        }
        for (Like l : c.getLikes()){
            dislikeC(l.getUser(),c);
        }
        DataBase.getComments().remove(c);
    }
    static public void deletePost(Post p){
        for (Comment c : p.getComments()){
            deleteCommentP(p,c);
        }
        for (Like l : p.getLikes()){
            dislikeP(l.getUser(),p);
        }
        UserController.deletePost(p.getUser(),p);
        DataBase.getPosts().remove(p);
    }
    static public Post post(User a,String text){
        Post p = new Post(a,text);
        PostController.setTime(p);
        UserController.newPost(a,p);
        DataBase.getPosts().add(p);
        return p;
    }
    static public Comment commentOnComment(User a,String text,Comment comment){
        Comment c = new Comment(a,text,false,comment);
        CommentController.setTime(c);
        commentC(comment,c);
        DataBase.getComments().add(c);
        return c;
    }
    static public Comment commentOnPost(User a,String text,Post p){
        Comment c = new Comment(a,text,true,p);
        CommentController.setTime(c);
        commentP(p,c);
        DataBase.getComments().add(c);
        return c;
    }
    static public User newUserS(String userName,String password,boolean type){
        User user = new User(userName,password);
        UserController.setDate(user);
        user.setUserType(type);
        DataBase.getUsers().add(user);
        return user;
    }
    static public User newUser(String userName,String password,boolean type,String name,String lastname , String bio, String securityQuestionsAnswers,String birthDay,String email){
        User user = new User(userName,password,bio,name,lastname,birthDay,email,securityQuestionsAnswers,false,type);
        UserController.setDate(user);
        DataBase.getUsers().add(user);
        return user;
    }
    static public Message messageOnChat(User a,String text,Chat c){
        Message m = new Message(a,text,false,c);
        MessageController.setTime(m);
        ChatController.newMessage(c,m);
        DataBase.getMessages().add(m);
        return m;
    }
    static public Message messageReplyOnChat(User a,String text,Chat c,Message message){
        Message m = new Message(a,text,false,c,true,message);
        MessageController.replyOn(message,m);
        MessageController.setTime(m);
        ChatController.newMessage(c,m);
        DataBase.getMessages().add(m);
        return m;
    }
    static public Message messageOnGroup(User a,String text,Group g){
        Message m = new Message(a,text,true,g);
        MessageController.setTime(m);
        GroupController.newMessage(g,m);
        DataBase.getMessages().add(m);
        return m;
    }
    static public Message messageReplyOnGroup(User a,String text,Group g,Message message){
        Message m = new Message(a,text,true,g,true,message);
        MessageController.setTime(m);
        MessageController.replyOn(message,m);
        GroupController.newMessage(g,m);
        DataBase.getMessages().add(m);
        return m;
    }
    static public void forwardMessageToChat(User a,Message m,Chat c){
        Message message = MessageController.forwarded(a,m);
        message.setType(false);
        message.setChat(c);
        MessageController.setTime(message);
        ChatController.newMessage(c,message);
        DataBase.getMessages().add(message);
    }
    static public void forwardMessageToGroup(User a,Message m,Group g){
        Message message = MessageController.forwarded(a,m);
        message.setType(true);
        message.setGroup(g);
        MessageController.setTime(message);
        GroupController.newMessage(g,message);
        DataBase.getMessages().add(message);
    }
    
}
