package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.SQL.SQL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public Pane main = new Pane();
    public Pane menu = new Pane();
    public Pane master = new Pane();

    public Main() {
        main.setPrefWidth(1000);
        main.setPrefHeight(600);
        Creator.menuScale = 1.0;
        Creator.mainScale = 1.0;
        Creator.subScale = 1.0;
    }

    public void showLogin() throws IOException {
        Creator.subScale = Creator.mainScale;
        Node node;
        node = Creator.logIn();
        main.getChildren().clear();
        main.getChildren().add(node);
    }

    public void showSignIn() throws IOException {
        Creator.subScale = Creator.mainScale;
        Node node = Creator.signIn();
        main.getChildren().clear();
        main.getChildren().add(node);
    }

    public void showSignInDetail() throws IOException {
        Creator.subScale = Creator.mainScale;
        Node node = Creator.signInDetail();
        main.getChildren().clear();
        main.getChildren().add(node);
    }

    public void showSignUp() throws IOException {
        Creator.subScale = Creator.mainScale;
        Node node = Creator.signUp();
        main.getChildren().clear();
        main.getChildren().add(node);
    }

    public void showForgetPassword() throws IOException {
        Creator.subScale = Creator.mainScale;
        Node node = Creator.forgetPassword();
        main.getChildren().clear();
        main.getChildren().add(node);
    }

    public void exit() throws SQLException {
        SQL.insertAll(DataBase.getConnection());
        System.exit(0);
    }

    public void showChat() throws IOException {
        Node node = Creator.showChat(LiveState.chat);
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setChatMenu();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showGroup() throws IOException {
        Node node = Creator.showGroup(LiveState.group);
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setChatMenu();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void setMenuPane() throws IOException {
        Node node = Creator.showMenu();
        menu.getChildren().clear();
        menu.getChildren().add(node);
        main.getChildren().clear();
        main.getChildren().add(menu);
    }

    public void setChatMenu() throws IOException {
        Node node;
        switch (LiveState.chatMenuState) {
            case 1:
                node = Creator.showChatGroup();
                break;
            case 2:
                node = Creator.showJustChat();
                break;
            case 3:
                node = Creator.showJustGroup();
                break;
            default:
                node = Creator.showChatGroup();
                break;
        }
        menu.getChildren().clear();
        menu.getChildren().add(node);
        main.getChildren().clear();
        main.getChildren().add(menu);
    }

    public void setPosition() {
        main.getChildren().add(master);
        master.setLayoutX(400 * Creator.menuScale);
    }

    public void showCreatGroup() throws IOException {
        Node node = Creator.showCreatGroup();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setChatMenu();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void setMasterPane() {
        main.getChildren().clear();
        main.getChildren().add(master);
        master.setLayoutX(0.0);
    }

    public void showGroupInfo() throws IOException {
        Node node = Creator.showGroupInfo(LiveState.group);
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setChatMenu();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showSearchUser() throws IOException {
        Node node = Creator.showSearchUser();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showSearchMessage() throws IOException {
        Node node;
        if (LiveState.searchMState == 1) {
            node = Creator.showSearchMessage(LiveState.chat);
        } else {
            node = Creator.showSearchMessage(LiveState.group);
        }
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setChatMenu();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showAddMember() throws IOException {
        Node node = Creator.showAddMembers(LiveState.group);
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setChatMenu();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showGetMember() throws IOException {
        Node node = Creator.showGetMember();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setChatMenu();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showGetUser() throws IOException {
        Node node = Creator.showGetUser();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setChatMenu();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showProfile() throws IOException {
        Node node = Creator.showMyProfile();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showMoreNPost() throws IOException {
        Creator.setPost(LiveState.post);
        Node node = Creator.morePrivateUser();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showMoreBPost() throws IOException {
        Creator.setPost(LiveState.post);
        Node node = Creator.morePublicUser();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showMoreComment() throws IOException {
        Creator.setComment(LiveState.comment);
        Node node = Creator.moreComment();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showUser() throws IOException, InterruptedException {
        System.out.println(3);
        Node node = Creator.showOthersProfile(LiveState.user);
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showFollowings() throws IOException {
        Node node = Creator.showFollowingsOrFollowers(LiveState.user, "Followings");
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showFollowers() throws IOException {
        Node node = Creator.showFollowingsOrFollowers(LiveState.user, "Followers");
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showPost() throws IOException {
        Creator.setPost(LiveState.post);
        Node node = Creator.showFollowingsPosts();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showComment() throws IOException {
        Creator.setComment(LiveState.comment);
        Node node = Creator.viewComments();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showRequests() throws IOException {
        Node node = Creator.showRequests();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showSuggestions() throws IOException {
        Node node = Creator.showSuggestions();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showCreatPost() throws IOException {
        Node node = Creator.createPost();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showCreatComment() throws IOException {
        Creator.setPost(LiveState.post);
        Node node = Creator.createComment();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void showCG() throws IOException {
        setChatMenu();
        Pane pane = new Pane();
        pane.setPrefWidth(600*Creator.mainScale);
        pane.setPrefHeight(Creator.height);
        switch (DataBase.theme){
            case 1 : pane.setStyle("-fx-background-color: #0096ff");
            break;
            case 2 : pane.setStyle("-fx-background-color: #191970");
            break;
            case 3 : pane.setStyle("-fx-background-color: #f88379");
            break;
            case 4 : pane.setStyle("-fx-background-color: #4a0404");
            break;
        }
        master.getChildren().clear();
        master.getChildren().add(pane);
        if (LiveState.subState == 2) {
            setPosition();
        }
    }

    public void showViewPerDay() throws IOException {
        Node node = Creator.showViewers();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }
    public void showFirstPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("Michka.fxml"));
        Node node = fxmlLoader.load();
        main.getChildren().clear();
        main.getChildren().add(node);
    }
    public void showGetChatGroup() throws IOException {
        Node node = Creator.showGetChatGroup();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setChatMenu();
            setPosition();
        } else {
            setMasterPane();
        }
    }
    public void showChangeGroup() throws IOException {
        Node node = Creator.showChaneGroup();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setChatMenu();
            setPosition();
        } else {
            setMasterPane();
        }
    }
    public void showSetting() throws IOException {
        Node node = Creator.showSettings();
        main.getChildren().clear();
        main.getChildren().add(node);
    }
    public void showHome() throws IOException {
        Node node = Creator.viewFollowingPosts();
        master.getChildren().clear();
        master.getChildren().add(node);
        if (LiveState.subState == 1) {
            setMenuPane();
            setPosition();
        } else {
            setMasterPane();
        }
    }

    public void setWidth(double w) throws IOException, SQLException, InterruptedException {
        if (w < 600.0) {
            Creator.mainScale = w / 600;
            Creator.menuScale = w / 400;
            LiveState.subState = 2;
            main.setPrefWidth(w);
            menu.setPrefWidth(w);
            master.setPrefWidth(w);
        } else {
            Creator.mainScale = w / 1000;
            Creator.menuScale = w / 1000;
            LiveState.subState = 1;
            main.setPrefWidth(1000 * Creator.mainScale);
            master.setPrefWidth(600 * Creator.mainScale);
            menu.setPrefWidth(400 * Creator.menuScale);
        }
        refresh();
    }

    public void setHeight(double h) throws IOException, SQLException, InterruptedException {
        Creator.height = h;
        main.setPrefHeight(h);
        master.setPrefHeight(h);
        menu.setPrefHeight(h);
        refresh();
    }

    public void refresh() throws IOException, SQLException, InterruptedException {
        switch (LiveState.state) {
            case 0 :
                exit();
                break;
            case 1:
                showLogin();
                break;
            case 2:
                showSignIn();
                break;
            case 3:
                showForgetPassword();
                break;
            case 4:
                showSignUp();
                break;
            case 5:
                showSignInDetail();
                break;
            case 6:
                showHome();
                break;
            case 7:
                setMenuPane();
                break;
            case 8 :
                showSearchUser();
                break;
            case 9 :
                refreshCG();
                break;
            case 10 :
                showProfile();
                break;
            case 11 :
                showSetting();
                break;
            case 12 :
                showRequests();
                break;
            case 13 :
                showSuggestions();
                break;
            case 14 :
                showCreatPost();
                break;
            case 15 :
                showUser();
                break;
            case 16 :
                showFollowers();
                break;
            case 17 :
                showFollowings();
                break;
            case 18 :
                showViewPerDay();
                break;
            case 19 :
                showPost();
                break;
            case 20 :
                showComment();
                break;
            case 21 :
                showMoreBPost();
                break;
            case 22 :
                showMoreNPost();
                break;
            case 23 :
                showCreatComment();
                break;
            case 24 :
                showMoreComment();
                break;
            case 25 :
                showFirstPage();
                break;
        }
    }
    public void refreshCG() throws IOException {
        switch (LiveState.CGState){
            case 0 : showCG();
            break;
            case 1 : showChat();
            break;
            case 2 :
                switch (LiveState.groupState){
                    case 0 : showGroup();
                    break;
                    case 1 : showGroupInfo();
                    break;
                    case 2 : showGetMember();
                    break;
                    case 3 : //???Yadam nist!!!!
                        System.out.println("KOJAYIIII??");
                        break;
                    case 4 : showChangeGroup();
                    break;
                }
                break;
            case 3 : showGetUser();
            break;
            case 4 : showCreatGroup();
            break;
            case 5 : showAddMember();
            break;
            case 6 : showGetChatGroup();
                break;
            case 7 : //???Yadam nist!!!!
                System.out.println("KOSHIIII??");
                break;


        }
    }


}

