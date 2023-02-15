module org.example {
        requires javafx.controls;
        requires javafx.fxml;
        requires java.sql;
        requires de.jensd.fx.glyphs.fontawesome;
    requires java.desktop;

    opens org.example to javafx.fxml;
        exports org.example;
}