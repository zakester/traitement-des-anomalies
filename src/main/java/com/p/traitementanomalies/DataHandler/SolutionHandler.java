package com.p.traitementanomalies.DataHandler;

import com.p.traitementanomalies.Models.Solution;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SolutionHandler {
    public final ObservableList<Solution> solutions = FXCollections.observableArrayList();

    public void add(Solution solution){
        solutions.add(solution);
    }
}
