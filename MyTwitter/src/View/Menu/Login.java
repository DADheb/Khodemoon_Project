package View.Menu;

import Controller.ControllerManager;
import Controller.UserController;
import DataBase.DataBase;
import SQL.SQL;
import View.Show;

import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public static Scanner scan = DataBase.scanner;
    public static void showMain() throws SQLException {
        Show.printLine();
        System.out.println("Choose one of the options below:");
        System.out.println("1) SignUp");
        System.out.println("2) Login");
        System.out.println("3) Exit");
        switch (Show.inputProcessor(1,3)){
            case 1 : signUp();
            break;
            case 2 : login();
            break;
            case 3 :
                SQL.insertAll(DataBase.getConnection());
                System.exit(0);
                break;
        }
    }

    public static void signUp() throws SQLException {
        System.out.println("Enter a UserName");
        String username ;
        while (true) {
            String input = Show.getString();
            if (!DataBase.getUserNames().contains(input)) {
                username = input;
                System.out.println("Done");
                Show.printLine();
                break;
            }
            System.out.println("The Username already exists");
            System.out.println("Enter again :");
        }
        Show.printLine();
        System.out.println("Answer the questions below:");
        System.out.println("What is your favorite animal?");
        String security = Show.getString();
        System.out.println("Done");
        Show.printLine();
        System.out.println("Enter your name : ");
        String name = Show.getString();
        System.out.println("Done");
        Show.printLine();
        System.out.println("Enter your lastname : ");
        String lastname = Show.getString();
        System.out.println("Done");
        Show.printLine();
        System.out.println("When is your birthday? (in format YYYY/MM/DD)");
        String birtDay = Show.getString();
        System.out.println("Done");
        Show.printLine();
        System.out.println("Enter a Password:");
        String password;
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
            System.out.println("Enter a Password:");
        }
        System.out.println("Select type of user");
        System.out.println("1) Normal");
        System.out.println("2) Business");
        boolean type = false;
        switch (Show.inputProcessor(1,2)){
            case 1 : type = false;
            break;
            case 2 : type = true;
            break;
        }
        System.out.println("Done");
        Show.printLine();
        System.out.println("Enter bio :");
        String bio = Show.getString();
        System.out.println("Done");
        Show.printLine();
        System.out.println("Enter email address :");
        String email = Show.getString();
        System.out.println("Done");
        ControllerManager.newUser(username,password,type,name,lastname,bio,security,birtDay,email);
        System.out.println("Account created successfully");
        System.out.println("Please login now");
        Show.printLine();
        login();
    }
    public static void login () throws SQLException {
        while (true) {
            System.out.println("Enter your username or 0 for back:");
            String username = Show.getString();
            if(username.equals("0")){
                showMain();
            }
            System.out.println("Enter your Password:");
            String password = Show.getString();
            int index = DataBase.getUserNames().indexOf(username);
            if (index == -1) {
                System.out.println("No account exists with this username");
                System.out.println("Please try again.");
                continue;
            } else if (!DataBase.getUserPasswords().get(index).equals(password)) {
                System.out.println("Wrong Password");
                System.out.println("Forget your Password? 1)No 2)Yes");
                switch (Show.inputProcessor(1,2)){
                    case 1 :
                        System.out.println("Please try again.");
                        continue;
                    case 2 :
                        System.out.println("What is your favorite animal?");
                        String answer = Show.getString();
                        if(DataBase.getUsers().get(DataBase.getUserID(username)).getSecurityQuestionsAnswers().equals(answer)){
                            System.out.println("Wrong answer");
                            System.out.println("Please try again later.");
                            showMain();
                        } else {
                            Show.printLine();
                            System.out.println("Enter a new Password:");
                            String newPassword;
                            while(true) {
                                while (true) {
                                    String input = Show.getString();
                                    if (input.length() < 8) {
                                        System.out.println("Password too short");
                                        System.out.println("Enter again :");
                                        continue;
                                    } else if (!input.matches("([A-Z1-9])\\w+")) {
                                        System.out.println("Wrong characters are used");
                                        System.out.println("Enter again :");
                                        continue;
                                    } else {
                                        newPassword = input;
                                        System.out.println("Done");
                                        Show.printLine();
                                        break;
                                    }
                                }
                                System.out.println("Enter your Password again:");
                                String passwordCheck = Show.getString();
                                if (newPassword.matches(passwordCheck)) {
                                    DataBase.getUserPasswords().remove(index);
                                    DataBase.getUserPasswords().add(index,newPassword);
                                    DataBase.getUsers().get(index).setPassword(newPassword);

                                    System.out.println("Password changed successfully");
                                    System.out.println("Try to logIn using your new Password");
                                    login();
                                    break;
                                }
                                System.out.println("Password not matched, Try again");
                                Show.printLine();
                                System.out.println("Enter a Password:");
                            }
                        }
                }

            }
            System.out.println("Logged in successfully");
            System.out.println("Enter anything for go to account");
            scan.nextLine();
            DataBase.setUser(DataBase.getUsers().get(index));
            First.showFirstMenu();
            break;
        }
    }
}
