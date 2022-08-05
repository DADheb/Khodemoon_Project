package com.example.demotwitterpost;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewCommentsController implements Initializable {
    @FXML
    private ScrollPane mainPane;
    public VBox myVBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            this.myVBox.getChildren().add((Pane) addComment(Creator.comment));
            for (int i = 0; i < Creator.post.getComments().size(); i++) {
                this.myVBox.getChildren().add((Pane) addComment (Creator.comment.getComments().get(i)));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public Node addComment(Comment comment) throws IOException {
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TextComment.fxml"));
        TextCommentController textCommentController = fxmlLoader.getController();
        textCommentController.fillComment(comment, Creator.scale);
        node = fxmlLoader.load();
        return node;
    }
}

//    @FXML
//    private ScrollPane mainPane;
//    @FXML
//    private AnchorPane anchorPane;
//    @FXML
//    private ListView commentList;
//
//    private Color themeColor;
//    private Color mode;
//    private String username;
//    private String text;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        this.mainPane.widthProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//                initial(Creator.scale);
//            }
//        });
//    }
//
//    public void initial(double scale) {
//        theme();
//        this.mainPane.setPrefWidth(600 * scale);
//        this.anchorPane.setPrefWidth(600 * scale);
//        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
//        this.anchorPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
//
//        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
//        this.anchorPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
//        // ویو لیستشو گفتی نزنم
//
//    }
//
//    public void theme() {
//        switch (DataBase.getTheme()) {
//            case 1:
//                this.themeColor = Color.rgb(120, 161, 209);
//                this.mode = Color.WHITE;
//                break;
//            case 2:
//                this.themeColor = Color.rgb(120, 161, 209);
//                this.mode = Color.BLACK;
//                break;
//            case 3:
//                this.themeColor = Color.rgb(225, 121, 173);
//                this.mode = Color.WHITE;
//                break;
//            case 4:
//                this.themeColor = Color.rgb(225, 121, 173);
//                this.mode = Color.BLACK;
//                break;
//        }
//    }
//
//    public void fillComments (ArrayList<Comment> myComments){
//        for (int i = 0; i < myComments.size(); i++) {
//            username = myComments.get(i).getUser().getUserName();
//            text = myComments.get(i).getText();
//            commentList.getItems().add(username + " : " + text);
//        }
//    }
//    @FXML
//    protected void onCommentClicked (MouseEvent e) throws IOException {
//        //todo بره صفحه کامنت!
//    }

