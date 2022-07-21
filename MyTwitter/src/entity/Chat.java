package entity;

import java.util.ArrayList;

public class Chat {
    private User A;
    private User B;
    private ArrayList<Message> messages = new ArrayList<>();

    public Chat(User a, User b) {
        A = a;
        B = b;
    }

    public User getA() {
        return A;
    }

    public void setA(User a) {
        A = a;
    }

    public User getB() {
        return B;
    }

    public void setB(User b) {
        B = b;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
