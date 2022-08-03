package com.example.settings.Models;

import com.example.settings.Main;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class User implements Comparable<User>{
    private String userName;
    private String password;
    private String bio;
    private String name;
    private String lastName;
    private String birthday;
    private String email;
    private String date;
    private String securityQuestionsAnswers;
    private boolean privacy=false;
    private boolean userType;
    private int numberOfPosts=0;
    private int numberOfFollowers=0;
    private int numberOfFollowings=0;

    //private String profileImageURL

    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<User> followings = new ArrayList<>();
    //    private ArrayList<Post> posts = new ArrayList<>();
//    private ArrayList<Group> groups = new ArrayList<>();
//    private ArrayList<Chat> chats = new ArrayList<>();
    private ArrayList<User> followRequests = new ArrayList<>();
    private ArrayList<User> requests = new ArrayList<>();
    private ArrayList<User> block = new ArrayList<>();
    private HashMap<String,Integer> viewPD = new HashMap<String,Integer>();
    private HashMap<User,Integer> interest = new HashMap<User,Integer>();
    private HashMap<User,Integer> interestAD = new HashMap<User,Integer>();

    public Image getProfileImage() {
        return profileImage;
    }

    private Image profileImage = new Image(Objects.requireNonNull(Main.class.getResource("UserProfWhite.png")).toExternalForm());


    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, String bio, String name, String lastName, String birthday, String email, String securityQuestionsAnswers, Boolean privacy, Boolean userType) {
        this.userName = userName;
        this.password = password;
        this.bio = bio;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.securityQuestionsAnswers = securityQuestionsAnswers;
        this.privacy = privacy;
        this.userType = userType;
    }

    public User(String userName, String password, String bio, String name, String lastName, String birthday, String email, String securityQuestionsAnswers, Boolean privacy, Boolean userType, int numberOfPosts, int numberOfFollowers, int numberOfFollowings) {
        this.userName = userName;
        this.password = password;
        this.bio = bio;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.securityQuestionsAnswers = securityQuestionsAnswers;
        this.privacy = privacy;
        this.userType = userType;
        this.numberOfPosts = numberOfPosts;
        this.numberOfFollowers = numberOfFollowers;
        this.numberOfFollowings = numberOfFollowings;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    public HashMap<User, Integer> getInterestAD() {
        return interestAD;
    }

    public void setInterestAD(HashMap<User, Integer> interestAD) {
        this.interestAD = interestAD;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<User> getBlock() {
        return block;
    }

    public void setBlock(ArrayList<User> block) {
        this.block = block;
    }

    public HashMap<User, Integer> getInterest() {
        return interest;
    }

    public void setInterest(HashMap<User, Integer> interest) {
        this.interest = interest;
    }

    public HashMap<String, Integer> getViewPD() {
        return viewPD;
    }

    public void setViewPD(HashMap<String, Integer> viewPD) {
        this.viewPD = viewPD;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public boolean isUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

    public ArrayList<User> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<User> requests) {
        this.requests = requests;
    }

    public String getUserName() {
        return userName;
    }

//    public ArrayList<Chat> getChats() {
//        return chats;
//    }

    public String getPassword() {
        return password;
    }

    public String getBio() {
        return bio;
    }

    public Boolean getPrivacy() {
        return privacy;
    }

    public String getName() {
        return name;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
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

    public void setSecurityQuestionsAnswers(String securityQuestionsAnswers) {
        this.securityQuestionsAnswers = securityQuestionsAnswers;
    }

    public void setNumberOfPosts(int numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public void setNumberOfFollowers(int numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public void setNumberOfFollowings(int numberOfFollowings) {
        this.numberOfFollowings = numberOfFollowings;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public void setFollowings(ArrayList<User> followings) {
        this.followings = followings;
    }

//    public void setPosts(ArrayList<Post> posts) {
//        this.posts = posts;
//    }
//
//    public void setGroups(ArrayList<Group> groups) {
//        this.groups = groups;
//    }
//
//    public void setChats(ArrayList<Chat> chats) {
//        this.chats = chats;
//    }

    public void setFollowRequests(ArrayList<User> followRequests) {
        this.followRequests = followRequests;
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

    public String getSecurityQuestionsAnswers() {
        return securityQuestionsAnswers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public int getNumberOfFollowings() {
        return numberOfFollowings;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public ArrayList<User> getFollowings() {
        return followings;
    }
//
//    public ArrayList<Post> getPosts() {
//        return posts;
//    }
//
//    public ArrayList<Group> getGroups() {
//        return groups;
//    }

    public Boolean getUserType() {
        return userType;
    }

    public ArrayList<User> getFollowRequests() {
        return followRequests;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.numberOfFollowers,o.numberOfFollowers);
    }
}
