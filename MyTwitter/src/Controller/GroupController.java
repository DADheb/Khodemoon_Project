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
    }
    static public void deleteMessage(Group g, Message m){
        g.getMessages().remove(m);
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
}
