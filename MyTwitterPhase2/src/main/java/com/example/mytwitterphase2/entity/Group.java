package com.example.mytwitterphase2.entity;

import com.example.mytwitterphase2.MainGraphic;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Objects;

public class Group {
    private String name;
    private String bio;
    private User creator;
    private String creatDate;
    private ArrayList<Message> messages = new ArrayList<>();
    private ArrayList<User> members = new ArrayList<>();
    private ArrayList<User> admins = new ArrayList<>();
    private ArrayList<User> bans = new ArrayList<>();

    private Image profileImage = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/GroupProfWhite.png")).toExternalForm());

    public Group(String name, String bio, User creator) {
        this.name = name;
        this.bio = bio;
        this.creator = creator;
    }

    public Group(String name, User creator) {
        this.name = name;
        this.creator = creator;
    }

    public Group() {
    }

    public Image getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Image profileImage) {
        this.profileImage = profileImage;
    }

    public ArrayList<User> getBans() {
        return bans;
    }

    public void setBans(ArrayList<User> bans) {
        this.bans = bans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public ArrayList<User> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<User> admins) {
        this.admins = admins;
    }
}
