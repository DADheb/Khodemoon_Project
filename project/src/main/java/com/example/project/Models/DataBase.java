package com.example.project.Models;

import java.util.ArrayList;

public class DataBase {
    public static ArrayList<User> allUsers;


    public static void addUser(User user) {
        allUsers.add(user);
    }

    public static void removeUser(User user) {
        allUsers.remove(user);
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

}
