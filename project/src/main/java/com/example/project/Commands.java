package com.example.project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {
    showUserProfile ("\\s*show\\s*(?<username>\\S*)\\s*"),
    showFollowers ("\\s*show\\s*followers\\s*"),
    showFollowings ("\\s*show\\s*followings\\s*"),
    showChats ("\\s*show\\s*chats"),
    showSettings ("\\s*settings\\s*"),
    editUsername ("\\s*edit\\s*username\\s*"),
    editName ("\\s*edit\\s*name\\s*"),
    editLastName ("\\s*edit\\s*last\\s*name\\s*"),
    editBio("\\s*edit\\s*bio\\s*"),
    editEmail("\\s*edit\s*email\\s*"),
    editBirthday("\\s*edit\\s*birthday\\s*"),
    editPassword("\\s*edit\\s*password\\s*"),
    back("\\s*back\\s*");

    private final String regex;

    Commands(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, Commands command) {
        Matcher matcher = Pattern.compile(command.regex).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
