package com.example.demotwitterpost;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MoreCommentController implements Initializable {

    @FXML
    private ScrollPane mainPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextArea textArea;
    @FXML
    private Text editText;
    @FXML
    private Text commentText;
    @FXML
    private Button doneButton;
    @FXML
    private Button deleteButton;

    private Color themeColor;
    private Color mode;
    private Color opposite;
    private Image image;
    private Comment comment;
    private Double scale = 0.5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.scale);
        this.comment = Creator.comment;
        textArea.setText(comment.getText());
        if(DataBase.getTheme() == 1) {
            this.textArea.setStyle("-fx-control-inner-background:White; -fx-font-family: Consolas; -fx-highlight-fill: #78a1d1; -fx-highlight-text-fill: #78a1d1; -fx-text-fill: #78a1d1; ");
        }
        if(DataBase.getTheme() == 2){
            this.textArea.setStyle("-fx-control-inner-background:Black; -fx-font-family: Consolas; -fx-highlight-fill: #78a1d1; -fx-highlight-text-fill: #78a1d1; -fx-text-fill: #78a1d1; ");
        }
    }

    public void initial(double scale) {
        theme();
        this.mainPane.setPrefWidth(600 * scale);
        this.anchorPane.setPrefWidth(600 * scale);
        this.mainPane.setPrefHeight(450 * scale);
        this.anchorPane.setPrefHeight(450 * scale);
        this.mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        this.anchorPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));

        if(DataBase.getTheme() > 2) {
            this.textArea.setStyle("-fx-control-inner-background: #" + mode.toString().substring(2) + ";-fx-font-family: Consolas; -fx-highlight-fill:" + themeColor.toString().substring(2) + ";-fx-highlight-fill:" + themeColor.toString().substring(2) + "; -fx-text-fill:" + themeColor.toString().substring(2));
        }
        this.textArea.setPrefWidth(350d * scale);
        this.textArea.setPrefHeight(152d * scale);
        this.textArea.setFont(Font.font(20D * scale));
        this.textArea.setLayoutX(120d * scale);
        this.textArea.setLayoutY(110d * scale);

        this.editText.setFill(themeColor);
        this.editText.setLayoutX (120d* scale);
        this.editText.setLayoutY(104d * scale);
        this.editText.setFont(Font.font(18D * scale));

        this.commentText.setFill(themeColor);
        this.commentText.setLayoutX (159d* scale);
        this.commentText.setLayoutY(62d * scale);
        this.commentText.setFont(Font.font(30D * scale));

        this.doneButton.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.doneButton.setTextFill(mode);
        this.doneButton.setFont(Font.font(20D * scale));
        this.doneButton.setLayoutX (307d* scale);
        this.doneButton.setLayoutY(314d * scale);
        this.doneButton.setPrefWidth(237d * scale);
        this.doneButton.setPrefHeight(53d * scale);

        this.deleteButton.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.deleteButton.setTextFill(mode);
        this.deleteButton.setFont(Font.font(20D * scale));
        this.deleteButton.setLayoutX (40d* scale);
        this.deleteButton.setLayoutY(314d * scale);
        this.deleteButton.setPrefWidth(237d * scale);
        this.deleteButton.setPrefHeight(53d * scale);
    }

    public void theme() {
        switch (DataBase.getTheme()) {
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
    protected void onDoneClicked (ActionEvent e) throws IOException {
        Creator.setComment(comment);
        String newText = textArea.getText();
        if(!newText.isEmpty()) {
            CommentManager.editText(comment, newText);
        }

    }

    @FXML
    protected void onDeleteClicked (ActionEvent e) throws IOException {
        Creator.setComment(comment);
            if(!comment.isType()){
                ManagerController.deleteCommentC(comment.getPost(), comment);
            }
            else{
                ManagerController.deleteCommentP(comment.getComment(), comment);
            }
    }
}
