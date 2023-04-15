package com.p.traitementanomalies.Utility.Animation;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class PrebuiltAnimations {

    public static FadeTransition fadeAnimation(Node node, double from, double to) {
        return fadeAnimation(node, from, to, Duration.millis(900.0));
    }

    public static FadeTransition fadeAnimation(Node node, double from, double to, Duration duration) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(node);
        fadeTransition.setDuration(duration);
        fadeTransition.setFromValue(from);
        fadeTransition.setToValue(to);
        fadeTransition.play();
        return fadeTransition;
    }

}