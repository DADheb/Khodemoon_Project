package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.FXMLController.Objects.TextCommentController;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.Comment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class ViewCommentsController implements Initializable {
    @FXML
    private ScrollPane mainPane;
    @FXML
    private AnchorPane anchorPane;
    public VBox myVBox;
    @FXML
    private Text seeText;
    @FXML
    private Button backButton;

    private Color themeColor;
    private Color mode;
    private Color opposite;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.mainScale);
        try{
            this.myVBox.setPrefHeight(myVBox.getPrefHeight() + 420 * Creator.mainScale);
            this.myVBox.getChildren().add( addComment(Creator.comment));
            Collections.sort(Creator.comment.getComments());
            for (int i = 0; i < Creator.comment.getComments().size(); i++) {
                this.myVBox.setPrefHeight(myVBox.getPrefHeight() + 420 * Creator.mainScale);
                this.anchorPane.setPrefHeight(anchorPane.getPrefHeight() + 420 * Creator.mainScale);
                this.myVBox.getChildren().add( addComment (Creator.comment.getComments().get(i)));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initial(double scale) {
        theme();
        myVBox.setPrefHeight(0.0);
        anchorPane.setPrefHeight(59.0 * scale);
        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.anchorPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.mainPane.setPrefWidth(600 * scale);
        this.anchorPane.setPrefWidth(600 * scale);
        this.mainPane.setPrefHeight(600 * scale);
        this.anchorPane.setPrefHeight(600 * scale);;
        this.myVBox.setPrefWidth(600 * scale);
        this.myVBox.setPrefHeight(600 * scale);
        this.myVBox.setStyle("-fx-background-color: #" + mode.toString().substring(2));

        this.seeText.setFill(themeColor);
        this.seeText.setFont(Font.font(30D * scale));
        this.seeText.setLayoutX (81d* scale);
        this.seeText.setLayoutY(45d * scale);

        this.backButton.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.backButton.setTextFill(mode);
        this.backButton.setFont(Font.font(20D * scale));
        this.backButton.setLayoutX (469d* scale);
        this.backButton.setLayoutY(14d * scale);
        this.backButton.setPrefWidth(91d * scale);
        this.backButton.setPrefHeight(40d * scale);


    }

    public void theme() {
        switch (DataBase.theme) {
            case 1:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.WHITE;
                this.opposite = Color.BLACK;
                break;
            case 2:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.BLACK;
                this.opposite = Color.WHITE;
                break;
            case 3:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.WHITE;
                this.opposite = Color.BLACK;
                break;
            case 4:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.BLACK;
                this.opposite = Color.WHITE;
                break;
        }
    }

    @FXML
    protected void onBackClicked (ActionEvent e) throws IOException {
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

    public Node addComment(Comment comment) throws IOException {
        Creator.comment = comment;
        Node node;
        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/TextComment.fxml"));
        node = fxmlLoader.load();
        return node;
    }
}
