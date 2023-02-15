package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static Parent parent;


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Main"), 1200 , 1040);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setTitle("LordOfDefense");
        stage.show();
    }

    protected static void setScene(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        //loadCSS(appTheme.getThemeName());
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        parent = fxmlLoader.load();
        return parent;
    }

    protected static Parent loadCSS(String css) {
        parent.getStylesheets().clear();
        parent.getStylesheets().add(App.class.getResource(css + ".css").toExternalForm());
        return parent;
    }

    public static void main(String[] args) {
        launch();
    }

}