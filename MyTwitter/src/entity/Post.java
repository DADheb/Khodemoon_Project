package entity;

import java.util.ArrayList;

public class Post {
    private User user;
    private String text;
    private int time;
    private String date;
    private boolean edited = false;
    private int numberOfView = 0;
    private int numberOfLikes = 0;
    private ArrayList<User> viewers = new ArrayList<>();
    private ArrayList<Like> likes = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();

    public Post(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Post(User user, String text, int time, String date, boolean edited, int numberOfView, int numberOfLikes) {
        this.user = user;
        this.text = text;
        this.time = time;
        this.date = date;
        this.edited = edited;
        this.numberOfView = numberOfView;
        this.numberOfLikes = numberOfLikes;
    }

    public Post() {
    }

    public User getUser() {
        return user;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getEdited() {
        return edited;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }

    public int getNumberOfView() {
        return numberOfView;
    }

    public void setNumberOfView(int numberOfView) {
        this.numberOfView = numberOfView;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public ArrayList<User> getViewers() {
        return viewers;
    }

    public void setViewers(ArrayList<User> viewers) {
        this.viewers = viewers;
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
