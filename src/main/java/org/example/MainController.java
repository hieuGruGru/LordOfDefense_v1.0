package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    GridPane gridPane;
    @FXML
    Label NotiLabel;
    double x, y;
    private static final int N = 25;
    private static final double imageDim = 1000 / N;
    Map map1 = new Map();
    private ArrayList<ImageView> imageViewList = new ArrayList<>();
    @FXML
    private void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void minimize(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        map1.createMap("/org/example/map1.txt");
        createImageview();
    }

    @FXML
    private void letFight() {
        NotiLabel.setText("heheheh");
        String imagePath = "/org/example/image/map01.png";
        URL imageUrl = getClass().getResource(imagePath);
        Image image = new Image(imageUrl.toExternalForm());
        ImageView imageView = new ImageView(image);
        imageViewList.set(11,imageView);
        imageView.setFitHeight(imageDim);
        imageView.setFitWidth(imageDim);
        int row = (11 / N);
        int col = (11) % N;
        //gridPane.getChildren().remove(35);
        gridPane.add(imageView, col, row);
    }

    @FXML
    private void createImageview() {
        for (int i = 0; i < N * N; i++) {
            int row = (i / N);
            int col = i % N;
            String mapLevel = map1.level[i];
            String imagePath = "/org/example/image/map" + mapLevel +".png";
            URL imageUrl = getClass().getResource(imagePath);
            Image image = new Image(imageUrl.toExternalForm());
            ImageView imageView = new ImageView(image);
            imageViewList.add(imageView);
            imageView.setFitHeight(imageDim);
            imageView.setFitWidth(imageDim);
            gridPane.add(imageView, col, row);
            gridPane.setHgap(0);
            gridPane.setVgap(0);
        }
    }

    @FXML
    private void backToOption() throws IOException {
        App.setScene("Option");
    }
}
