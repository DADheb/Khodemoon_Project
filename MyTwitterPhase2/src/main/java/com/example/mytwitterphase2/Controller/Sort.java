package com.example.mytwitterphase2.Controller;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.entity.Chat;
import com.example.mytwitterphase2.entity.Group;

import java.util.ArrayList;
import java.util.Collections;

public class Sort {
    public static ArrayList<ChatAndGroup> sortChatGroup(){
        ArrayList<ChatAndGroup> chatAndGroups = new ArrayList<>();
        for (Chat chat : DataBase.getUser().getChats()){
            chatAndGroups.add(new ChatAndGroup(chat));
        }
        for (Group group : DataBase.getUser().getGroups()){
            chatAndGroups.add(new ChatAndGroup(group));
        }
        Collections.sort(chatAndGroups);
        return chatAndGroups;
    }
}
class ChatAndGroup implements Comparable<ChatAndGroup>{
    private int type;
    private Chat chat;
    private Group group;
    private Long time;

    public ChatAndGroup(Chat chat) {
        this.chat = chat;
        Collections.sort(chat.getMessages());
        this.time = chat.getMessages().get(0).getTime();
        this.type = 1;
    }

    public ChatAndGroup(Group group) {
        this.group = group;
        Collections.sort(group.getMessages());
        this.time = group.getMessages().get(0).getTime();
        this.type = 0;
    }

    public int getType() {
        return type;
    }

    public Chat getChat() {
        return chat;
    }

    public Group getGroup() {
        return group;
    }

    public Long getTime() {
        return time;
    }

    @Override
    public int compareTo(ChatAndGroup o) {
        return -Long.compare(this.time,o.time);
    }
}