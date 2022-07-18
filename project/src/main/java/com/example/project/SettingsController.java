package com.example.project;

import com.example.project.Models.DataBase;
import com.example.project.Models.User;

public class SettingsController {
    public static User getUserByUsername(String username) {
        for (User allUser : DataBase.getAllUsers()) {
            if (allUser.getUserName().equals(username)) {
                return allUser;
            }
        }
        return null;
    }

    public static void editUsername(String newUsername, String myUsername) {
        getUserByUsername(myUsername).setUserName(newUsername);
        return;
    }

    public static void editPassword(String newPassword, String myUsername){
        getUserByUsername(myUsername).setPassword(newPassword);
        return;
    }

    public static void editName(String newName, String myUsername){
        getUserByUsername(myUsername).setName(newName);
        return;
    }

    public static void editLastname(String newLastName, String myUsername){
        getUserByUsername(myUsername).setLastName(newLastName);
        return;
    }

    public static void editBio(String newBio, String myUsername){
        getUserByUsername(myUsername).setBio(newBio);
        return;
    }

    public static void editEmail (String newEmail, String myUsername){
        getUserByUsername(myUsername).setEmail(newEmail);
        return;
    }

    public static void editBirthday(String newBirthday, String myUsername){
        getUserByUsername(myUsername).setBirthday(newBirthday);
        return;
    }
}
