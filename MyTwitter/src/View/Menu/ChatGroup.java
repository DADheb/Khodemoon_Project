package View.Menu;

import Controller.*;
import DataBase.DataBase;
import View.Show;
import entity.Chat;
import entity.Group;
import entity.Message;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class ChatGroup {
    public static Scanner scan = DataBase.scanner;
    static public void showAll() throws SQLException {
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
    static public void showGroup(Group group) throws SQLException {
        Show.showLongGroup(group);
        System.out.println("Choose one of the options below:");
        System.out.println("1) Select message");
        System.out.println("2) Send new message");
        System.out.println("3) See group info");
        System.out.println("4) Search message");
        System.out.println("5) Back");
        switch (Show.inputProcessor(1,4)){
            case 1 : selectMessage(group);
                break;
            case 2 : creatMessage(group);
                break;
            case 3 : showGroupInfo(group);
                break;
            case 4 : search(group);
            break;
            case 5 : showAll();
                break;
        }
    }
    static public void showChat(Chat chat) throws SQLException {
        Show.showLongChat(chat);
        User user = new User();
        for (User u : chat.getUsers()){
            if(!u.equals(DataBase.getUser())){
                user = u;
            }
        }
        System.out.println("Choose one of the options below:");
        System.out.println("1) Select message");
        System.out.println("2) Send new message");
        System.out.println("3) Delete chat");
        if(DataBase.getUser().getBlock().contains(user)){
            System.out.println("4) Unblock user");
        } else {
            System.out.println("4) Block user");
        }
        System.out.println("5) Search message");
        System.out.println("6) Back");
        switch (Show.inputProcessor(1,4)){
            case 1 : selectMessage(chat);
            break;
            case 2 : creatMessage(chat);
            break;
            case 3 : deleteChat(chat);
            break;
            case 4 :
                if(DataBase.getUser().getBlock().contains(user)){
                    UserController.unblock(DataBase.getUser(),user);
                } else {
                    UserController.block(DataBase.getUser(),user);
                }
                break;
            case 5 : search(chat);
            break;
            case 6 : showAll();
            break;
        }
    }
    static public void search(Chat chat) throws SQLException {
        Show.printLine();
        System.out.println("Enter text : ");
        String text = Show.getString();
        ArrayList<Message> messages = SQL.SQL.searchMessage(chat,text,DataBase.getConnection());
        Show.printLine();
        System.out.println("Result : ");
        Show.showMessageList(messages,0,10);
        Show.printLine();
        System.out.println("Choose one of the options below:");
        System.out.println("1) Select some message");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 : selectMessage(chat);
            break;
            case 2 : showChat(chat);
            break;
        }
    }
    static public void search(Group group) throws SQLException {
        Show.printLine();
        System.out.println("Enter text : ");
        String text = Show.getString();
        ArrayList<Message> messages = SQL.SQL.searchMessage(group,text,DataBase.getConnection());
        Show.printLine();
        System.out.println("Result : ");
        Show.showMessageList(messages,0,10);
        Show.printLine();
        System.out.println("Choose one of the options below:");
        System.out.println("1) Select some message");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 : selectMessage(group);
                break;
            case 2 : showGroup(group);
                break;
        }
    }
    static public void creatMessage(Chat chat) throws SQLException {
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
    static public void creatMessage(Group group) throws SQLException {
        if(group.getBans().contains(DataBase.getUser())){
            System.out.println("you are baned");
            System.out.println("Enter anything for back");
            scan.nextLine();
            showGroup(group);
        } else if(group.getMembers().contains(DataBase.getUser())){
            System.out.println("Enter Message :");
            String text = Show.getString();
            ControllerManager.messageOnGroup(DataBase.getUser(),text,group);
            System.out.println("Done");
            System.out.println("Enter anything for back");
            scan.nextLine();
            showGroup(group);
        }
    }

    static public void creatMessage(Chat chat, Message message) throws SQLException {
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

    static public void creatMessage(Group group, Message message) throws SQLException {
        if(group.getBans().contains(DataBase.getUser())){
            System.out.println("you are baned");
            System.out.println("Enter anything for back");
            scan.nextLine();
            showGroup(group);
        } else if(group.getMembers().contains(DataBase.getUser())){
            System.out.println("Enter Message :");
            String text = Show.getString();
            ControllerManager.messageReplyOnGroup(DataBase.getUser(),text,group,message);
            System.out.println("Done");
            System.out.println("Enter anything for back");
            scan.nextLine();
            showGroup(group);
        }
    }
    public static void selectChat() throws SQLException {
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
    public static Chat returnChat() throws SQLException {
        Show.printLine();
        System.out.println("Enter ID of chat for forward message or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getChats().size());
        if(ID ==0 ){
            showAll();
        } else {
            Chat chat = DataBase.getChats().get(ID -1);
            if(chat.getUsers().contains(DataBase.getUser())) {
                return chat;
            } else {
                System.out.println("Invalid command");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showAll();
            }
        }
        return null;
    }
    public static void selectGroup() throws SQLException {
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
    public static Group returnGroup() throws SQLException {
        Show.printLine();
        System.out.println("Enter ID of group for forward message or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getGroups().size());
        if(ID ==0 ){
            showAll();
        } else {
            Group group = DataBase.getGroups().get(ID -1);
            if(group.getMembers().contains(DataBase.getUser())) {
                return group;
            } else {
                System.out.println("Invalid command");
                System.out.println("Enter anything for back");
                scan.nextLine();
                showAll();
            }
        }
        return null;
    }
    public static void newChat() throws SQLException {
        Show.printLine();
        System.out.println("Enter ID of user for creat chat or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getUsers().size());
        if(ID ==0 ){
            showAll();
        } else {
            if(ID==DataBase.getUserID(DataBase.getUser())){
                System.out.println("Please enter User different with you");
                newChat();
            } else {
                int n = checkChatWith(DataBase.getUsers().get(ID-1));
                if(n!=-1){
                    System.out.println("There is a chat with this user");
                    System.out.println("Enter anything for go to chat");
                    scan.nextLine();
                    showChat(DataBase.getChats().get(n));
                } else {
                    Chat chat = ControllerManager.newChat(DataBase.getUser(),DataBase.getUsers().get(ID-1));
                    System.out.println("Enter anything for go to chat");
                    scan.nextLine();
                    showChat(chat);
                }
            }
        }
    }
    public static void newChat(User user,int n) throws SQLException {
        System.out.println("Choose one of the options below:");
        System.out.println("1) Creat chat");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 :
                int m = checkChatWith(user);
                if(m!=-1){
                    System.out.println("There is a chat with this user");
                    System.out.println("Enter anything for go to chat");
                    scan.nextLine();
                    showChat(DataBase.getChats().get(m));
                } else {
                    Chat chat = ControllerManager.newChat(DataBase.getUser(),user);
                    System.out.println("Enter anything for go to chat");
                    scan.nextLine();
                    showChat(chat);
                }
                break;
            case  2 : Profile.showUser(user,n);
                break;
        }
    }
    public static void newGroup() throws SQLException {
        System.out.println("Enter name of group :");
        String name = Show.getString();
        System.out.println("Enter bio of group");
        String bio = Show.getString();
        Group group = ControllerManager.newGroup(DataBase.getUser(),name);
        group.setBio(bio);
        System.out.println("Enter anything for go to group");
        scan.nextLine();
        showGroup(group);
    }
    public static void deleteChat(Chat chat) throws SQLException {
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
    public static void selectMessage(Chat chat) throws SQLException {
        Show.printLine();
        System.out.println("Enter ID of Message or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getMessages().size());
        if(ID ==0 ){
            showChat(chat);
        } else {
            Message message = DataBase.getMessages().get(ID-1);
            if(chat.getMessages().contains(message)){
                System.out.println("Message selected");
                System.out.println("Choose one of the options below:");
                if(message.getUser().equals(DataBase.getUser()) && (!message.isForwarded())) {
                    System.out.println("1) Reply on this message");
                    System.out.println("2) Forward Massage to another chat or group");
                    System.out.println("3) Edit message");
                    System.out.println("4) Back");
                    switch (Show.inputProcessor(1,4)){
                        case 1 : creatMessage(chat,message);
                        break;
                        case 2 : forwardMessage(message);
                        break;
                        case 3 : editMessage(chat,message);
                        break;
                        case 4 : showChat(chat);
                        break;
                    }
                } else {
                    System.out.println("1) Reply on this message");
                    System.out.println("2) Forward Massage to another chat or group");
                    System.out.println("3) Back");
                    switch (Show.inputProcessor(1,3)){
                        case 1 : creatMessage(chat,message);
                            break;
                        case 2 : forwardMessage(message);
                            break;
                        case 3 : showChat(chat);
                            break;
                    }
                }

            } else {
                System.out.println("This message not exist in chat");
                System.out.println("Enter anything for back to chat");
                scan.nextLine();
                showChat(chat);
            }
        }
    }
    public static void selectMessage(Group group) throws SQLException {
        Show.printLine();
        System.out.println("Enter ID of Message or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getMessages().size());
        if(ID ==0 ){
            showGroup(group);
        } else {
            Message message = DataBase.getMessages().get(ID-1);
            if(group.getMessages().contains(message)){
                System.out.println("Message selected");
                System.out.println("Choose one of the options below:");
                if(message.getUser().equals(DataBase.getUser()) && (!message.isForwarded())) {
                    if(group.getAdmins().contains(DataBase.getUser())){
                        System.out.println("1) Reply on this message");
                        System.out.println("2) Forward Massage to another chat or group");
                        System.out.println("3) Edit message");
                        System.out.println("4) Delete message");
                        System.out.println("5) Back");
                        switch (Show.inputProcessor(1, 5)) {
                            case 1:
                                creatMessage(group, message);
                                break;
                            case 2:
                                forwardMessage(message);
                                break;
                            case 3:
                                editMessage(group, message);
                                break;
                            case 4 : deleteMessage(group,message);
                            break;
                            case 5:
                                showGroup(group);
                                break;
                        }
                    } else {
                        System.out.println("1) Reply on this message");
                        System.out.println("2) Forward Massage to another chat or group");
                        System.out.println("3) Edit message");
                        System.out.println("4) Back");
                        switch (Show.inputProcessor(1, 4)) {
                            case 1:
                                creatMessage(group, message);
                                break;
                            case 2:
                                forwardMessage(message);
                                break;
                            case 3:
                                editMessage(group, message);
                                break;
                            case 4:
                                showGroup(group);
                                break;
                        }
                    }
                } else {
                    if (group.getAdmins().contains(DataBase.getUser())) {
                        System.out.println("1) Reply on this message");
                        System.out.println("2) Forward Massage to another chat or group");
                        System.out.println("3) Delete message");
                        System.out.println("4) Back");
                        switch (Show.inputProcessor(1, 4)) {
                            case 1:
                                creatMessage(group, message);
                                break;
                            case 2:
                                forwardMessage(message);
                                break;
                            case 3 : deleteMessage(group,message);
                                break;
                            case 4:
                                showGroup(group);
                                break;
                        }
                    } else {
                        System.out.println("1) Reply on this message");
                        System.out.println("2) Forward Massage to another chat or group");
                        System.out.println("3) Back");
                        switch (Show.inputProcessor(1, 3)) {
                            case 1:
                                creatMessage(group, message);
                                break;
                            case 2:
                                forwardMessage(message);
                                break;
                            case 3:
                                showGroup(group);
                                break;
                        }
                    }
                }

            } else {
                System.out.println("This message not exist in group");
                System.out.println("Enter anything for back to group");
                scan.nextLine();
                showGroup(group);
            }
        }
    }
    public static void showGroupInfo(Group group) throws SQLException {
        Show.showGroupInfo(group);
        System.out.println("Choose one of the options below:");
        if (group.getCreator().equals(DataBase.getUser())){
            System.out.println("1) Remove member");
            System.out.println("2) Change group name");
            System.out.println("3) Change bio");
            System.out.println("4) Add member");
            System.out.println("5) Add admin");
            System.out.println("6) Left from group and delete it");
            System.out.println("7) Remove admin");
            System.out.println("8) Ban member");
            System.out.println("9) See profile of member");
            System.out.println("10) Delete all message from some user");
            System.out.println("11) Back");
            switch (Show.inputProcessor(1,9)){
                case 1 :
                    System.out.println("Select member");
                    User user = returnMember(group);
                    if(group.getCreator().equals(user)){
                        System.out.println("Please choose member different from yourself");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        GroupController.removeMember(group,user);
                        System.out.println("Done");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    }
                    break;
                case 2 :
                    System.out.println("Enter new name");
                    String name = Show.getString();
                    GroupController.changeName(group,name);
                    System.out.println("Done");
                    System.out.println("Enter anything for back to group info");
                    scan.nextLine();
                    showGroupInfo(group);
                    break;
                case 3 :
                    System.out.println("Enter new bio");
                    String bio = Show.getString();
                    GroupController.changeBio(group,bio);
                    System.out.println("Done");
                    System.out.println("Enter anything for back to group info");
                    scan.nextLine();
                    showGroupInfo(group);
                    break;
                case 4 :
                    System.out.println("Select user");
                    User user1 = returnUser();
                    if(group.getMembers().contains(user1)){
                        System.out.println("This user is already joined");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        GroupController.newMember(group,user1);
                        System.out.println("Added");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    }
                    break;
                case 5 :
                    System.out.println("Select member");
                    User user2 = returnMember(group);
                    if(group.getCreator().equals(user2)){
                        System.out.println("Please choose member different from yourself");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else if(group.getAdmins().contains(user2)){
                        System.out.println("This member is already admin");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        GroupController.newAdmin(group,user2);
                        System.out.println("Done");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    }
                    break;
                case 6 :
                    ControllerManager.deleteGroup(group);
                    System.out.println("Group deleted");
                    System.out.println("Enter anything for back");
                    scan.nextLine();
                    showAll();
                    break;
                case 7 :
                    System.out.println("Select member");
                    User user3 = returnMember(group);
                    if(group.getCreator().equals(user3)){
                        System.out.println("Please choose member different from yourself");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else if(group.getAdmins().contains(user3)){
                        GroupController.removeAdmin(group,user3);
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        System.out.println("This member isn't admin");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    }
                    break;
                case 8 :
                    System.out.println("Select member");
                    User user4 = returnMember(group);
                    if(group.getCreator().equals(user4)){
                        System.out.println("Please choose member different from yourself");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        GroupController.banUser(group,user4);
                        System.out.println("Baned");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    }
                    break;
                case 9 :
                    System.out.println("Select member");
                    User user5 = returnMember(group);
                    if(user5.equals(DataBase.getUser())){
                        System.out.println("Please choose member different from yourself");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        Profile.showUser(user5,5);
                    }
                    break;
                case 10 :
                    System.out.println("Select member");
                    User user6 = returnMember(group);
                    if(group.getCreator().equals(user6)){
                        System.out.println("Please choose member different from yourself");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        GroupController.deleteAllMessageOfUser(group,user6);
                        System.out.println("Deleted");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    }
                    break;
                case 11 : showGroup(group);
                    break;
            }
        } else if(group.getAdmins().contains(DataBase.getUser())) {
            System.out.println("1) Remove member");
            System.out.println("2) Change group name");
            System.out.println("3) Change bio");
            System.out.println("4) Add member");
            System.out.println("5) Left from group");
            System.out.println("6) Ban member");
            System.out.println("7) See profile of member");
            System.out.println("8) Delete all message from some user");
            System.out.println("9) Back");
            switch (Show.inputProcessor(1,7)){
                case 1 :
                    System.out.println("Select member");
                    User user = returnMember(group);
                    if(group.getAdmins().contains(user)){
                        System.out.println("Please choose member different from admins");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        GroupController.removeMember(group,user);
                        System.out.println("Done");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    }
                    break;
                case 2 :
                    System.out.println("Enter new name");
                    String name = Show.getString();
                    GroupController.changeName(group,name);
                    System.out.println("Done");
                    System.out.println("Enter anything for back to group info");
                    scan.nextLine();
                    showGroupInfo(group);
                    break;
                case 3 :
                    System.out.println("Enter new bio");
                    String bio = Show.getString();
                    GroupController.changeBio(group,bio);
                    System.out.println("Done");
                    System.out.println("Enter anything for back to group info");
                    scan.nextLine();
                    showGroupInfo(group);
                    break;
                case 4 :
                    System.out.println("Select user");
                    User user1 = returnUser();
                    if(group.getMembers().contains(user1)){
                        System.out.println("This user is already joined");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        GroupController.newMember(group,user1);
                        System.out.println("Added");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    }
                    break;
                case 5 :
                    GroupController.removeMember(group,DataBase.getUser());
                    System.out.println("you Left");
                    System.out.println("Enter anything for back");
                    scan.nextLine();
                    showAll();
                    break;
                case 6 :
                    System.out.println("Select member");
                    User user2 = returnMember(group);
                    if(group.getAdmins().contains(user2)){
                        System.out.println("Please choose member different from admins");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        GroupController.banUser(group,user2);
                        System.out.println("Baned");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    }
                    break;
                case 7 :
                    System.out.println("Select member");
                    User user3 = returnMember(group);
                    if(user3.equals(DataBase.getUser())){
                        System.out.println("Please choose member different from yourself");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        Profile.showUser(user3,5);
                    }
                    break;
                case 8 :
                    System.out.println("Select member");
                    User user4 = returnMember(group);
                    if(group.getAdmins().contains(user4)){
                        System.out.println("Please choose member different from admins");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        GroupController.deleteAllMessageOfUser(group,user4);
                        System.out.println("Deleted");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    }
                    break;
                case 9 : showGroup(group);
                    break;
            }
        } else {
            System.out.println("1) Left from group");
            System.out.println("2) See profile of member");
            System.out.println("3) Back");
            switch (Show.inputProcessor(1,3)){
                case 1 :
                    GroupController.removeMember(group,DataBase.getUser());
                    System.out.println("you Left");
                    System.out.println("Enter anything for back");
                    scan.nextLine();
                    showAll();
                    break;
                case 2 :
                    System.out.println("Select member");
                    User user = returnMember(group);
                    if(user.equals(DataBase.getUser())){
                        System.out.println("Please choose member different from yourself");
                        System.out.println("Enter anything for back to group info");
                        scan.nextLine();
                        showGroupInfo(group);
                    } else {
                        Profile.showUser(user,5);
                    }
                    break;
                case 3 : showGroup(group);
                    break;
            }
        }
    }
    public static int checkChatWith(User user){
        for (Chat c : DataBase.getUser().getChats()){
            if(c.getUsers().contains(user)){
                return DataBase.getChats().indexOf(c);
            }
        }
        return -1;
    }
    public static void editMessage(Chat chat , Message message) throws SQLException {
        System.out.println("Enter new text :");
        String text = Show.getString();
        MessageController.editText(message,text);
        System.out.println("Done");
        System.out.println("Enter anything for back");
        scan.nextLine();
        showChat(chat);
    }
    public static void editMessage(Group group , Message message) throws SQLException {
        System.out.println("Enter new text :");
        String text = Show.getString();
        MessageController.editText(message,text);
        System.out.println("Done");
        System.out.println("Enter anything for back");
        scan.nextLine();
        showGroup(group);
    }
    public static void forwardMessage(Message message) throws SQLException {
        Show.printLine();
        System.out.println("Choose one of the options below:");
        System.out.println("1) Forward to chat");
        System.out.println("2) Forward to group");
        System.out.println("3) Back");
        switch (Show.inputProcessor(1,3)){
            case 1 :
                Chat chat = returnChat();
                ControllerManager.forwardMessageToChat(DataBase.getUser(),message,chat);
                System.out.println("Done");
                System.out.println("Enter anything for go to chat");
                scan.nextLine();
                showChat(chat);
                break;
            case 2 :
                Group group = returnGroup();
                ControllerManager.forwardMessageToGroup(DataBase.getUser(),message,group);
                System.out.println("Done");
                System.out.println("Enter anything for go to group");
                scan.nextLine();
                showGroup(group);
                break;
            case 3 : showAll();
            break;
        }
    }
    public static void deleteMessage(Group group,Message message) throws SQLException {
        Show.printLine();
        System.out.println("Are you sure ?");
        System.out.println("1) YES");
        System.out.println("2) NO and back to group");
        switch (Show.inputProcessor(1,2)){
            case 1 :
                GroupController.deleteMessage(group,message);
                System.out.println("Done");
                System.out.println("Enter anything for back to group");
                scan.nextLine();
                showGroup(group);
                break;
            case 2 : showGroup(group);
            break;
        }
    }

    public static User returnMember(Group group){
        Show.printLine();
        System.out.println("Enter ID of member");
        while (true) {
            int ID = Show.inputProcessor(1, DataBase.getUsers().size());
            User user = DataBase.getUsers().get(ID-1);
            if(group.getMembers().contains(user)){
                return user;
            } else {
                System.out.println("This user isn't exist in group");
                System.out.println("Enter again :");
            }
        }
    }
    public static User returnUser(){
        Show.printLine();
        System.out.println("Enter ID of user");
        int ID = Show.inputProcessor(1,DataBase.getUsers().size());
        return DataBase.getUsers().get(ID-1);
    }
}