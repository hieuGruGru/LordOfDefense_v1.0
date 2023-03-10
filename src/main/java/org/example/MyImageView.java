package org.example;

import javafx.scene.image.ImageView;
import java.net.URL;

public class MyImageView {

    public static ImageView getImageView (String path, double h, double w) {
        String imagePath = path;
        URL imageUrl = MyImageView.class.getResource(path);
        javafx.scene.image.Image image = new javafx.scene.image.Image(imageUrl.toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(h);
        imageView.setFitWidth(w);
        return imageView;
    }
}
