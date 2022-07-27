package View.Menu;

import DataBase.DataBase;
import View.Show;

import java.util.Scanner;

public class First {
    public static Scanner scan = DataBase.scanner;

    public static void showFirstMenu(){
        Show.printLine();
        System.out.println("Twitter");
        System.out.println("Choose one of the options below:");
        System.out.println("1) Post of your following");
        System.out.println("2) Your Profile");
        System.out.println("3) Chats & Group");
        System.out.println("4) Setting");
        System.out.println("5) Search");
        System.out.println("6) See follow request");
        System.out.println("7) See suggested users");
        System.out.println("8) See ads");
        System.out.println("9) Logout");
        Show.printLine();
        switch (Show.inputProcessor(1,6)){
            case 1 : Profile.showFollowingPost();
            break;
            case 2 : Profile.showProfileMenu();
            break;
            case 3 : ChatGroup.showAll();
            break;
            case 4 : Setting.showSettingMenu();
            break;
            case 5 : Profile.showSearchMenu();
            break;
            case 6 : showFollowRequest();
            break;
            case 7 : showSuggestedUsers();
            break;
            case 8 : showAds();
            break;
            case 9 : Login.showMain();
            break;
        }
    }
    public static void showFollowRequest(){
        Show.printLine();
        Show.showUserList(DataBase.getUser().getFollowRequests(),0,10,0);
        System.out.println("Choose one of the options below:");
        System.out.println("1) Accept/Ignore some user");
        System.out.println("2) See some user");
        System.out.println("3) Back");
        Show.printLine();
        switch (Show.inputProcessor(1,3)){
            case 1 : acceptIgnore();
            break;
            case 2 : Profile.selectUser(3);
            break;
            case 3 : showFirstMenu();
            break;
        }
    }
    public static void showSuggestedUsers(){
        Show.showInterestUser(DataBase.getUser());
        System.out.println("Choose one of the options below:");
        System.out.println("1) See some user");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 : Profile.selectUser(4);
            break;
            case 2 : showFirstMenu();
            break;
        }
    }
    public static void showAds(){
        Show.showAds(DataBase.getUser());
        System.out.println("Choose one of the options below:");
        System.out.println("1) See some ad");
        System.out.println("2) Back");
        Show.printLine();
        switch (Show.inputProcessor(1,2)){
            case 1 : Profile.selectPost(3);
            break;
            case 2 : showFirstMenu();
            break;
        }
    }
    public static void acceptIgnore(){
        System.out.println("Enter ID for accept or");
        System.out.println("Enter negative of ID number for ignore or");
        System.out.println("Enter 0 for Back");
        int n = Show.getInt();
        if(n==0){
            showFollowRequest();
        } else if(n>0){
            Show.checkAccept(n);
            System.out.println("Enter anything for back");
            scan.nextLine();
            showFollowRequest();
        } else {
            Show.checkIgnore(-n);
            System.out.println("Enter anything for back");
            scan.nextLine();
            showFollowRequest();
        }
    }
}
