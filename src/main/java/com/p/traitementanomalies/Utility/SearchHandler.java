package com.p.traitementanomalies.Utility;

import com.p.traitementanomalies.Models.Solution;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TextField;

import java.util.function.Predicate;

public class SearchHandler {
    private final ObjectProperty<Predicate<Solution>> searchProperty = new SimpleObjectProperty<>();

    public ObjectProperty<Predicate<Solution>> search(TextField searchField) {

        Predicate<Solution> predicate = solution -> {

            if (searchField.getText().isEmpty()) {
                return false;
            }

            return solution.getAnomalies().contains(searchField.getText());
        };

        searchProperty.bind(Bindings.createObjectBinding(() -> predicate, searchField.textProperty()));

        return searchProperty;
    }

}
