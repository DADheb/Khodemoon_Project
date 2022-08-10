package com.example.mytwitterphase2.Controller;

import com.example.mytwitterphase2.entity.Chat;
import com.example.mytwitterphase2.entity.Group;

import java.util.Collections;

public class ChatAndGroup implements Comparable<ChatAndGroup> {
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
        return -Long.compare(this.time, o.time);
    }
}
