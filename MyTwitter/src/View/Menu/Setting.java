package View.Menu;

import Controller.UserController;
import DataBase.DataBase;
import entity.User;

import java.util.Scanner;
import java.util.regex.Matcher;

public class Setting {

    public static void run(String myUsername, Scanner scanner) {
        System.out.println("SETTINGS");
        System.out.println("choose one of the options below:");
        System.out.println("1) edit username");
        System.out.println("2) edit password");
        System.out.println("3) edit name");
        System.out.println("4) edit last name");
        System.out.println("5) edit bio");
        System.out.println("6) edit email");
        System.out.println("7) edit birthday");
        System.out.println("8) back");

        int num = inputProcessor(1, 8, scanner);
        switch (num) {
            case 1:
                editUsername(scanner, myUsername);
                break;
            case 2:
                editPassword(scanner, myUsername);
                break;
            case 3:
                editName(scanner, myUsername);
                break;
            case 4:
                editLastname(scanner, myUsername);
                break;
            case 5:
                editBio(scanner, myUsername);
                break;
            case 6:
                editEmail(scanner, myUsername);
                break;
            case 7:
                editBirthday(scanner, myUsername);
                break;
            case 8:
                return;

        }
    }

    public static User getUserByUsername(String username) {
        return DataBase.getUsers().get(DataBase.getUserNames().indexOf(username));
    }

    public static int inputProcessor(int first, int last, Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (input.length() == 0) {
                input = scanner.nextLine();
            }
            int inputNumber = Integer.parseInt(input.trim());
            for (int i = first; i <= last; i++) {
                if (inputNumber == i) {
                    return i;
                }
            }
            System.out.println("invalid number!");
            System.out.println("please choose again");
        }
    }

    public static void editUsername(Scanner scanner, String myUsername) {
        System.out.println("EDIT USERNAME");
        System.out.println("choose one of the options below:");
        System.out.println("1) enter new username");
        System.out.println("2) back");

        int num = inputProcessor(1, 2, scanner);
        if (num == 1) {
            System.out.println("enter new username:");
            while (true) {
                String input = scanner.nextLine();
                if (input.length() == 0) {
                    input = scanner.nextLine();
                }
                if (DataBase.getUserNames().contains(input)) {
                    System.out.println("invalid input");
                    System.out.println("enter again:");
                }
                UserController.changeUserName(getUserByUsername(myUsername), input);
            }
        } else if (num == 2) {
            return;
        }
    }

    public static void editPassword(Scanner scanner, String myUsername) {
        System.out.println("EDIT PASSWORD");
        System.out.println("choose one of the options below:");
        System.out.println("1) enter new password");
        System.out.println("2) back");

        int num = inputProcessor(1, 2, scanner);
        if (num == 1) {
            System.out.println("enter new username:");
            while (true) {
                String input = scanner.nextLine();
                if (input.length() == 0) {
                    input = scanner.nextLine();
                }
                UserController.changePassword(getUserByUsername(myUsername), input);
            }
        } else if (num == 2) {
            return;
        }
    }

    public static void editName(Scanner scanner, String myUsername) {
        System.out.println("EDIT NAME");
        System.out.println("choose one of the options below:");
        System.out.println("1) enter new name");
        System.out.println("2) back");

        int num = inputProcessor(1, 2, scanner);
        if (num == 1) {
            System.out.println("enter new name:");
            while (true) {
                String input = scanner.nextLine();
                if (input.length() == 0) {
                    input = scanner.nextLine();
                }
                UserController.changeName(getUserByUsername(myUsername), input);
            }
        } else if (num == 2) {
            return;
        }
    }

    public static void editLastname(Scanner scanner, String myUsername) {
        System.out.println("EDIT LASTNAME");
        System.out.println("choose one of the options below:");
        System.out.println("1) enter new lastname");
        System.out.println("2) back");

        int num = inputProcessor(1, 2, scanner);
        if (num == 1) {
            System.out.println("enter new lastname:");
            while (true) {
                String input = scanner.nextLine();
                if (input.length() == 0) {
                    input = scanner.nextLine();
                }
                UserController.changeLastName(getUserByUsername(myUsername), input);
            }
        } else if (num == 2) {
            return;
        }
    }

    public static void editBio(Scanner scanner, String myUsername) {
        System.out.println("EDIT BIO");
        System.out.println("choose one of the options below:");
        System.out.println("1) enter new bio");
        System.out.println("2) back");

        int num = inputProcessor(1, 2, scanner);
        if (num == 1) {
            System.out.println("enter new bio:");
            while (true) {
                String input = scanner.nextLine();
                if (input.length() == 0) {
                    input = scanner.nextLine();
                }
                UserController.changeBio(getUserByUsername(myUsername), input);
            }
        } else if (num == 2) {
            return;
        }
    }

    public static void editEmail(Scanner scanner, String myUsername) {
        System.out.println("EDIT EMAIL");
        System.out.println("choose one of the options below:");
        System.out.println("1) enter new email");
        System.out.println("2) back");

        int num = inputProcessor(1, 2, scanner);
        if (num == 1) {
            System.out.println("enter new email:");
            while (true) {
                String input = scanner.nextLine();
                if (input.length() == 0) {
                    input = scanner.nextLine();
                }
                UserController.changeEmail(getUserByUsername(myUsername), input);
            }
        } else if (num == 2) {
            return;
        }
    }

    public static void editBirthday(Scanner scanner, String myUsername) {
        System.out.println("EDIT BIRTHDAY");
        System.out.println("choose one of the options below:");
        System.out.println("1) enter new birthday");
        System.out.println("2) back");

        int num = inputProcessor(1, 2, scanner);
        if (num == 1) {
            System.out.println("enter new birthday:");
            while (true) {
                String input = scanner.nextLine();
                if (input.length() == 0) {
                    input = scanner.nextLine();
                }
                UserController.changeBirthDay(getUserByUsername(myUsername), input);
            }
        } else if (num == 2) {
            return;
        }
    }
}
