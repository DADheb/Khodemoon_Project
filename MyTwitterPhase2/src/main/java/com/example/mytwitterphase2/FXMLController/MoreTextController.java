package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.Controller.ControllerManager;
import com.example.mytwitterphase2.Controller.PostController;
import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.entity.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

public class MoreTextController implements Initializable {

    @FXML
    private ScrollPane mainPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private LineChart lineChart;
    @FXML
    private CategoryAxis date;
    @FXML
    private NumberAxis perDay;
    @FXML
    private TextArea textArea;
    @FXML
    private Text editText;
    @FXML
    private Text impText;
    @FXML
    private Button doneButton;
    @FXML
    private Button deleteButton;

    private Color themeColor;
    private Color mode;
    private Color opposite;
    private Image image;
    private Post post;
    private Double scale = 1.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(Creator.mainScale);
        fillInfo();
        this.post = Creator.post;
        if(DataBase.theme == 1) {
            this.textArea.setStyle("-fx-control-inner-background:White; -fx-font-family: Consolas; -fx-highlight-fill: #78a1d1; -fx-highlight-text-fill: #78a1d1; -fx-text-fill: #78a1d1; ");
        }
        if(DataBase.theme == 2){
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

        if(DataBase.theme > 2) {
            this.textArea.setStyle("-fx-control-inner-background: #" + mode.toString().substring(2) + ";-fx-font-family: Consolas; -fx-highlight-fill:" + themeColor.toString().substring(2) + ";-fx-highlight-fill:" + themeColor.toString().substring(2) + "; -fx-text-fill:" + themeColor.toString().substring(2));
        }
        this.textArea.setPrefWidth(286d * scale);
        this.textArea.setPrefHeight(200d * scale);
        this.textArea.setFont(Font.font(20D * scale));
        this.textArea.setLayoutX(23d * scale);
        this.textArea.setLayoutY(378d * scale);

        this.editText.setFill(themeColor);
        this.editText.setLayoutX (107d* scale);
        this.editText.setLayoutY(359d * scale);
        this.editText.setFont(Font.font(20D * scale));

        this.impText.setFill(themeColor);
        this.impText.setLayoutX (254d* scale);
        this.impText.setLayoutY(18d * scale);
        this.impText.setFont(Font.font(16D * scale));

        this.doneButton.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.doneButton.setTextFill(mode);
        this.doneButton.setFont(Font.font(20D * scale));
        this.doneButton.setLayoutX (356d* scale);
        this.doneButton.setLayoutY(407d * scale);
        this.doneButton.setPrefWidth(173d * scale);
        this.doneButton.setPrefHeight(53d * scale);

        this.deleteButton.setStyle("-fx-background-radius: 15; -fx-background-color: #" + themeColor.toString().substring(2));
        this.deleteButton.setTextFill(mode);
        this.deleteButton.setFont(Font.font(20D * scale));
        this.deleteButton.setLayoutX (356d* scale);
        this.deleteButton.setLayoutY(489d * scale);
        this.deleteButton.setPrefWidth(173d * scale);
        this.deleteButton.setPrefHeight(53d * scale);

        this.lineChart.setPrefWidth(600d * scale);
        this.lineChart.setPrefHeight(330d * scale);
        this.lineChart.setLayoutX(-9d * scale);
        this.lineChart.setLayoutY(10d * scale);

        this.date.setStyle( "-fx-background-color: #"+ themeColor.toString().substring(2));
        this.date.setLayoutX (0d* scale);
        this.date.setLayoutY(0d * scale);
        this.date.setPrefWidth(507d * scale);
        this.date.setPrefHeight(32d * scale);

        this.perDay.setStyle("-fx-background-color: #"+ themeColor.toString().substring(2));
        this.perDay.setLayoutX (0d* scale);
        this.perDay.setLayoutY(0d * scale);
        this.perDay.setPrefWidth(40d * scale);
        this.perDay.setPrefHeight(246d * scale);

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

    public void fillInfo (){
        this.post = Creator.post;
        textArea.setText(post.getText());
        XYChart.Series<String, Integer> series = new XYChart.Series();

        Set<String> keySet = post.getLikePD().keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);

        if (listOfKeys.size() < 5) {
            for (int i = 0; i < listOfKeys.size(); i++) {
                series.getData().add(new XYChart.Data<>(listOfKeys.get(i), post.getLikePD().get(i)));
            }
        }
        else{
            for (int i = listOfKeys.size()-4; i < listOfKeys.size(); i++) {
                series.getData().add(new XYChart.Data<>(listOfKeys.get(i), post.getLikePD().get(i)));
            }
        }

        XYChart.Series series2 = new XYChart.Series();

        Set<String> keySet2 = post.getViewPD().keySet();
        ArrayList<String> listOfKeys2 = new ArrayList<String>(keySet);

        if (listOfKeys2.size() < 5) {
            for (int i = 0; i < listOfKeys2.size(); i++) {
                series2.getData().add(new XYChart.Data<>(listOfKeys.get(i), post.getLikePD().get(i)));
            }
        }
        else{
            for (int i = listOfKeys2.size()-4; i < listOfKeys2.size(); i++) {
                series2.getData().add(new XYChart.Data<>(listOfKeys.get(i), post.getLikePD().get(i)));
            }
        }

    }

    @FXML
    protected void onDoneClicked (ActionEvent e) throws IOException {
        Creator.setPost(post);
        String newText = textArea.getText();
        if(!newText.isEmpty()) {
            PostController.editText(post, newText);
        }
    }

    @FXML
    protected void onDeleteClicked (ActionEvent e) throws IOException {
        Creator.setPost(post);
        ControllerManager.deletePost(post);
    }

}
