package com.example.project.Models;

import java.util.ArrayList;

public class User {
    // etelaate karbar
    private int id;
    private String userName;
    private String password;
    private String bio;
    private String profilePhoto; // bara grafik    haminjoori zadam string
    private String name;
    private String lastName;
    private String birthday;
    private String email;
    private ArrayList<String> securityQuestionsAnswers = new ArrayList<>();

    // mishe bashe mishe nabashe
    private int numberOfPosts;
    private int numberOfFollowers;
    private int numbaerOfFollowings;

    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<User> followings = new ArrayList<>();
    //private ArrayList<Post> posts = new ArrayList<>();
    //private Arraylist<Message> messages = new Arraylist<>();
    //private ArrayList<Like> likes = new Arraylist<>();
    //private ArrayList<Group> groups = new ArrayList<>();
    //private ArrayList<Comment> comments = new ArrayList<>();

    private String userType;
    private ArrayList<User> followRequests = new ArrayList<>();

    //other methods


    //constructors
    public User(int id, String userName, String password, String bio, String profilePhoto, String name, String lastName, String birthday, String email, ArrayList<String> securityQuestionsAnswers, String userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.bio = bio;
        this.profilePhoto = profilePhoto;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.securityQuestionsAnswers = securityQuestionsAnswers;
        this.userType = userType;
    }

    public User() {
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSecurityQuestionsAnswers(ArrayList<String> securityQuestionsAnswers) {
        this.securityQuestionsAnswers = securityQuestionsAnswers;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    //getter
    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getBio() {
        return bio;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getSecurityQuestionsAnswers() {
        return securityQuestionsAnswers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public int getNumbaerOfFollowings() {
        return numbaerOfFollowings;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public ArrayList<User> getFollowings() {
        return followings;
    }

    public String getUserType() {
        return userType;
    }

    public ArrayList<User> getFollowRequests() {
        return followRequests;
    }



}

