package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Objects.ImagePostController;
import com.example.mytwitterphase2.FXMLController.Objects.TextCommentController;
import com.example.mytwitterphase2.FXMLController.Objects.TextPostController;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Comment;
import com.example.mytwitterphase2.entity.Post;
import com.example.mytwitterphase2.entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Stream;

public class Suggestions implements Initializable {
    @FXML
    private ScrollPane suggestionScrollPane;
    @FXML
    private Pane topPane;
    @FXML
    private ImageView backImage;
    @FXML
    private Label titleL;
    @FXML
    private VBox mainVBox;
    private double scale;
    private Color themeColor;
    private Color mode;
    private Image image;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.scale = Creator.mainScale;
        initial();
        ArrayList<Post> myPosts = showAds(DataBase.getUser());
        ArrayList<User> myUsers = showInterestUser(DataBase.getUser());
        try {
            for (int i = 0; i < myUsers.size(); i++) {
                this.mainVBox.setPrefHeight(mainVBox.getPrefHeight() + 90 * scale);
                this.mainVBox.getChildren().add(addUser(myUsers.get(i)));
            }
            for (int i = 0; i < myPosts.size(); i++) {
                this.mainVBox.setPrefHeight(mainVBox.getPrefHeight() + 420 * scale);
                this.mainVBox.getChildren().add(addPost(myPosts.get(i)));
                for (int j = 0; j < myPosts.get(i).getComments().size(); j++) {
                    this.mainVBox.setPrefHeight(mainVBox.getPrefHeight() + 420 * scale);
                    this.mainVBox.getChildren().add(addComment(myPosts.get(i).getComments().get(j)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initial() {
        theme();
        suggestionScrollPane.setPrefWidth(600 * scale);
        suggestionScrollPane.setPrefHeight(600 * scale);
        mainVBox.setPrefWidth(600 * scale);
        topPane.setPrefWidth(600 * scale);
        topPane.setPrefHeight(50 * scale);
        titleL.setFont(Font.font(24 * scale));
        titleL.setLayoutX(239 * scale);
        titleL.setLayoutY(11 * scale);
        backImage.setLayoutX(14 * scale);
        backImage.setLayoutY(4 * scale);
        backImage.setFitWidth(43 * scale);
        backImage.setFitHeight(48 * scale);
        if (LiveState.subState == 1) {
            backImage.setVisible(false);
        } else {
            backImage.setVisible(true);
        }

        topPane.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));
        titleL.setTextFill(mode);
    }

    public Node addPost(Post post) throws IOException {
        Creator.post = post;
        Node node;
        if (post.getPostType() != 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/ImagePost.fxml"));
            node = fxmlLoader.load();
            return node;
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/TextPost.fxml"));
            node = fxmlLoader.load();
            return node;
        }
    }

    public Node addComment(Comment comment) throws IOException {
        Creator.comment = comment;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/TextComment.fxml"));
        node = fxmlLoader.load();
        return node;
    }

    public Node addUser(User user) throws IOException {
        return Creator.showShortUser(user, this.scale);
    }

    public ArrayList<Post> showAds(User u) {
        User[] users = new User[u.getInterestAD().size()];
        int[] ints = new int[u.getInterestAD().size()];
        int sh=0;
        for (User uu : u.getInterestAD().keySet()){
            users[sh] = uu;
            ints[sh] = u.getInterestAD().get(uu);
            sh++;
        }
        bubbleSort(ints,users,u.getInterestAD().size());
        int size = u.getInterestAD().size();
        int limit = Math.min(size, 5);
        ArrayList<Post> posts = new ArrayList<>();
        for (int i = size - 1; i >= size - limit; i--) {
            User user = users[i];
            for (Post p : user.getPosts()) {
                if (!p.getUserLikes().contains(u)) {
                    posts.add(p);
                }
            }
        }
        limit = Math.min(posts.size(), 5);
        ArrayList<Post> selectedPosts = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            selectedPosts.add(posts.get(i));
        }
        Collections.sort(DataBase.getPosts());
        int number = 0;
        for (Post p : DataBase.getPosts()) {
            if (p.getUser().equals(u)) {
                continue;
            }
            if (p.getUserLikes().contains(u)) {
                continue;
            }
            if (posts.contains(p)) {
                continue;
            }
            number++;
        }
        int n = Math.min(5 - limit, number);
        int i = 0;
        while (n > 0) {
            Post p = DataBase.getPosts().get(i);
            if (p.getUser().equals(u)) {
                i++;
                continue;
            }
            if (p.getUserLikes().contains(u)) {
                i++;
                continue;
            }
            if (posts.contains(p)) {
                i++;
                continue;
            }
            n--;
            selectedPosts.add(p);
        }
        return selectedPosts;
    }

    public ArrayList<User> showInterestUser(User u) {
        User[] users = new User[u.getInterest().size()];
        int[] ints = new int[u.getInterest().size()];
        int sh=0;
        for (User uu : u.getInterest().keySet()){
            users[sh] = uu;
            ints[sh] = u.getInterest().get(uu);
            sh++;
        }
        bubbleSort(ints,users,u.getInterest().size());
        int size = u.getInterest().size();
        int limit = Math.min(size, 5);
        ArrayList<User> selectedUsers = new ArrayList<>();
        for (int i = size - 1; i >= size - limit; i--) {
            selectedUsers.add(users[i]);
        }
        limit = Math.min(5 - limit, DataBase.getUsers().size() - 1 - limit);
        Collections.sort(DataBase.getUsers());
        for (int i = 0; i < limit; i++) {
            if (DataBase.getUsers().get(i).equals(u)) {
                selectedUsers.add(DataBase.getUsers().get(limit));
            } else {
                selectedUsers.add(DataBase.getUsers().get(i));
            }
        }
        return selectedUsers;
    }


    public void theme() {
        switch (DataBase.theme) {
            case 1:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackDark.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 2:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 3:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackDark.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 4:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
        }
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 7;
        DataBase.main.setMenuPane();
    }

    public LinkedHashMap<User, Integer> sortHashMapByValue(HashMap<User,Integer> hashMap) {
        List<User> mapKeys = new ArrayList<>(hashMap.keySet());
        List<Integer> mapValues= new ArrayList<>(hashMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<User, Integer> sortedMap = new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()){
            Integer integer = valueIt.next();
            Iterator<User> keyIt = mapKeys.iterator();
            while (keyIt.hasNext()){
                User u = keyIt.next();
                Integer comp1 = hashMap.get(u);
                Integer comp2 = integer;
                if (comp1.equals(comp2)){
                    keyIt.remove();
                    sortedMap.put(u,integer);
                    break;
                }
            }
        }
        return sortedMap;
    }
    public static void bubbleSort(int [] sort_arr,User[] users, int len){

        for (int i=0;i<len-1;++i){

            for(int j=0;j<len-i-1; ++j){

                if(sort_arr[j+1]<sort_arr[j]){

                    int swap = sort_arr[j];
                    sort_arr[j] = sort_arr[j+1];
                    sort_arr[j+1] = swap;
                    User temp = users[j];
                    users[j] = users[j+1];
                    users[j+1] = temp;

                }
            }
        }
    }
}
