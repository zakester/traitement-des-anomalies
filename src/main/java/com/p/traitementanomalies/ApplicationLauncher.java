package com.p.traitementanomalies;

import com.p.traitementanomalies.Utility.ReadXSL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationLauncher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationLauncher.class.getResource("main-view.fxml"));
        loadFonts();
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setMinWidth(1280.0);
        stage.setMinHeight(720.0);
        stage.setMaxWidth(1280.0);
        stage.setMaxHeight(720.0);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Traitement des Anomalies");
        stage.setScene(scene);
        stage.show();
    }

    private void loadFonts() {
        Font.loadFont(getClass().getResourceAsStream("font/Inter-Light.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/Inter-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/Inter-Medium.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/Inter-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/Inter-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/Inter-ExtraBold.ttf"), 10);
    }


    public static void main(String[] args) {
        launch();
    }
}