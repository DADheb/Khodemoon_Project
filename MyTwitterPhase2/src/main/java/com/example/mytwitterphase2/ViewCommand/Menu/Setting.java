package com.example.mytwitterphase2.ViewCommand.Menu;

import com.example.mytwitterphase2.Controller.UserController;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.ViewCommand.Show;

import java.sql.SQLException;
import java.util.Scanner;

public class Setting {
    public static Scanner scan = DataBase.scanner;
    public static void showSettingMenu() throws SQLException {
        Show.printLine();
        System.out.println("Setting");
        Show.showSettingUser(DataBase.getUser());
        System.out.println("Choose one of the options below:");
        System.out.println("1) Edit username");
        System.out.println("2) Edit password");
        System.out.println("3) Edit name");
        System.out.println("4) Edit last name");
        System.out.println("5) Edit bio");
        System.out.println("6) Edit email");
        System.out.println("7) Edit birthday");
        System.out.println("8) Edit privacy");
        System.out.println("9) Edit answer of security question");
        System.out.println("10) Back");
        Show.printLine();
        int num = Show.inputProcessor(1, 10);
        switch (num) {
            case 1:
                editUsername();
                break;
            case 2:
                editPassword();
                break;
            case 3:
                editName();
                break;
            case 4:
                editLastname();
                break;
            case 5:
                editBio();
                break;
            case 6:
                editEmail();
                break;
            case 7:
                editBirthday();
                break;
            case 8:
                editPrivacy();
                break;
            case 9:
                editSecurityQuestions();
                break;
            case 10 :
                First.showFirstMenu();
                break;
        }
    }
    public static void editUsername() throws SQLException {
        Show.printLine();
        System.out.println("Edit Username");
        System.out.println("Choose one of the options below:");
        System.out.println("1) Enter new username");
        System.out.println("2) Back");
        Show.printLine();
        int num = Show.inputProcessor(1, 2);
        if (num == 1) {
            System.out.println("Enter new username:");
            while (true) {
                String input = Show.getString();
                if (!DataBase.getUserNames().contains(input)) {
                    UserController.changeUserName(DataBase.getUser(), input);
                    System.out.println("Username changed");
                    break;
                }
                System.out.println("The Username already exists");
                System.out.println("Enter again :");
            }
            showSettingMenu();
        } else {
            showSettingMenu();
        }
    }

    public static void editPassword() throws SQLException {
        Show.printLine();
        System.out.println("Edit Password");
        System.out.println("Choose one of the options below:");
        System.out.println("1) Enter new password");
        System.out.println("2) Back");
        Show.printLine();
        int num = Show.inputProcessor(1, 2);
        String password;
        if (num == 1) {
            System.out.println("Enter new password :");
            while(true) {
                while (true) {
                    String input = Show.getString();
                    if (input.length() < 8) {
                        System.out.println("Password too short");
                        System.out.println("Enter again :");
                        continue;
                    } else if (!input.matches("([a-zA-Z1-9])\\w+")) {
                        System.out.println("Wrong characters are used");
                        System.out.println("Enter again :");
                        continue;
                    } else {
                        password = input;
                        System.out.println("Done");
                        Show.printLine();
                        break;
                    }
                }
                System.out.println("Enter your Password again:");
                String passwordCheck = Show.getString();
                if (password.matches(passwordCheck)) {
                    System.out.println("Done");
                    break;
                }
                System.out.println("Password not matched, Try again");
                Show.printLine();
                System.out.println("Enter a new password:");
            }
            UserController.changePassword(DataBase.getUser(),password);
            System.out.println("Password changed");
            System.out.println("Please login again");
            Login.showMain();
        } else {
            showSettingMenu();
        }
    }

    public static void editName() throws SQLException {
        Show.printLine();
        System.out.println("Edit name");
        System.out.println("Choose one of the options below:");
        System.out.println("1) Enter new name");
        System.out.println("2) Back");
        Show.printLine();
        int num = Show.inputProcessor(1, 2);
        if (num == 1) {
            System.out.println("Enter new name:");
            String input = Show.getString();
            UserController.changeName(DataBase.getUser(), input);
            System.out.println("Name changed");
            showSettingMenu();
        } else {
            showSettingMenu();
        }
    }

    public static void editLastname() throws SQLException {
        Show.printLine();
        System.out.println("Edit lastname");
        System.out.println("Choose one of the options below:");
        System.out.println("1) Enter new lastname");
        System.out.println("2) Back");
        Show.printLine();
        int num = Show.inputProcessor(1, 2);
        if (num == 1) {
            System.out.println("Enter new lastname:");
            String input = Show.getString();
            UserController.changeLastName(DataBase.getUser(), input);
            System.out.println("Lastname changed");
            showSettingMenu();
        } else {
            showSettingMenu();
        }
    }

    public static void editBio() throws SQLException {
        Show.printLine();
        System.out.println("Edit bio");
        System.out.println("Choose one of the options below:");
        System.out.println("1) Enter new bio");
        System.out.println("2) Back");
        Show.printLine();
        int num = Show.inputProcessor(1, 2);
        if (num == 1) {
            System.out.println("Enter new bio:");
            String input = Show.getString();
            UserController.changeBio(DataBase.getUser(), input);
            System.out.println("Bio changed");
            showSettingMenu();
        } else {
            showSettingMenu();
        }
    }

    public static void editEmail() throws SQLException {
        Show.printLine();
        System.out.println("Edit email");
        System.out.println("Choose one of the options below:");
        System.out.println("1) Enter new email");
        System.out.println("2) Back");
        Show.printLine();
        int num = Show.inputProcessor(1, 2);
        if (num == 1) {
            System.out.println("Enter new email:");
            String input = Show.getString();
            UserController.changeEmail(DataBase.getUser(), input);
            System.out.println("Email changed");
            showSettingMenu();
        } else {
            showSettingMenu();
        }
    }

    public static void editBirthday() throws SQLException {
        Show.printLine();
        System.out.println("Edit birthday");
        System.out.println("Choose one of the options below:");
        System.out.println("1) Enter new birthday");
        System.out.println("2) Back");
        Show.printLine();
        int num = Show.inputProcessor(1, 2);
        if (num == 1) {
            System.out.println("Enter new birthday in format YYYY/MM/DD :");
            String input = Show.getString();
            UserController.changeBirthDay(DataBase.getUser(), input);
            System.out.println("Birthday changed");
            showSettingMenu();
        } else {
            showSettingMenu();
        }
    }
    public static void editPrivacy() throws SQLException {
        Show.printLine();
        System.out.println("Edit privacy");
        System.out.println("Choose one of the options below:");
        System.out.println("1) Public");
        System.out.println("2) Private");
        System.out.println("3) Back");
        Show.printLine();
        int num = Show.inputProcessor(1, 3);
        if (num == 1) {
            UserController.changePrivacy(DataBase.getUser(),false);
            System.out.println("Privacy changed");
            showSettingMenu();
        } else if(num == 2){
            UserController.changePrivacy(DataBase.getUser(),true);
            System.out.println("Privacy changed");
            showSettingMenu();
        } else {
            showSettingMenu();
        }
    }
    public static void editSecurityQuestions() throws SQLException {
        Show.printLine();
        System.out.println("Edit answer of security question");
        System.out.println("Choose one of the options below:");
        System.out.println("1) Enter new answer");
        System.out.println("2) Back");
        Show.printLine();
        int num = Show.inputProcessor(1, 2);
        if (num == 1) {
            Show.showSecurityQuestion();
            System.out.println();
            String input = Show.getString();
            UserController.changeSecurityQuestionsAnswers(DataBase.getUser(), input);
            System.out.println("Answer changed");
            showSettingMenu();
        } else {
            showSettingMenu();
        }
    }
}
