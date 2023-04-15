package com.p.traitementanomalies;

import com.p.traitementanomalies.Utility.Animation.UISwitcher;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationLauncher extends Application {

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationLauncher.class.getResource("main.fxml"));
        loadFonts();
        Node node = fxmlLoader.load();
        HolderController controller = fxmlLoader.getController();

        loadMainView();
        loadFirstUIView();

        this.firstUiViewController.setUiSwitcher(controller.uiSwitcher);
        this.firstUiViewController.setMainNode(this.mainViewNode);
        this.firstUiViewController.setFirstUINode(this.firstUIViewNode);
        this.firstUiViewController.setFirstUIController(this.firstUiViewController);

        this.mainController.setFirstUINode(this.firstUIViewNode);
        this.mainController.setUiSwitcher(controller.uiSwitcher);
        this.mainController.setFirstUIController(this.firstUiViewController);

        UISwitcher.switchWithFadeAnimation(controller.uiSwitcher, this.firstUIViewNode);

        Scene scene = new Scene((Parent)node, 1280, 720);
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

    private Node mainViewNode;
    private MainController mainController;
    public void loadMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        mainViewNode = loader.load();
        mainController = loader.getController();
    }

    private Node firstUIViewNode;
    private FirstUiViewController firstUiViewController;
    public void loadFirstUIView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("first-ui-view.fxml"));
        firstUIViewNode = loader.load();
        firstUiViewController = loader.getController();
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