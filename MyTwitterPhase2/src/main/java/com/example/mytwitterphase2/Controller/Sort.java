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
