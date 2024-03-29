package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.entity.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ViewsPerDay implements Initializable {
    @FXML
    private Pane mainPane;
    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private ScrollPane viewsScrollPane;
    @FXML
    private Pane topPane;
    @FXML
    private ImageView backImage;
    @FXML
    private Label titleL;

    private double scale;
    private Color themeColor;
    private Color mode;
    private Image image;
    private User user;
    private ArrayList<User> usersToShow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //this.scale = Creator.getScale();
        this.scale=1;
        initial();
    }

    public void initial() {
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName("Views");
        Set<String> day = DataBase.getUser().getViewPD().keySet();
        Collection<Integer> view = DataBase.getUser().getViewPD().values();
        ArrayList<String> days = new ArrayList<>(day);
        Collections.sort(days);
        if (days.size()>=5) {
            for (int i = days.size() - 1; i >= days.size() - 5; i--) {
                series.getData().add(new XYChart.Data<>(days.get(i), DataBase.getUser().getViewPD().get(days.get(i))));
            }
        }
        else {
            for (int i = days.size() - 1; i >= 0; i--) {
                series.getData().add(new XYChart.Data<>(days.get(i), DataBase.getUser().getViewPD().get(days.get(i))));
            }
        }
        barChart.getData().add(series);

        barChart.setLayoutX(42 * scale);
        barChart.setLayoutY(100 * scale);
        barChart.setPrefWidth(500 * scale);
        barChart.setPrefHeight(400 * scale);

        //barChart.setStyle("-fx-fill: #ff00ff");

        theme();
        viewsScrollPane.setPrefWidth(600 * scale);
        viewsScrollPane.setPrefHeight(600 * scale);
        mainPane.setPrefWidth(600 * scale);
        mainPane.setPrefHeight(600 * scale);

        topPane.setPrefWidth(600 * scale);
        topPane.setPrefHeight(50 * scale);
        titleL.setFont(Font.font(24 * scale));
        titleL.setLayoutX(239 * scale);
        titleL.setLayoutY(11 * scale);
        backImage.setLayoutX(14 * scale);
        backImage.setLayoutY(10 * scale);
        backImage.setFitWidth(30 * scale);
        backImage.setFitHeight(31 * scale);

        topPane.setStyle("-fx-background-color: #" + themeColor.toString().substring(2));
        //mainPane.setStyle("-fx-background-color: #" + mode.toString().substring(2));
        titleL.setTextFill(mode);
    }

    public void theme() {
        switch (DataBase.theme) {
            case 1:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 2:
                this.themeColor = Color.rgb(120, 161, 209);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackDark.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 3:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.WHITE;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
            case 4:
                this.themeColor = Color.rgb(225, 121, 173);
                this.mode = Color.BLACK;
                this.image = new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackDark.png")).toExternalForm());
                this.backImage.setImage(this.image);
                break;
        }
    }


    public void back(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 7;
        DataBase.main.setMenuPane();
    }
}
