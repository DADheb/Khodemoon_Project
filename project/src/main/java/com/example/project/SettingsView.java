package com.example.project;

import java.util.Scanner;
import java.util.regex.Matcher;

public class SettingsView {
    public static void run(Scanner scanner, String myUsername) {
        System.out.println("Settings!!");
        System.out.println("edit username\n");
        System.out.println("edit password\n");
        System.out.println("edit name\n");
        System.out.println("edit last name\n");
        System.out.println("edit bio\n");
        System.out.println("edit email\n");
        System.out.println("edit birthday\n");
        System.out.println("back\n");
        while (true) {
            String input = new String();
            input = scanner.nextLine();
            Matcher matcher;
            if ((matcher = Commands.getMatcher(input, Commands.editUsername)) != null) {
                editUsername(scanner, myUsername);
            } else if ((matcher = Commands.getMatcher(input, Commands.editPassword)) != null) {
                editPassword(scanner, myUsername);
            } else if ((matcher = Commands.getMatcher(input, Commands.editName)) != null) {
                editName(scanner, myUsername);
            } else if ((matcher = Commands.getMatcher(input, Commands.editLastName)) != null) {
                editLastname(scanner, myUsername);
            } else if ((matcher = Commands.getMatcher(input, Commands.editBio)) != null) {
                editBio(scanner, myUsername);
            } else if ((matcher = Commands.getMatcher(input, Commands.editEmail)) != null) {
                editEmail(scanner, myUsername);
            } else if ((matcher = Commands.getMatcher(input, Commands.editBirthday)) != null) {
                editBirthday(scanner, myUsername);
            } else if ((matcher = Commands.getMatcher(input, Commands.back)) != null) {
                return;
            }
        }
    }

    public static void editUsername(Scanner scanner, String myUsername) {
        System.out.println("*EDIT USERNAME*");
        System.out.println("enter new username");
        System.out.println("or enter BACK to go to Settings");

        while (true) {
            String input = new String();
            input = scanner.nextLine();
            if (input.length() == 0) {
                input = scanner.nextLine();
            }
            if (input.trim().equals("BACK")) {
                return;
            }
            //if (input.contains("\\S*")) shartaye modele username
            SettingsController.editUsername(input, myUsername);
            System.out.println("username changed!");
            System.out.println("enter new username");
            System.out.println("or enter BACK to go to Settings");
        }
    }

    public static void editPassword(Scanner scanner, String myUsername) {
        System.out.println("*EDIT PASSWORD*");
        System.out.println("enter new password");
        System.out.println("or enter BACK to go settings");

        while (true) {
            String input = new String();
            input = scanner.nextLine();
            if (input.length() == 0) {
                input = scanner.nextLine();
            }
            if (input.trim().equals("BACK")) {
                return;
            } else {
                SettingsController.editPassword(input, myUsername);
            }
            System.out.println("password changed!");
            System.out.println("enter new password");
            System.out.println("or enter BACK to go to Settings");
        }
    }

    public static void editName(Scanner scanner, String myUsername) {
        System.out.println("*EDIT NAME*");
        System.out.println("enter new name");
        System.out.println("or enter BACK to go settings");

        while (true) {
            String input = new String();
            input = scanner.nextLine();
            if (input.length() == 0) {
                input = scanner.nextLine();
            }
            if (input.trim().equals("BACK")) {
                return;
            } else {
                SettingsController.editName(input, myUsername);
            }
            System.out.println("name changed!");
            System.out.println("enter new name");
            System.out.println("or enter BACK to go to Settings");
        }
    }

    public static void editLastname(Scanner scanner, String myUsername) {
        System.out.println("*EDIT LASTNAME*");
        System.out.println("enter new lastname");
        System.out.println("or enter BACK to go settings");

        while (true) {
            String input = new String();
            input = scanner.nextLine();
            if (input.length() == 0) {
                input = scanner.nextLine();
            }
            if (input.trim().equals("BACK")) {
                return;
            } else {
                SettingsController.editLastname(input, myUsername);
            }
            System.out.println("lastname changed!");
            System.out.println("enter new lastname");
            System.out.println("or enter BACK to go to Settings");
        }
    }

    public static void editBio(Scanner scanner, String myUsername) {
        System.out.println("*EDIT BIO*");
        System.out.println("enter new bio");
        System.out.println("or enter BACK to go settings");

        while (true) {
            String input = new String();
            input = scanner.nextLine();
            if (input.length() == 0) {
                input = scanner.nextLine();
            }
            if (input.trim().equals("BACK")) {
                return;
            } else {
                SettingsController.editBio(input, myUsername);
            }
            System.out.println("bio changed!");
            System.out.println("enter new bio");
            System.out.println("or enter BACK to go to Settings");
        }
    }

    public static void editBirthday(Scanner scanner, String myUsername) {
        System.out.println("*EDIT BIRTHDAY*");
        System.out.println("enter new birthday");
        System.out.println("or enter BACK to go settings");

        while (true) {
            String input = new String();
            input = scanner.nextLine();
            if (input.length() == 0) {
                input = scanner.nextLine();
            }
            if (input.trim().equals("BACK")) {
                return;
            } else {
                SettingsController.editBirthday(input, myUsername);
            }
            System.out.println("birthday changed!");
            System.out.println("enter new birthday");
            System.out.println("or enter BACK to go to Settings");
        }
    }

    public static void editEmail(Scanner scanner, String myUsername) {
        System.out.println("*EDIT EMAIL*");
        System.out.println("enter new email");
        System.out.println("or enter BACK to go settings");

        while (true) {
            String input = new String();
            input = scanner.nextLine();
            if (input.length() == 0) {
                input = scanner.nextLine();
            }
            if (input.trim().equals("BACK")) {
                return;
            } else {
                SettingsController.editEmail(input, myUsername);
            }
            System.out.println("email changed!");
            System.out.println("enter new email");
            System.out.println("or enter BACK to go to Settings");
        }
    }
}
