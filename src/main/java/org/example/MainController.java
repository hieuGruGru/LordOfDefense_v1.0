package org.example;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<KeyEvent> {

    @FXML
    GridPane gridPane;
    @FXML
    ImageView charImage;
    @FXML
    ImageView dropTest;
    @FXML
    Label NotiLabel;
    @FXML
    TextField xCoor, yCoor;

    private static double x, y;
    private static final int N = 25;
    private static final int DX = 2, DY = 2;
    private static final double imageDim = 1000 / N;
    private boolean moveRight = false, moveLeft = false, moveUp = false, moveDown = false;
    private Map map1 = new Map();
    private DraggableMaker draggableMaker = new DraggableMaker();
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
        draggableMaker.makeDraggable(dropTest);

    }

    @FXML
    private void mouseEntered(MouseEvent e) {
        Node source = (Node)e.getSource() ;
        //Integer colIndex = gridPane.getColumnIndex(source);
        //Integer rowIndex = gridPane.getRowIndex(source);
        //xCoor.setText(String.valueOf(colIndex));
        //yCoor.setText(String.valueOf(rowIndex));
        System.out.println(source.getClass());
    }

    @FXML
    private void moveImage(MouseEvent event) {
        double x = event.getSceneX();
        double y = event.getSceneY();
        int col = (int) ((x * N) / 1000);
        int row = (int) ((y * N) / 1000);
        xCoor.setText(String.valueOf(x));
        yCoor.setText(String.valueOf(y));
        ImageView imageView = MyImageView.getImageView("/org/example/image/map@.png", imageDim, imageDim);
        gridPane.add(imageView, col, row);
        gridPane.setHgap(0);
        gridPane.setVgap(0);
    }

    @FXML
    void start() {
        charImage.getScene().setOnKeyPressed(this);
        charImage.getScene().setOnKeyReleased(this);
        AnimationTimer timer = new AnimationTimer(){
            @Override
            public void handle(long now) {
                move();
            }
        };
        timer.start();
    }

    @Override
    public void handle(KeyEvent e) {
        moveRight = false; moveLeft = false;  moveUp = false; moveDown = false;
        switch (e.getCode()) {
            case UP:
                moveUp = true;
                break;
            case LEFT:
                moveLeft = true;
                break;
            case RIGHT:
                moveRight = true;
                break;
            case DOWN:
                moveDown = true;
                break;
        }
    }

    private void move() {
        if(moveLeft) {
            charImage.setLayoutX(charImage.getLayoutX() - DX);
        }else  if(moveRight) {
            charImage.setLayoutX(charImage.getLayoutX() + DX);
        }else if(moveDown) {
            charImage.setLayoutY(charImage.getLayoutY() + DY);
        }else if(moveUp) {
            charImage.setLayoutY(charImage.getLayoutY() - DY);
        }
    }

    @FXML
    private void letFight() {
        NotiLabel.setText("heheheh");
        start();
        charImage.setVisible(true);
        charImage.toFront();
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

    @FXML
    private void createImageview() {
        for (int i = 0; i < N * N; i++) {
            int row = (i / N);
            int col = i % N;
            String imagePath = "/org/example/image/map" + map1.level[i] +".png";
            ImageView imageView = MyImageView.getImageView(imagePath, imageDim, imageDim);
            imageViewList.add(imageView);
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
