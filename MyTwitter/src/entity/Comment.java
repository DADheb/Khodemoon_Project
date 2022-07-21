package entity;

import java.util.ArrayList;

public class Comment {
    private User user ;
    private String text;
    private boolean type;
    private Post post;
    private Comment comment;
    private int time;
    private String date;
    private boolean edited = false;
    private int numberOfView = 0;
    private int numberOfLikes = 0;
    private ArrayList<User> viewers = new ArrayList<>();
    private ArrayList<Like> likes = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();

    public Comment(User user, String text, boolean type, Post post) {
        this.user = user;
        this.text = text;
        this.type = type;
        this.post = post;
    }

    public Comment(User user, String text, boolean type, Comment comment) {
        this.user = user;
        this.text = text;
        this.type = type;
        this.comment = comment;
    }

    public Comment(User user, String text, boolean type, Comment comment, int time, String date, boolean edited, int numberOfView, int numberOfLikes) {
        this.user = user;
        this.text = text;
        this.type = type;
        this.comment = comment;
        this.time = time;
        this.date = date;
        this.edited = edited;
        this.numberOfView = numberOfView;
        this.numberOfLikes = numberOfLikes;
    }

    public Comment(User user, String text, boolean type, Post post, int time, String date, boolean edited, int numberOfView, int numberOfLikes) {
        this.user = user;
        this.text = text;
        this.type = type;
        this.post = post;
        this.time = time;
        this.date = date;
        this.edited = edited;
        this.numberOfView = numberOfView;
        this.numberOfLikes = numberOfLikes;
    }

    public Comment() {
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
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