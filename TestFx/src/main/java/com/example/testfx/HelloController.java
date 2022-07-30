package com.example.testfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public Pane mainPain;

    public ArrayList<Circle> circles = new ArrayList<>();
    public Button button;

    public void add(MouseEvent mouseEvent) {
        Circle circle = new Circle();
        circle.setCenterX(mainPain.getPrefWidth()/2);
        circle.setRadius(mainPain.getPrefWidth()/50);
        circle.setCenterY(circles.size()*circle.getRadius()*3+100);
        circles.add(circle);
        mainPain.getChildren().add(circle);
        mainPain.setPrefHeight(mainPain.getPrefHeight()+circle.getRadius()*3);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainPain.setPrefWidth(scrollPane.getPrefWidth()-30);
        button.setLayoutX(mainPain.getPrefWidth()/2-15);
        button.setPrefWidth(30);
        scrollPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                scrollPane.setPrefWidth(HelloApplication.window.getWidth());
                mainPain.setPrefWidth(scrollPane.getPrefWidth()-30);
                button.setLayoutX(mainPain.getPrefWidth()/2-15);
                int n=0;
                for (Circle circle : circles ){
                    circle.setCenterX(mainPain.getPrefWidth()/2);
                    circle.setRadius(mainPain.getPrefWidth()/50);
                    circle.setCenterY(n*circle.getRadius()*3+100);
                    n++;
                }
                mainPain.setPrefHeight(circles.size()*mainPain.getPrefWidth()/50*3+100);
            }
        });
    }

}