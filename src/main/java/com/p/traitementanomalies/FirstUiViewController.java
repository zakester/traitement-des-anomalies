package com.p.traitementanomalies;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.p.traitementanomalies.Models.Data;
import com.p.traitementanomalies.Utility.Animation.UISwitcher;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.TimeZone;

public class FirstUiViewController {
    @FXML public ToggleGroup elementImpacted, department, ng, sc, typeAnomaly, souType;
    @FXML public JFXTextField nom, prenom, numberAnomalie, numberLot;
    @FXML public JFXDatePicker date;
    @FXML public JFXTimePicker time;

    private ScrollPane uiSwitcher;
    private Node mainNode;
    private Node firstUINode;

    private FirstUiViewController firstUIController;

    public void initialize() throws IOException {

    }

    @FXML public void next() {
        setData();
        uiSwitcher.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        uiSwitcher.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        UISwitcher.switchWithFadeAnimation(uiSwitcher, this.mainNode);
    }

    private Data data;
    public void setData() {
        LocalTime time = this.time.getValue();
        LocalDate date = this.date.getValue();

        String fullName = this.prenom.getText() + " " + nom.getText();
        String dateHour = date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear() + "-" + time.getHour() + ":" + time.getMinute();
        String department = ((RadioButton) this.department.getSelectedToggle()).getText();
        String type = ((RadioButton) this.typeAnomaly.getSelectedToggle()).getText();
        String subType = ((RadioButton) this.souType.getSelectedToggle()).getText();

        data = new Data(
                fullName,
                numberAnomalie.getText(),
                dateHour,
                department,
                numberLot.getText(),
                type,
                subType
        );
    }

    public Data getData() {
        return this.data;
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
