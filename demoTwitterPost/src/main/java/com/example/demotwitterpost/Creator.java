package com.example.demotwitterpost;

public class Creator {
    static Double scale = 1.0;
    static Post post;
    static Comment comment;
    static int type = 0;

    public static void setType(int type) {
        Creator.type = type;
    }

    public static void setPost(Post post) {
        Creator.post = post;
    }

    public static void setComment(Comment comment) {
        Creator.comment = comment;
    }
}
