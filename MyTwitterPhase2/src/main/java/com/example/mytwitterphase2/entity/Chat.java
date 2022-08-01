package com.example.mytwitterphase2.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Chat {
    private Set<User> users = new HashSet<>();
    private ArrayList<Message> messages = new ArrayList<>();

    public Chat(User a, User b) {
        users.add(a);
        users.add(b);
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
