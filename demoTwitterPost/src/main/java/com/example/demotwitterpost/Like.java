package com.example.demotwitterpost;

public class Like {
    private User user ;
    private boolean type;
    private Comment comment;
    private Post post ;

    public Like(User user, boolean type, Post post) {
        this.user = user;
        this.type = type;
        this.post = post;
    }

    public Like(User user, boolean type, Comment comment) {
        this.user = user;
        this.type = type;
        this.comment = comment;
    }

    public Like() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
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
}