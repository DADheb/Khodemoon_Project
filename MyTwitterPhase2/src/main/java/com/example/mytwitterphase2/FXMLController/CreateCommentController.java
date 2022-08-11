package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.entity.Comment;
import com.example.mytwitterphase2.entity.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateCommentController implements Initializable {
    // صفحه ای که برا کامنت گذاشتن باز میشه
    @FXML
    private ScrollPane mainPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Text mainText;
    @FXML
    private Text textText;
    @FXML
    private TextArea textArea;
    @FXML
    private ImageView twitterImg;
    @FXML
    private ImageView twitterImgP;
    @FXML
    private Button doneButton;

    private Color themeColor;
    private Color mode;
    private  int type = Creator.type ;
    private Comment comment;
    private Post post;
    // 0: comment on post  1: comment on comment

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.mainScale);

        if(DataBase.theme == 1) {
            this.textArea.setStyle("-fx-control-inner-background:White; -fx-font-family: Consolas; -fx-highlight-fill: #78a1d1; -fx-highlight-text-fill: #78a1d1; -fx-text-fill: #78a1d1; ");
        }
        if(DataBase.theme == 2){
            this.textArea.setStyle("-fx-control-inner-background:Black; -fx-font-family: Consolas; -fx-highlight-fill: #78a1d1; -fx-highlight-text-fill: #78a1d1; -fx-text-fill: #78a1d1; ");
        }
    }
    public void initial(double scale) {
        theme();
        this.mainText.setFill(themeColor);
        this.mainText.setLayoutX (139* scale);
        this.mainText.setLayoutY(261 * scale);
        this.mainText.setFont(Font.font(30D * scale));

        this.textText.setFill(themeColor);
        this.textText.setLayoutX (128* scale);
        this.textText.setLayoutY(350 * scale);
        this.textText.setFont(Font.font(27D * scale));

        this.doneButton.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.doneButton.setTextFill(mode);
        this.doneButton.setFont(Font.font(20D * scale));
        this.doneButton.setLayoutX (146* scale);
        this.doneButton.setLayoutY(439 * scale);
        this.doneButton.setPrefWidth(113d * scale);
        this.doneButton.setPrefHeight(40d * scale);

        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.anchorPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.mainPane.setPrefWidth(600 * scale);
        this.anchorPane.setPrefWidth(600 * scale);
        this.mainPane.setPrefHeight(600 * scale);
        this.anchorPane.setPrefHeight(600 * scale);

        if(DataBase.theme > 2) {
            this.textArea.setStyle("-fx-control-inner-background: #" + mode.toString().substring(2) + ";-fx-font-family: Consolas; -fx-highlight-fill:" + themeColor.toString().substring(2) + ";-fx-highlight-fill:" + themeColor.toString().substring(2) + "; -fx-text-fill:" + themeColor.toString().substring(2));
        }
        this.textArea.setPrefWidth(280d * scale);
        this.textArea.setPrefHeight(98d * scale);
        this.textArea.setFont(Font.font(20D * scale));
        this.textArea.setLayoutX(192 * scale);
        this.textArea.setLayoutY(320 * scale);

        this.twitterImg.setLayoutX(214d * scale);
        this.twitterImg.setLayoutY(0d * scale);
        this.twitterImg.setFitHeight(181d * scale);
        this.twitterImg.setFitWidth(175d * scale);

        this.twitterImgP.setLayoutX(198d * scale);
        this.twitterImgP.setLayoutY(-16d * scale);
        this.twitterImgP.setFitHeight(273d * scale);
        this.twitterImgP.setFitWidth(208d * scale);

    }

    public void theme() {
        switch (DataBase.theme) {
            case 1:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.WHITE;
                twitterImgP.setVisible(false);
                break;
            case 2:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.BLACK;
                twitterImgP.setVisible(false);
                break;
            case 3:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.WHITE;
                twitterImg.setVisible(false);
                break;
            case 4:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.BLACK;
                twitterImg.setVisible(false);
                break;
        }
    }

    @FXML
    protected void onDoneClicked (ActionEvent e) throws IOException {
        String text = textArea.getText();
        if(!text.isEmpty()){
            Comment newComment ;
            if(type == 0){
                this.post = Creator.post;
                 newComment = ControllerManager.commentOnPost(Creator.post.getUser(),text,post);
            }
            else{
                this.comment = Creator.comment;
                newComment = ControllerManager.commentOnComment(Creator.post.getUser(),text,comment);
            }
            LiveState.comment = newComment;
            if(LiveState.comment.isType()){
                LiveState.post = LiveState.comment.getPost();
                LiveState.state = 19;
                DataBase.main.showPost();
            } else {
                LiveState.comment = LiveState.comment.getComment();
                LiveState.state = 20;
                DataBase.main.showComment();
            }
        }
    }
}
