package com.example.project.Models;

import java.util.ArrayList;

public static class DataBase {
    public static ArrayList<User> allUsers;


    public void addUser(User user) {
        allUsers.add(user);
    }

    public void removeUser(User user) {
        allUsers.remove(user);
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

}
