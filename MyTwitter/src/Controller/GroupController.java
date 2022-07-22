package Controller;

import entity.Group;
import entity.Message;
import entity.User;

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
    }
    static public void removeMember(Group g, User u){
        g.getMembers().remove(u);
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
