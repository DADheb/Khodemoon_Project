package com.example.project;

import com.example.project.Models.DataBase;
import com.example.project.Models.User;

import java.util.regex.Matcher;

public class Controller {
    public static User getUserByUsername(String username){
        for (User allUser : DataBase.getAllUsers()) {
            if (allUser.getUserName().equals(username)){
                return allUser;
            }
        }
        return null;
    }

    public static String showProfile (String username){
        //String username = matcher.group("username");
        User user = getUserByUsername(username);
        if (user!=null) {
            String output = new String();
            output = "";
            //output += username; output +="\n";
            output += user.getName() + "\t" + user.getLastName() + "\n";
            output += user.getBio();
            output += "followers:" + user.getNumberOfFollowers() + "\tfollowings:" +user.getNumbaerOfFollowings() + "\tposts:"+ user.getNumberOfPosts();
            // show posts
            return output;
        }
        return "invalid input!";
    }

    public static String showFollowings (String username){
        User user = getUserByUsername(username);
        if (user!=null){
            String output = new String();
            output = "";
            for (User following : user.getFollowings()) {
                output += following.getUserName() + "\n";
            }
            return output.substring(0,output.length()-1);
        }
        return "invalid input!";
    }

    public static String showFollowers (String username){
        User user = getUserByUsername(username);
        if (user!=null){
            String output = new String();
            output = "";
            for (User follower : user.getFollowers()) {
                output += follower.getUserName() + "\n";
            }
            return output.substring(0,output.length()-1);
        }
        return "invalid input!";
    }


}
