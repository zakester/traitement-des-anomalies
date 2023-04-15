package com.p.traitementanomalies.Utility.Animation;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class UISwitcher {

    public static void switchWithFadeAnimation(ScrollPane uiSwitcher, Node node) {
        PrebuiltAnimations.fadeAnimation(uiSwitcher, 1.0, 0.0);
        uiSwitcher.setContent(node);
        PrebuiltAnimations.fadeAnimation(uiSwitcher, 0.0, 1.0);
    }

    public static void addChildAnimation(int index, Pane parent, Node child) {
        parent.getChildren().add(index, child);
        PrebuiltAnimations.fadeAnimation(child, 0.0, 1.0);
    }

    public static void removeChildAnimation(Pane parent, Node child) {
        FadeTransition fadeTransition = PrebuiltAnimations.fadeAnimation(child, 1.0, 0.1, Duration.millis(500.0));
        fadeTransition.setOnFinished((event) -> parent.getChildren().remove(child));
    }

}

