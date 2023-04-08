package com.p.traitementanomalies;

import com.jfoenix.controls.JFXListView;
import com.p.traitementanomalies.DataHandler.SolutionHandler;
import com.p.traitementanomalies.Models.Action;
import com.p.traitementanomalies.Models.Solution;
import com.p.traitementanomalies.Utility.ReadXSL;
import com.p.traitementanomalies.Utility.SearchHandler;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import org.apache.commons.text.WordUtils;

public class MainController {
    @FXML public TextField searchTextField;
    @FXML public JFXListView<Action> actionCorrectiveListView, actionPreventiveListView;

    private final SolutionHandler solutionHandler = new SolutionHandler();

    @FXML public Label title;

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

}