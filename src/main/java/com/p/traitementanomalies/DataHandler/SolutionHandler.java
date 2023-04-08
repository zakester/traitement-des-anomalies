package com.p.traitementanomalies.DataHandler;

import com.p.traitementanomalies.Models.Action;
import com.p.traitementanomalies.Models.Solution;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class SolutionHandler {
    public final ObservableList<Solution> solutions = FXCollections.observableArrayList();
    public final FilteredList<Solution> filteredSolutions = new FilteredList<>(solutions);

    public ObservableList<Action> corrective = FXCollections.observableArrayList();

    public void add(Solution solution){
        solutions.add(solution);
    }

    public void d() {
    }
    public ObservableList<Solution> solutions(){
        return solutions;
    }

    public Solution solution(int index){
        return solutions.get(index);
    }

    public void remove(Solution solution){
        solutions.remove(solution);
    }

    public void clear(){
        solutions.clear();
    }

    public int size(){
        return solutions.size();
    }

}
