package com.example.mytwitterphase2.Controller;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.entity.Group;
import com.example.mytwitterphase2.entity.Message;
import com.example.mytwitterphase2.entity.User;

public class GroupController {
    static public void newMessage(Group g, Message m){
        g.getMessages().add(m);
    }
    static public void newAdmin(Group g, User u){
        g.getAdmins().add(u);
        g.getBans().remove(u);
    }
    static public void deleteMessage(Group g, Message m){
        g.getMessages().remove(m);
        DataBase.getMessages().remove(m);
    }
    static public void deleteAllMessageOfUser(Group g,User u){
        for (Message m : g.getMessages()){
            if(m.getUser().equals(u)){
                if(!m.isForwarded()){
                    deleteMessage(g,m);
                }
            }
            if(m.isForwarded()){
                if(m.getForwarder().equals(u)){
                    deleteMessage(g,m);
                }
            }
        }
    }
    static public void removeAdmin(Group g, User u){
        g.getAdmins().remove(u);
    }
    static public void newMember(Group g, User u){
        g.getMembers().add(u);
        ControllerManager.messageOnGroup(DataBase.getUser(),"add "+u.getUserName(),g);
        UserController.newGroup(u,g);
    }
    static public void removeMember(Group g, User u){
        g.getMembers().remove(u);
        g.getAdmins().remove(u);
        g.getBans().remove(u);
        ControllerManager.messageOnGroup(DataBase.getUser(),"remove "+u.getUserName(),g);
        UserController.deleteGroup(u,g);
    }
    static public void changeBio(Group g, String bio){
        g.setBio(bio);
    }
    static public void changeName(Group g, String name){
        g.setName(name);
    }
    static public void banUser(Group g,User u){
        g.getAdmins().remove(u);
        g.getBans().add(u);
    }
    static public void unBanUser(Group g,User u){
        g.getBans().remove(u);
    }
}
