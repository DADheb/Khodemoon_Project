package com.example.mytwitterphase2.FXMLController;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.MainGraphic;
import com.example.mytwitterphase2.SQL.SQL;
import com.example.mytwitterphase2.entity.Group;
import com.example.mytwitterphase2.entity.User;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class SearchUser implements Initializable {
    public Pane mainPane;
    public ScrollPane scrollPane;
    public VBox vbox;
    public Label select;
    public boolean type;
    public Group group;
    public ArrayList<User> users = new ArrayList<>();
    public TextField text;
    public ImageView searchImage;
    public double scale;
    public ImageView backImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scale = Creator.mainScale;
        type = Creator.aBoolean;
        if (type) {
            group = Creator.g;
        }

        mainPane.setPrefWidth(600 * scale);
        mainPane.setPrefHeight(Creator.height);

        scrollPane.setPrefWidth(600 * scale);
        scrollPane.setPrefHeight(Creator.height - 70 * scale);
        scrollPane.setLayoutY(70 * scale);

        vbox.setPrefWidth(585 * scale);
        vbox.setPrefHeight(0);

        select.setLayoutX(89 * scale);
        select.setLayoutY(22 * scale);
        select.setFont(Font.font(18 * scale));

        text.setPrefHeight(30 * scale);
        text.setPrefWidth(150 * scale);
        text.setLayoutX(380 * scale);
        text.setLayoutY(23 * scale);

        searchImage.setFitWidth(60 * scale);
        searchImage.setFitHeight(60 * scale);
        searchImage.setLayoutX(535 * scale);
        searchImage.setLayoutY(5 * scale);

        backImage.setFitWidth(50 * scale);
        backImage.setFitHeight(50 * scale);
        backImage.setLayoutX(10 * scale);
        backImage.setLayoutY(10 * scale);
        if (LiveState.subState == 1) {
            backImage.setVisible(false);
        } else {
            backImage.setVisible(true);
        }

        Creator.subScale = vbox.getPrefWidth() / 600;
        for (User u : users) {
            Node node;
            Creator.u = u;
            FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/SelectUser.fxml"));
            try {
                node = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            node.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        selected();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            vbox.setPrefWidth(vbox.getPrefHeight() + 100 * scale);
            vbox.getChildren().add(node);
        }

        switch (DataBase.theme) {
            case 1:
                mainPane.setStyle("-fx-background-color: #0096ff");
                vbox.setStyle("-fx-background-color: #0096ff");
                break;
            case 2:
                mainPane.setStyle("-fx-background-color: #191970");
                vbox.setStyle("-fx-background-color: #191970");
                select.setTextFill(Color.web("#ffffff"));
                searchImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/SearchWhite.png")).toExternalForm()));
                backImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm()));
                break;
            case 3:
                mainPane.setStyle("-fx-background-color: #f88379");
                vbox.setStyle("-fx-background-color: #f88379");
                break;
            case 4:
                mainPane.setStyle("-fx-background-color: #4a0404");
                vbox.setStyle("-fx-background-color: #4a0404");
                select.setTextFill(Color.web("#ffffff"));
                searchImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/SearchWhite.png")).toExternalForm()));
                backImage.setImage(new Image(Objects.requireNonNull(MainGraphic.class.getResource("Photo/Project/BackWhite.png")).toExternalForm()));
                break;
        }
    }

    public void search(MouseEvent mouseEvent) throws SQLException {
        String s = text.getText();
        if (s.length() != 0) {
            ArrayList<User> users1 = SQL.searchUser(s, DataBase.getConnection());
            Creator.subScale = vbox.getPrefWidth() / 600;
            vbox.setPrefHeight(0.0);
            vbox.getChildren().clear();
            if (type) {
                for (User u : users1) {
                    if (users.contains(u)) {

                        Node node;
                        Creator.u = u;
                        FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/SelectUser.fxml"));
                        try {
                            node = fxmlLoader.load();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        node.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                try {
                                    selected();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });
                        vbox.setPrefWidth(vbox.getPrefHeight() + 100 * scale);
                        vbox.getChildren().add(node);
                    }
                }
            } else {
                for (User u : users1) {
                    Node node;
                    Creator.u = u;
                    FXMLLoader fxmlLoader = new FXMLLoader(MainGraphic.class.getResource("GraphicObject/SelectUser.fxml"));
                    try {
                        node = fxmlLoader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    node.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            try {
                                selected();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                    vbox.setPrefWidth(vbox.getPrefHeight() + 100 * scale);
                    vbox.getChildren().add(node);
                }
            }
        }
    }

    public void selected() throws InterruptedException, IOException {
        Thread.sleep(10);
        LiveState.state = 15;
        DataBase.main.showUser();
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        LiveState.state = 8;
        DataBase.main.setMenuPane();
    }
}
