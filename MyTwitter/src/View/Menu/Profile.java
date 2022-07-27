package View.Menu;

import Controller.ControllerManager;
import Controller.PostController;
import DataBase.DataBase;
import View.Show;
import entity.Comment;
import entity.Post;
import entity.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Profile {
    public static Scanner scan = DataBase.scanner;

    public static void showProfileMenu(){
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
    public static void showFollowingPost(){
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
            case 2 : showProfileMenu();
            break;
        }
    }

    public static void showSearchMenu(){
        //-------------------------------------------------------------------------------
    }
    public static void showFollowing(){
        Show.printLine();
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
    public static void showFollowers(){
        Show.printLine();
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
    public static void selectPost(int n){
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
    public static void selectUser(int n){
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
            }
        } else {
            showUser(DataBase.getUsers().get(ID - 1),n);
        }
    }
    public static void selectComment(Post post,int n){
        Show.printLine();
        System.out.println("Enter ID of comment or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getComments().size());
        if(ID ==0 ){
            showPost(post,n);
        } else {
            showComment(DataBase.getComments().get(ID - 1),n);
        }
    }
    public static void selectComment(Comment comment,int n){
        Show.printLine();
        System.out.println("Enter ID of comment or 0 for back: ");
        int ID = Show.inputProcessor(0,DataBase.getComments().size());
        if(ID ==0 ){
            showComment(comment,n);
        } else {
            showComment(DataBase.getComments().get(ID - 1),n);
        }
    }
    public static void creatPost(){
        //-------------------------------------------------------------------------------
    }
    public static void seeViewPage(){
        Show.printLine();
        Stream<Map.Entry<String, Integer>> sorted = DataBase.getUser().getViewPD().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey());
        String[] dates = (String[]) sorted.toArray();
        for (String s : dates){
            System.out.println("Date : "+s + ", number of view : "+DataBase.getUser().getViewPD().get(s));
        }
        Show.printLine();
        System.out.println("Enter anything for back");
        scan.nextLine();
        showProfileMenu();
    }
    public static void showPost(Post post,int n){
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
    public static void showComment(Comment comment, int n){
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
    public static void showUser(User user,int n){
        //-------------------------------------------------------------------------------
    }
}
