package com.example.project;

import java.util.Scanner;
import java.util.regex.Matcher;

public class View {
    // username ro bayad az login begiram
    // meno dar vaghe profile khode yaroo e
    // profile kas dige ro bekhaym neshoon bedim usernamesho pas midim be hamoon tabe dige
    public static void run(String myUsername, Scanner scanner) {
        while (true) {
            String input = new String();
            input = scanner.nextLine();
            Matcher matcher;
//            if ((matcher = Commands.getMatcher(input, Commands.showUserProfile)) != null){
//                System.out.println(Controller.showProfile(matcher.group("username")));
//            }

            System.out.println("chats\tsettings");
            System.out.println(myUsername);
            System.out.println(Controller.showProfile(myUsername));
            // show posts
            if ((matcher = Commands.getMatcher(input, Commands.showFollowers)) != null){
                System.out.println(Controller.showFollowers(myUsername));
            }
            else if ((matcher = Commands.getMatcher(input, Commands.showFollowings)) != null){
                System.out.println(Controller.showFollowings(myUsername));
            }
            else if ((matcher = Commands.getMatcher(input, Commands.showChats)) != null){
                // tabe chata
                System.out.println("ok");
            }
            else if ((matcher = Commands.getMatcher(input, Commands.showSettings)) != null){
                SettingsView.run(scanner,myUsername);
            }

        }

    }
}
