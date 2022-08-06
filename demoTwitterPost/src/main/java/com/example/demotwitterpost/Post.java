package com.example.demotwitterpost;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;

public class Post implements Comparable<Post>{
    private User user;
    private String text;
    private long time;
    private Image img;
    private String date;
    private boolean edited = false;
    private int postType = 0;
    private int numberOfView = 0;
    private int numberOfLikes = 0;
    private ArrayList<User> viewers = new ArrayList<>();
    private ArrayList<Like> likes = new ArrayList<>();
    private ArrayList<User> userLikes = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();
    private HashMap<String,Integer> likePD = new HashMap<String,Integer>();
    private HashMap<String,Integer> viewPD = new HashMap<String,Integer>();

    public Post(User user, String text, int postType) {
        this.user = user;
        this.text = text;
        this.postType = postType;
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

    public ArrayList<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(ArrayList<User> userLikes) {
        this.userLikes = userLikes;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Image getImg() {
        return img;
    }

    public HashMap<String, Integer> getLikePD() {
        return likePD;
    }

    public void setLikePD(HashMap<String, Integer> likePD) {
        this.likePD = likePD;
    }

    public HashMap<String, Integer> getViewPD() {
        return viewPD;
    }

    public void setViewPD(HashMap<String, Integer> viewPD) {
        this.viewPD = viewPD;
    }

    public User getUser() {
        return user;
    }

    public int getPostType() {
        return postType;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
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

    @Override
    public int compareTo(Post o) {
        return -Long.compare(this.time,o.getTime());
    }
}
