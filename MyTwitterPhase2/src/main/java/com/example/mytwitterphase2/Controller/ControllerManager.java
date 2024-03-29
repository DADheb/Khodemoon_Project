package com.example.mytwitterphase2.Controller;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.entity.*;

import java.time.LocalDate;

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
    static public Post post(User a,String text,int type){
        Post p = new Post(a,text);
        PostController.setTime(p);
        p.setPostType(type);
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
        DataBase.getUserNames().add(user.getUserName());
        DataBase.getUserPasswords().add(user.getPassword());
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
    static public Post getMother(Comment comment){
        if(comment.isType()){
            return comment.getPost();
        }
        return getMother(comment.getComment());
    }

    static public int getGrade(Group g,User u){
        if(g.getBans().contains(u)){
            return 3;
        }
        if(g.getCreator().equals(u)){
            return 1;
        }
        if (g.getAdmins().contains(u)){
            return 2;
        }
        if (g.getMembers().contains(u)){
            return 0;
        }
        return -1;
    }
    static public Group newGroup(User u,String name){
        Group group = new Group();
        group.setCreator(u);
        group.setCreatDate(LocalDate.now().toString());
        group.getMembers().add(u);
        group.getAdmins().add(u);
        group.setName(name);
        DataBase.getGroups().add(group);
        messageOnGroup(u,"creat "+group.getName()+" group",group);
        return group;
    }
    static public void deleteGroup(Group g){
        for (User u : g.getMembers()){
            GroupController.removeMember(g,u);
        }
        for (Message m : g.getMessages()){
            GroupController.deleteMessage(g,m);
        }
        DataBase.getGroups().remove(g);
    }
    static public Chat newChat(User u,User a){
        Chat chat = new Chat(u,a);
        UserController.newChat(u,chat);
        UserController.newChat(a,chat);
        DataBase.getChats().add(chat);
        messageOnChat(u,"start chat with "+a.getUserName(),chat);
        return chat;
    }
    static public void deleteChat(Chat chat){
        for (User u : chat.getUsers()){
            UserController.deleteChat(u,chat);
        }
        for (Message m : chat.getMessages()){
            ChatController.deleteMessage(chat,m);
        }
        DataBase.getChats().remove(chat);
    }
    static public User getMessageUser(Message message){
        if(message.isForwarded()){
            return message.getForwarder();
        }
        return message.getUser();
    }
    static public User getSecUserChat(Chat chat){
        for (User u : chat.getUsers()){
            if(!u.equals(DataBase.getUser())){
                return u;
            }
        }
        return new User();
    }
}
