package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatGroup implements Initializable {
    @FXML
    public Pane pane;
    @FXML

    public ScrollPane scrollPane;
    @FXML

    public VBox vBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MainGraphic.window.setWidth(415.0);

        pane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                scrollPane.setPrefWidth(t1.doubleValue());
                vBox.setPrefWidth(scrollPane.getPrefWidth()-15);
                vBox.getChildren().clear();
                for (int i = 0 ; i<DataBase.getChats().size() ; i++){
                    Node node;
                    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {

                        }
                    };
                    try {
                        node = Creator.showShortChat(DataBase.getChats().get(i),vBox.getPrefWidth()/600.0);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    node.addEventFilter(MouseEvent.MOUSE_CLICKED , eventHandler);
                    vBox.getChildren().add(node);
                }
                for (int i = 0;i<DataBase.getGroups().size() ; i++){
                    Node node;
                    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {

                        }
                    };
                    try {
                        node = Creator.showShortGroup(DataBase.getGroups().get(i),vBox.getPrefWidth()/600.0);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    node.addEventFilter(MouseEvent.MOUSE_CLICKED , eventHandler);
                    vBox.getChildren().add(node);
                }
            }
        });
    }
}
