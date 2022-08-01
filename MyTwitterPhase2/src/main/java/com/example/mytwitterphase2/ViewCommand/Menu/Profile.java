package com.example.mytwitterphase2.ViewCommand.Menu;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.Controller.UserController;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.SQL.SQL;
import com.example.mytwitterphase2.ViewCommand.Show;
import com.example.mytwitterphase2.entity.Comment;
import com.example.mytwitterphase2.entity.Post;
import com.example.mytwitterphase2.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Profile {
    public static Scanner scan = DataBase.scanner;

    public static void showProfileMenu() throws SQLException {
        Show.showLongUser(DataBase.getUser());
        if(DataBase.getUser().isUserType()){
            System.out.println("Choose one of the options below:");
            System.out.println("1) See followers");
            System.out.println("2) See followings");
            System.out.println("3) See some post");
            System.out.println("4) Creat new post");
            System.out.println("5) See number of view page per day");
            System.out.println("6) Back");
            Show.printLine();
            switch (Show.inputProcessor(1,6)){
                case 1 : showFollowers();
                break;
                case 2 : showFollowing();
                break;
                case 3 : selectPost(1);
                break;
                case 4 : creatPost();
                break;
                case 5 : seeViewPage();
                break;
                case 6 : First.showFirstMenu();
                break;
            }
        } else {
            System.out.println("Choose one of the options below:");
            System.out.println("1) See followers");
            System.out.println("2) See followings");
            System.out.println("3) See some post");
            System.out.println("4) Creat new post");
            System.out.println("5) Back");
            Show.printLine();
            switch (Show.inputProcessor(1,5)){
                case 1 : showFollowers();
                    break;
                case 2 : showFollowing();
                    break;
                case 3 : selectPost(1);
                    break;
                case 4 : creatPost();
                    break;
                case 5 : First.showFirstMenu();
                    break;
            }
        }
    }
    public static void showFollowingPost() throws SQLException {
        ArrayList<Post> posts = new ArrayList<>();
        for (User u : DataBase.getUser().getFollowings()){
            posts.addAll(u.getPosts());
        }
        Show.showPostList(posts,0,10,0);
        Show.printLine();
        System.out.println("Choose one of the options below:");
        System.out.println("1) See some post");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 : selectPost(2);
            break;
            case 2 : First.showFirstMenu();
            break;
        }
    }

    public static void showSearchMenu() throws SQLException {
        Show.printLine();
        System.out.println("Enter name for search : ");
        String name = Show.getString();
        ArrayList<User> users = SQL.searchUser(name,DataBase.getConnection());
        Show.printLine();
        System.out.println("Result : ");
        Show.showUserList(users,0,10,0);
        System.out.println("Choose one of the options below:");
        System.out.println("1) See some user");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 : selectUser(1);
            break;
            case 2 : showProfileMenu();
            break;
        }
    }
    public static void showFollowing() throws SQLException {
        Show.printLine();
        System.out.println("Followings : ");
        Show.showUserFollowings(DataBase.getUser());
        System.out.println("Choose one of the options below:");
        System.out.println("1) See some user");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 : selectUser(1);
            break;
            case 2 : showProfileMenu();
            break;
        }
    }
    public static void showFollowers() throws SQLException {
        Show.printLine();
        System.out.println("Followers : ");
        Show.showUserFollowers(DataBase.getUser());
        System.out.println("Choose one of the options below:");
        System.out.println("1) See some user");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 : selectUser(2);
                break;
            case 2 : showProfileMenu();
                break;
        }
    }
    public static void showFollowing(User user,int n) throws SQLException {
        Show.printLine();
        Show.showUserFollowings(user);
        System.out.println("Choose one of the options below:");
        System.out.println("1) See some user");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 : selectUser(n);
                break;
            case 2 : showUser(user,n);
                break;
        }
    }
    public static void showFollowers(User user,int n) throws SQLException {
        Show.printLine();
        Show.showUserFollowers(user);
        System.out.println("Choose one of the options below:");
        System.out.println("1) See some user");
        System.out.println("2) Back");
        switch (Show.inputProcessor(1,2)){
            case 1 : selectUser(n);
                break;
            case 2 : showUser(user,n);
                break;
        }
    }
    public static void selectPost(int n) throws SQLException {
        Show.printLine();
        System.out.println("Enter ID of post or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getPosts().size());
        if(ID ==0 ){
            switch (n){
                case 1 : showProfileMenu();
                break;
                case 2 : showFollowingPost();
                break;
                case 3 : First.showAds();
                break;
            }
        } else {
            showPost(DataBase.getPosts().get(ID - 1),n);
        }
    }
    public static void selectUser(int n) throws SQLException {
        Show.printLine();
        System.out.println("Enter ID of user or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getUsers().size());
        if(ID ==0 ){
            switch (n){
                case 1 :showFollowing();
                break;
                case 2 : showFollowers();
                break;
                case 3 : First.showFollowRequest();
                break;
                case 4 : First.showSuggestedUsers();
                break;
                case 5 : showProfileMenu();
                    break;
                case 6 : showFollowingPost();
                    break;
                case 7 : First.showAds();
                    break;
            }
        } else {
            if(ID==DataBase.getUserID(DataBase.getUser())){
                showProfileMenu();
            } else {
                showUser(DataBase.getUsers().get(ID - 1), n);
            }
        }
    }
    public static void selectComment(Post post,int n) throws SQLException {
        Show.printLine();
        System.out.println("Enter ID of comment or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getComments().size());
        if(ID ==0 ){
            showPost(post,n);
        } else {
            showComment(DataBase.getComments().get(ID - 1),n);
        }
    }
    public static void selectComment(Comment comment,int n) throws SQLException {
        Show.printLine();
        System.out.println("Enter ID of comment or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getComments().size());
        if(ID ==0 ){
            showComment(comment,n);
        } else {
            showComment(DataBase.getComments().get(ID - 1),n);
        }
    }
    public static void creatPost() throws SQLException {
        System.out.println("Enter text :");
        String text = Show.getString();
        ControllerManager.post(DataBase.getUser(),text);
        System.out.println("Done");
        System.out.println("Enter anything for back");
        scan.nextLine();
        showProfileMenu();
    }
    public static void seeViewPage() throws SQLException {
        Show.printLine();
        ArrayList<String > dates = new ArrayList<>();
        dates.addAll(DataBase.getUser().getViewPD().keySet());
        Collections.sort(dates);
        for (String s : dates){
            System.out.println("Date : "+s + ", number of view : "+DataBase.getUser().getViewPD().get(s));
        }
        Show.printLine();
        System.out.println("Enter anything for back");
        scan.nextLine();
        showProfileMenu();
    }
    public static void showPost(Post post,int n) throws SQLException {
        Show.showLongPost(post);
        if (post.getUser().equals(DataBase.getUser())) {
            if(post.getUser().isUserType()){
                System.out.println("Choose one of the options below:");
                System.out.println("1) Edit post");
                System.out.println("2) Delete post");
                System.out.println("3) See some comment");
                System.out.println("4) See like");
                System.out.println("5) See number of like and view per day");
                System.out.println("6) Back");
                switch (Show.inputProcessor(1,6)){
                    case 1 : PostComment.editPost(post,n);
                    break;
                    case 2 : PostComment.deletePost(post,n);
                    break;
                    case 3 : selectComment(post,n);
                    break;
                    case 4 : PostComment.seeLike(post,n);
                    break;
                    case 5 : PostComment.seePD(post,n);
                    break;
                    case 6 :
                        switch (n){
                            case 1 : showProfileMenu();
                            break;
                            case 2 : showFollowingPost();
                            break;
                            case 3 : First.showAds();
                            break;
                        }
                    break;
                }
            } else {
                System.out.println("Choose one of the options below:");
                System.out.println("1) Edit post");
                System.out.println("2) Delete post");
                System.out.println("3) See some comment");
                System.out.println("4) See like");
                System.out.println("5) Back");
                switch (Show.inputProcessor(1,5)){
                    case 1 : PostComment.editPost(post,n);
                    break;
                    case 2 : PostComment.deletePost(post,n);
                    break;
                    case 3 : selectComment(post,n);
                    break;
                    case 4 : PostComment.seeLike(post,n);
                    break;
                    case 5 :
                        switch (n){
                            case 1 : showProfileMenu();
                                break;
                            case 2 : showFollowingPost();
                                break;
                            case 3 : First.showAds();
                                break;
                        }
                    break;
                }
            }
        } else {
            if ((!post.getUser().isPrivacy()) || DataBase.getUser().getFollowings().contains(post.getUser())) {
                if(post.getUserLikes().contains(DataBase.getUser())){
                    System.out.println("Choose one of the options below:");
                    System.out.println("1) See some comment");
                    System.out.println("2) See like");
                    System.out.println("3) Creat comment on post");
                    System.out.println("4) Dislike post");
                    System.out.println("5) Back");
                    switch (Show.inputProcessor(1, 5)) {
                        case 1: selectComment(post,n);
                            break;
                        case 2: PostComment.seeLike(post, n);
                            break;
                        case 3: PostComment.creatComment(post,n);
                            break;
                        case 4:
                            ControllerManager.dislikeP(DataBase.getUser(),post);
                            System.out.println("Disliked");
                            System.out.println("Enter anything for back to post");
                            scan.nextLine();
                            showPost(post,n);
                            break;
                        case 5:
                            switch (n) {
                                case 1: showProfileMenu();
                                    break;
                                case 2: showFollowingPost();
                                    break;
                                case 3: First.showAds();
                                    break;
                            }
                            break;
                    }
                } else {
                    System.out.println("Choose one of the options below:");
                    System.out.println("1) See some comment");
                    System.out.println("2) See like");
                    System.out.println("3) Creat comment on post");
                    System.out.println("4) Like post");
                    System.out.println("5) Back");
                    switch (Show.inputProcessor(1, 5)) {
                        case 1: selectComment(post,n);
                        break;
                        case 2: PostComment.seeLike(post, n);
                        break;
                        case 3: PostComment.creatComment(post,n);
                        break;
                        case 4:
                            ControllerManager.likeP(DataBase.getUser(),post);
                            System.out.println("Liked");
                            System.out.println("Enter anything for back to post");
                            scan.nextLine();
                            showPost(post,n);
                        break;
                        case 5:
                            switch (n) {
                                case 1: showProfileMenu();
                                break;
                                case 2: showFollowingPost();
                                break;
                                case 3: First.showAds();
                                break;
                            }
                        break;
                    }
                }
            } else {
                System.out.println("Enter anything for back");
                scan.nextLine();
                switch (n){
                    case 1 : showProfileMenu();
                    break;
                    case 2 : showFollowingPost();
                    break;
                    case 3 : First.showAds();
                    break;
                }
            }
        }
    }
    public static void showComment(Comment comment, int n) throws SQLException {
        Show.showLongComment(comment);
        if (comment.getUser().equals(DataBase.getUser())) {
            System.out.println("Choose one of the options below:");
            System.out.println("1) Edit comment");
            System.out.println("2) Delete comment");
            System.out.println("3) See some comment on this comment");
            System.out.println("4) See like");
            System.out.println("5) Back");
            switch (Show.inputProcessor(1,6)){
                case 1 : PostComment.editComment(comment,n);
                    break;
                case 2 : PostComment.deleteComment(comment,n);
                    break;
                case 3 : selectComment(comment,n);
                    break;
                case 4 : PostComment.seeLike(comment,n);
                    break;
                case 5 :
                    if(comment.isType()){
                        showPost(comment.getPost(),n);
                    } else {
                        showComment(comment.getComment(),n);
                    }
                    break;
            }
        } else {
            if ((!comment.getUser().isPrivacy()) || DataBase.getUser().getFollowings().contains(comment.getUser())) {
                if(comment.getUserLikes().contains(DataBase.getUser())){
                    System.out.println("Choose one of the options below:");
                    System.out.println("1) See some comment on this comment");
                    System.out.println("2) See like");
                    System.out.println("3) Creat comment on comment");
                    System.out.println("4) Dislike comment");
                    System.out.println("5) Back");
                    switch (Show.inputProcessor(1, 5)) {
                        case 1: selectComment(comment,n);
                            break;
                        case 2: PostComment.seeLike(comment, n);
                            break;
                        case 3: PostComment.creatComment(comment,n);
                            break;
                        case 4:
                            ControllerManager.dislikeC(DataBase.getUser(),comment);
                            System.out.println("Disliked");
                            System.out.println("Enter anything for back");
                            scan.nextLine();
                            showComment(comment,n);
                            break;
                        case 5:
                            if(comment.isType()){
                                showPost(comment.getPost(),n);
                            } else {
                                showComment(comment.getComment(),n);
                            }
                            break;
                    }
                } else {
                    System.out.println("Choose one of the options below:");
                    System.out.println("1) See some comment on this comment");
                    System.out.println("2) See like");
                    System.out.println("3) Creat comment on comment");
                    System.out.println("4) Like comment");
                    System.out.println("5) Back");
                    switch (Show.inputProcessor(1, 5)) {
                        case 1: selectComment(comment,n);
                            break;
                        case 2: PostComment.seeLike(comment, n);
                            break;
                        case 3: PostComment.creatComment(comment,n);
                            break;
                        case 4:
                            ControllerManager.likeC(DataBase.getUser(),comment);
                            System.out.println("Liked");
                            System.out.println("Enter anything for back");
                            scan.nextLine();
                            showComment(comment,n);
                            break;
                        case 5:
                            if(comment.isType()){
                                showPost(comment.getPost(),n);
                            } else {
                                showComment(comment.getComment(),n);
                            }
                            break;
                    }
                }
            } else {
                System.out.println("Enter anything for back");
                scan.nextLine();
                switch (n){
                    case 1 : showProfileMenu();
                        break;
                    case 2 : showFollowingPost();
                        break;
                    case 3 : First.showAds();
                        break;
                }
            }
        }
    }
    public static void showUser(User user,int n) throws SQLException {
        Show.showLongUser(user);
        System.out.println("Choose one of the options below:");
        System.out.println("1) Chat with user");
        if(DataBase.getUser().getFollowings().contains(user) || (!user.isPrivacy())){
            System.out.println("2) See Followers");
            System.out.println("3) See Followings");
            if(DataBase.getUser().getFollowings().contains(user) ){
                System.out.println("4) Unfollow");
            } else {
                if(user.getFollowings().contains(DataBase.getUser())){
                    System.out.println("4) Follow back");
                } else {
                    System.out.println("4) Follow");
                }
            }
            System.out.println("5) See some post");
            System.out.println("6) Back");
            switch (Show.inputProcessor(1,6)){
                case 1 : ChatGroup.newChat(user,n);
                break;
                case 2 : showFollowers(user,n);
                break;
                case 3 : showFollowing(user,n);
                break;
                case 4 :
                    if(DataBase.getUser().getFollowings().contains(user) ){
                        UserController.unFollow(DataBase.getUser(),user);
                        System.out.println("Unfollowed");
                    } else {
                        if(UserController.follow(DataBase.getUser(),user)==1){
                            System.out.println("You are blocked by user");
                        }
                    }
                    System.out.println("Enter anything for back to user");
                    scan.nextLine();
                    showUser(user,n);
                    break;
                case 5 : selectPost(n);
                break;
                case 6 :
                    switch (n){
                        case 1 :showFollowing();
                            break;
                        case 2 : showFollowers();
                            break;
                        case 3 : First.showFollowRequest();
                            break;
                        case 4 : First.showSuggestedUsers();
                            break;
                        case 5 : showProfileMenu();
                            break;
                        case 6 : showFollowingPost();
                            break;
                        case 7 : First.showAds();
                            break;
                    }
                    break;
            }
        } else if(DataBase.getUser().getRequests().contains(user)) {
            System.out.println("2) Take back request");
            System.out.println("3) Back");
            switch (Show.inputProcessor(1,3)){
                case 1 : ChatGroup.newChat(user,n);
                break;
                case 2 :
                    UserController.unRequest(DataBase.getUser(),user);
                    System.out.println("Request back");
                    System.out.println("Enter anything for back to user");
                    scan.nextLine();
                    showUser(user,n);
                    break;
                case 3 :
                    switch (n){
                        case 1 :showFollowing();
                            break;
                        case 2 : showFollowers();
                            break;
                        case 3 : First.showFollowRequest();
                            break;
                        case 4 : First.showSuggestedUsers();
                            break;
                        case 5 : showProfileMenu();
                            break;
                        case 6 : showFollowingPost();
                            break;
                        case 7 : First.showAds();
                            break;
                    }
                    break;
            }
        } else {
            System.out.println("2) Take Request");
            System.out.println("3) Back");
            switch (Show.inputProcessor(1,3)){
                case 1 : ChatGroup.newChat(user,n);
                    break;
                case 2 :
                    UserController.follow(DataBase.getUser(),user);
                    System.out.println("Requested");
                    System.out.println("Enter anything for back to user");
                    scan.nextLine();
                    showUser(user,n);
                    break;
                case 3 :
                    switch (n){
                        case 1 :showFollowing();
                            break;
                        case 2 : showFollowers();
                            break;
                        case 3 : First.showFollowRequest();
                            break;
                        case 4 : First.showSuggestedUsers();
                            break;
                        case 5 : showProfileMenu();
                            break;
                        case 6 : showFollowingPost();
                            break;
                        case 7 : First.showAds();
                            break;
                    }
                    break;
            }
        }
    }
}
