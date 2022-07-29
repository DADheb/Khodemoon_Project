package entity;

import java.util.ArrayList;

public class Message implements Comparable<Message>{
    private User user;
    private String text;
    private boolean type;
    private Chat chat;
    private Group group;
    private boolean reply = false;
    private Message message;
    private boolean edited = false;
    private boolean seen = false;
    private long time;
    private String date;
    private ArrayList<Message> replyOn = new ArrayList<>();
    private boolean forwarded = false;
    private User forwarder;

    public Message(User user, String text, boolean type, Group group) {
        this.user = user;
        this.text = text;
        this.type = type;
        this.group = group;
    }

    public Message(User user, String text, boolean type, Chat chat) {
        this.user = user;
        this.text = text;
        this.type = type;
        this.chat = chat;
    }

    public Message(User user, String text, boolean type, Chat chat, boolean reply, Message message) {
        this.user = user;
        this.text = text;
        this.type = type;
        this.chat = chat;
        this.reply = reply;
        this.message = message;
    }

    public Message(User user, String text, boolean type, Group group, boolean reply, Message message) {
        this.user = user;
        this.text = text;
        this.type = type;
        this.group = group;
        this.reply = reply;
        this.message = message;
    }

    public Message(User user, String text, boolean type, Group group, boolean reply, Message message, boolean edited, boolean seen, long time) {
        this.user = user;
        this.text = text;
        this.type = type;
        this.group = group;
        this.reply = reply;
        this.message = message;
        this.edited = edited;
        this.time = time;
        this.seen=seen;
    }

    public Message(User user, String text, boolean type, Chat chat, boolean reply, Message message, boolean edited, boolean seen, long time) {
        this.user = user;
        this.text = text;
        this.type = type;
        this.chat = chat;
        this.reply = reply;
        this.message = message;
        this.edited = edited;
        this.time = time;
        this.seen=seen;
    }

    public Message() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Message> getReplyOn() {
        return replyOn;
    }

    public void setReplyOn(ArrayList<Message> replyOn) {
        this.replyOn = replyOn;
    }

    public boolean isForwarded() {
        return forwarded;
    }

    public void setForwarded(boolean forwarded) {
        this.forwarded = forwarded;
    }

    public User getForwarder() {
        return forwarder;
    }

    public void setForwarder(User forwarder) {
        this.forwarder = forwarder;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public int compareTo(Message o) {
        return -Long.compare(this.time,o.getTime());
    }
}
