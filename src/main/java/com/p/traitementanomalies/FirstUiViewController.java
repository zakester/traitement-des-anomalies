package com.p.traitementanomalies;

import com.p.traitementanomalies.Utility.Animation.UISwitcher;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class FirstUiViewController {
    @FXML public ToggleGroup elementImpacted, department, ng, sc, souType;
    private ScrollPane uiSwitcher;
    private Node mainNode;
    private Node firstUINode;
    private FirstUiViewController fisrtUIController;
    private FirstUiViewController firstUIController;

    public void initialize() throws IOException {

    }

    @FXML public void next() {
        uiSwitcher.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        uiSwitcher.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        UISwitcher.switchWithFadeAnimation(uiSwitcher, this.mainNode);
    }

    public void setMainNode(Node mainNode) {
        this.mainNode = mainNode;
    }

    public void setFirstUINode(Node firstUINode) {
        this.firstUINode = firstUINode;
    }

    public Node getFirstUINode() {
        return this.firstUINode;
    }

    public void setFirstUIController(FirstUiViewController firstUIController) {
        this.firstUIController = firstUIController;
    }

    public void setUiSwitcher(ScrollPane uiSwitcher) {
        this.uiSwitcher = uiSwitcher;
    }
}
