package View.Menu;

import Controller.ChatController;
import Controller.ControllerManager;
import DataBase.DataBase;
import View.Show;
import entity.Chat;
import entity.Group;
import entity.Message;
import entity.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ChatGroup {
    public static Scanner scan = DataBase.scanner;
    static public void showAll(){
        Show.showAllCG(DataBase.getUser());
        System.out.println("Choose one of the options below:");
        System.out.println("1) See some chat");
        System.out.println("2) See some Group");
        System.out.println("3) Creat new chat");
        System.out.println("4) Creat new group");
        System.out.println("5) Back");
        switch (Show.inputProcessor(1,5)){
            case 1 : selectChat();
            break;
            case 2 : selectGroup();
            break;
            case 3 : newChat();
            break;
            case 4 : newGroup();
            break;
            case 5 : Profile.showProfileMenu();
            break;
        }
    }
    static public void showGroup(Group group){
        Show.showLongGroup(group);
        System.out.println("Choose one of the options below:");
        System.out.println("1) Select message");
        System.out.println("2) Send new message");
        System.out.println("3) See group info");
        System.out.println("4) Back");
        switch (Show.inputProcessor(1,4)){
            case 1 : selectMessage();
                break;
            case 2 : creatMessage(group);
                break;
            case 3 : showGroupInfo(group);
                break;
            case 4 : showAll();
                break;
        }
    }
    static public void showChat(Chat chat){
        Show.showLongChat(chat);
        System.out.println("Choose one of the options below:");
        System.out.println("1) Select message");
        System.out.println("2) Send new message");
        System.out.println("3) Delete chat");
        System.out.println("4) Back");
        switch (Show.inputProcessor(1,4)){
            case 1 : selectMessage();
            break;
            case 2 : creatMessage(chat);
            break;
            case 3 : deleteChat(chat);
            break;
            case 4 : showAll();
            break;
        }
    }
    static public void creatMessage(Chat chat){
        ArrayList<User> users = new ArrayList<>(chat.getUsers());
        if(users.get(0).equals(DataBase.getUser())){
            if(users.get(1).getBlock().contains(DataBase.getUser())) {
                System.out.println("you are blocked");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showChat(chat);
            } else {
                System.out.println("Enter Message :");
                String text = Show.getString();
                ControllerManager.messageOnChat(DataBase.getUser(),text,chat);
                System.out.println("Done");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showChat(chat);
            }
        } else {
            if(users.get(0).getBlock().contains(DataBase.getUser())) {
                System.out.println("you are blocked");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showChat(chat);
            } else {
                System.out.println("Enter Message :");
                String text = Show.getString();
                ControllerManager.messageOnChat(DataBase.getUser(),text,chat);
                System.out.println("Done");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showChat(chat);
            }
        }
    }
    static public void creatMessage(Group group){
        if(group.getBans().contains(DataBase.getUser())){
            
        }
    }
    static public void creatMessage(Chat chat, Message message){
        ArrayList<User> users = new ArrayList<>(chat.getUsers());
        if(users.get(0).equals(DataBase.getUser())){
            if(users.get(1).getBlock().contains(DataBase.getUser())) {
                System.out.println("you are blocked");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showChat(chat);
            } else {
                System.out.println("Enter Message :");
                String text = Show.getString();
                ControllerManager.messageReplyOnChat(DataBase.getUser(),text,chat,message);
                System.out.println("Done");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showChat(chat);
            }
        } else {
            if(users.get(0).getBlock().contains(DataBase.getUser())) {
                System.out.println("you are blocked");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showChat(chat);
            } else {
                System.out.println("Enter Message :");
                String text = Show.getString();
                ControllerManager.messageReplyOnChat(DataBase.getUser(),text,chat,message);
                System.out.println("Done");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showChat(chat);
            }
        }
    }
    static public void creatMessage(Group group, Message message){

    }
    public static void selectChat(){
        Show.printLine();
        System.out.println("Enter ID of chat or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getChats().size());
        if(ID ==0 ){
            showAll();
        } else {
            Chat chat = DataBase.getChats().get(ID -1);
            if(chat.getUsers().contains(DataBase.getUser())) {
                showChat(chat);
            } else {
                System.out.println("Invalid command");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showAll();
            }
        }
    }
    public static void selectGroup(){
        Show.printLine();
        System.out.println("Enter ID of group or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getGroups().size());
        if(ID ==0 ){
            showAll();
        } else {
            Group group = DataBase.getGroups().get(ID -1);
            if(group.getMembers().contains(DataBase.getUser())) {
                showGroup(group);
            } else {
                System.out.println("Invalid command");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showAll();
            }
        }
    }
    public static void newChat(){

    }
    public static void newGroup(){

    }
    public static void deleteChat(Chat chat){
        System.out.println("Choose one of the options below:");
        System.out.println("Are you sure ?");
        System.out.println("1) YES");
        System.out.println("2) NO");
        switch (Show.inputProcessor(1,2)){
            case 1 :
                ControllerManager.deleteChat(chat);
                System.out.println("Deleted");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showAll();
            break;
            case 2 : showChat(chat);
            break;
        }
    }
    public static void selectMessage(){

    }
    public static void showGroupInfo(Group group){

    }
}