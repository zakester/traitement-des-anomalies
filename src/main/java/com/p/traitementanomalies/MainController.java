package com.p.traitementanomalies;

import com.jfoenix.controls.JFXListView;
import com.p.traitementanomalies.DataHandler.SolutionHandler;
import com.p.traitementanomalies.Models.Action;
import com.p.traitementanomalies.Models.Data;
import com.p.traitementanomalies.Models.Solution;
import com.p.traitementanomalies.Utility.Animation.UISwitcher;
import com.p.traitementanomalies.Utility.DOCXModifier.DOCXModifier;
import com.p.traitementanomalies.Utility.DOCXModifier.ToDOCX;
import com.p.traitementanomalies.Utility.ReadXSL;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import org.apache.commons.text.WordUtils;

import java.io.IOException;
import java.util.HashMap;

public class MainController {
    @FXML public TextField searchTextField;
    @FXML public JFXListView<Action> actionCorrectiveListView, actionPreventiveListView;

    private final SolutionHandler solutionHandler = new SolutionHandler();

    @FXML public Label title;
    private ScrollPane uiSwitcher;
    private FirstUiViewController firstUIController;

    @FXML public void initialize() {

        actionCorrectiveListView.setExpanded(true);
        actionPreventiveListView.setExpanded(true);
        actionCorrectiveListView.depthProperty().set(1);
        actionPreventiveListView.depthProperty().set(1);

        loadData();

        listViewCellFactorySetup();

        searchTextField.textProperty().addListener((o, old, newValue) -> updateActionLists(newValue));

    }

    private void loadData() {
        ReadXSL readXSL = new ReadXSL();
        readXSL.setSolutionHandler(this.solutionHandler);

        readXSL.readXSL();
    }

    private void listViewCellFactorySetup() {

        this.actionPreventiveListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Action action, boolean empty) {
                super.updateItem(action, empty);

                if (empty || action == null || action.getAction() == null) {
                    setText(null);
                } else {
                    setWrapText(true);
                    setText(action.getAction());
                }
            }

        });

        this.actionCorrectiveListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Action action, boolean empty) {
                super.updateItem(action, empty);

                if (empty || action == null || action.getAction() == null) {
                    setText(null);
                } else {
                    setWrapText(true);
                    setText(action.getAction());
                }

            }
        });

    }

    Solution solution;
    private void updateActionLists(String solutionName) {
        solution = findSolution(solutionName);
        if (solution != null && !solutionName.isEmpty()) {
            ObservableList<Action> correctiveActions = FXCollections.observableArrayList(solution.getCorrective());
            ObservableList<Action> predictiveActions = FXCollections.observableArrayList(solution.getPreventive());

            actionCorrectiveListView.setItems(correctiveActions);
            actionPreventiveListView.setItems(predictiveActions);

        } else {
            actionCorrectiveListView.setItems(FXCollections.emptyObservableList());
            actionPreventiveListView.setItems(FXCollections.emptyObservableList());
        }
    }

    private Solution findSolution(String name) {
        name = name.toLowerCase();
        for (Solution solution : this.solutionHandler.solutions) {
            String anomalies = solution.getAnomalies();
            if (anomalies.toLowerCase().contains(name)) {
                title.textProperty().bind(Bindings.createStringBinding(() -> {
                    if (searchTextField.getText().isEmpty()) return "Tapez votre Anomalie pour Rechercher...";
                    return WordUtils.capitalize(anomalies);
                }));
                return solution;
            }
        }
        title.textProperty().unbind();
        title.setText("L'anomalie que vous Recherchez est Introuvable...");
        return null;
    }

    @FXML public void search() {
        updateActionLists(searchTextField.getText());
    }

    public void setFirstUIController(FirstUiViewController firstUIController) {
        this.firstUIController = firstUIController;
    }

    private Node firstUINode;
    public void setFirstUINode(Node firstUINode) {
        this.firstUINode = firstUINode;
    }

    public void back() {
        this.uiSwitcher.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.uiSwitcher.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        UISwitcher.switchWithFadeAnimation(this.uiSwitcher, this.firstUINode);
    }

    public void setUiSwitcher(ScrollPane uiSwitcher) {
        this.uiSwitcher = uiSwitcher;
    }

    private final static String REPORT_FOLDER_DOCX = "REPORT";
    public void print() {

        HashMap<String, String> map = initializeHashMap();

        DOCXModifier docxModifier = new DOCXModifier(map);
        docxModifier.replace(REPORT_FOLDER_DOCX);

        try {
            ToDOCX.zipFile(REPORT_FOLDER_DOCX, "C:/report.docx", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private HashMap<String, String> initializeHashMap() {
        HashMap<String, String> map = new HashMap<>();
        Data data = this.firstUIController.getData();

        map.put("@nAnomalie", data.getnAnomalie());
        map.put("@dateHour", data.getDateHour());
        map.put("@fullName", data.getFullName());
        map.put("@departement", data.getDepartment());
        map.put("@nLot", data.getnLot());
        map.put("@type", data.getType());
        map.put("@subType", data.getSubType());
        map.put("@nCA", String.valueOf(actionCorrectiveListView.getItems().size()));
        map.put("@nPA", String.valueOf(actionPreventiveListView.getItems().size()));

        int i = 1;

        for (; i <= 8; i++) {
            String param = "@action" + i;
            try {
                String action = actionCorrectiveListView.getItems().get(i-1).getAction();
                map.put(param, action);
            } catch (Exception e) {
                break;
            }
        }

        for (int j = 0; j <= 16; j++) {
            String param;
            if (i >= 10) param = "@action_" + i;
            else param = "@action" + i;

            try {
                String action = actionPreventiveListView.getItems().get(j).getAction();
                map.put(param, action);
            } catch (Exception e) {
                map.put(param, "");
            }
            i++;
        }

        return map;
    }
}