package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.Controller.UserController;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.Image;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Creator {
    public static double mainScale;
    public static double menuScale;
    public static double subScale;

    public static String string;
    public static String string1;
    public static String string2;
    public static String string3;
    public static Image image;
    public static boolean aBoolean;
    public static boolean bBoolean;
    public static Message m;
    public static double size;
    public static double height;
    public static Chat c;
    public static Group g;
    public static User u;
    public static Post p;
    public static ArrayList<User> selectedUsers = new ArrayList<>();

    public static Node showShortChat(Chat chat, double s) throws IOException {
        subScale = s;
        Node node;
        User user = ControllerManager.getSecUserChat(chat);
        string = user.getUserName();
        Collections.sort(chat.getMessages());
        Message message = chat.getMessages().get(0);
        if (ControllerManager.getMessageUser(message).equals(DataBase.getUser())) {
            string1 = "You : " + message.getText();
            aBoolean = true;
        } else {
            string1 = string + " : " + message.getText();
            if (message.isSeen()) {
                aBoolean = true;
            } else {
                aBoolean = false;
            }
        }
        image = user.getProfileImage();
        c = chat;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ShortChat.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showShortGroup(Group group, double s) throws IOException {
        subScale = s;
        Node node;
        string = group.getName();
        Collections.sort(group.getMessages());
        Message message = group.getMessages().get(0);
        if (ControllerManager.getMessageUser(message).equals(DataBase.getUser())) {
            string1 = "You : " + message.getText();
        } else {
            string1 = ControllerManager.getMessageUser(message).getUserName() + " : " + message.getText();
        }
        image = group.getProfileImage();
        g = group;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ShortGroup.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showMessage(Message message, double s) throws IOException {
        subScale = s;
        Node node;
        string = message.getUser().getUserName();
        string1 = message.getText();
        m = message;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/Message.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showMessageR(Message message, double s) throws IOException {
        subScale = s;
        Node node;
        string = message.getUser().getUserName();
        aBoolean = message.isSeen();
        string1 = message.getText();
        m = message;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/MessageR.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showShortMessage(Message message, double s) throws IOException {
        subScale = s;
        Node node;
        aBoolean = ControllerManager.getMessageUser(message).equals(DataBase.getUser());
        m = message;
        image = ControllerManager.getMessageUser(message).getProfileImage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ShortMessage.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showReplyMessage(Message message, double s) throws IOException {
        subScale = s;
        Node node;
        string = message.getUser().getUserName();
        string1 = message.getText();
        string2 = message.getMessage().getUser().getUserName();
        string3 = message.getMessage().getText();
        m = message;

        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ReplyMessage.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showReplyMessageR(Message message, double s) throws IOException {
        subScale = s;
        Node node;
        string = message.getUser().getUserName();
        string1 = message.getText();
        string2 = message.getMessage().getUser().getUserName();
        string3 = message.getMessage().getText();
        aBoolean = message.isSeen();
        m = message;

        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ReplyMessageR.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showForwardMessage(Message message, double s) throws IOException {
        subScale = s;
        Node node;
        string2 = message.getUser().getUserName();
        string1 = message.getText();
        string = message.getForwarder().getUserName();
        m = message;

        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ForwardMessage.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showForwardMessageR(Message message, double s) throws IOException {
        subScale = s;
        Node node;
        string2 = message.getUser().getUserName();
        string1 = message.getText();
        aBoolean = message.isSeen();
        string = message.getForwarder().getUserName();
        m = message;

        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ForwardMessageR.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showChat(Chat chat) throws IOException {
        c = chat;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ChatF.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showGroup(Group group) throws IOException {
        g = group;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/GroupF.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showSearchMessage(Chat chat) throws IOException {
        c = chat;
        aBoolean = false;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/SearchMessage.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showSearchMessage(Group group) throws IOException {
        g = group;
        aBoolean = false;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/SearchMessage.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showChatGroup() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("ChatGroupF.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showJustChat() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("JustChat.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showJustGroup() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("JustGroup.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showGroupInfo(Group group) throws IOException {
        g = group;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GroupInfo.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showSearchUser() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("SearchUser.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showAddMembers(Group group) throws IOException {
        g = group;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("AddMembers.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showCreatGroup() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("CreatGroup.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showGetMember() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GetMember.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showGetUser() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GetUser.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showChaneGroup() throws IOException {
        Creator.g = LiveState.group;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("ChangeGroup.fxml"));
        node = fxmlLoader.load();
        return node;
    }
    public static Node showGetChatGroup() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GetChatGroup.fxml"));
        node = fxmlLoader.load();
        return node;
    }
    //Tina----------------------------------------------------------------------------------------------
    //Tina----------------------------------------------------------------------------------------------
    //Tina----------------------------------------------------------------------------------------------
    private static User othersProfileHeaderUser;
    private static User shortUser;
    private static User requestShortUser;
    private static User userToShow;
    private static String followerOrFollowing;

    public static Node showSettings() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Setting.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showOthersProfile(User user) throws IOException {
        othersProfileHeaderUser = user;
        if (DataBase.getUser().getUserType() == true) {
            UserController.view(user, DataBase.getUser());
        }
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("OthersProfile.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showMyProfile() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("MyProfile.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showShortUser(User user, double s) throws IOException {
        shortUser = user;
        subScale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObjects/ShortUser.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showRequestShortUser(User user, double s) throws IOException {
        requestShortUser = user;
        subScale = s;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObjects/ShortRequest.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showFollowingsOrFollowers(User user, String s) throws IOException {
        followerOrFollowing = s;
        userToShow = user;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("Followings.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showRequests() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("Requests.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showViewers() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("ViewsPerDay.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showSuggestions() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("Suggestions.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showMenu() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("Menu.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static User getOthersProfileHeaderUser() {
        return othersProfileHeaderUser;
    }

    public static User getShortUser() {
        return shortUser;
    }


    public static User getUserToShow() {
        return userToShow;
    }

    public static String getFollowerOrFollowing() {
        return followerOrFollowing;
    }

    public static User getRequestShortUser() {
        return requestShortUser;
    }

    public static void setOthersProfileHeaderUser(User user) {
        othersProfileHeaderUser = user;
    }


    //Heliya-------------------------------------------------------------------------------------------------------
    //Heliya-------------------------------------------------------------------------------------------------------
    //Heliya-------------------------------------------------------------------------------------------------------
    //Heliya-------------------------------------------------------------------------------------------------------
    public static String setUsername;
    public static String setPassword;
    public static String setQuestion;


    public static Node forgetPassword() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("ForgetPassword.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node logIn() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("LogIn.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node signIn() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("SignIn.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node signInDetail() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("SignInDetail.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node signUp() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("SignUp.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    //Heliya222-------------------------------------------------------------------------------------------------------
    //Heliya222-------------------------------------------------------------------------------------------------------
    //Heliya222-------------------------------------------------------------------------------------------------------

    public static Post post;
    public static Comment comment;
    static int type = 0;
    static User user;
    static Double usersPostVBox;

    public static void setType(int type) {
        Creator.type = type;
    }

    public static void setPost(Post post) {
        Creator.post = post;
    }

    public static void setComment(Comment comment) {
        Creator.comment = comment;
    }

    public static Node showUserPosts() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("ShowUsersPost.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node showFollowingsPosts() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("ShowFollowingsPost.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node viewPosts() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("ViewPosts.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node viewComments() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("ViewComments.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node morePublicUser() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("MoreTextPost.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node morePrivateUser() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("MoreImagePost.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node moreComment() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("MoreComment.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node createPost() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("CreatePost.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node createComment() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("CreateComment.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public static Node viewFollowingPosts() throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("ViewFollowingPosts.fxml"));
        node = fxmlLoader.load();
        return node;
    }



}
