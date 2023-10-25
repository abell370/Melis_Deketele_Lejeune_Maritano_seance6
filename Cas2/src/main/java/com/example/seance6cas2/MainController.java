package com.example.seance6cas2;

import com.example.seance6cas2.components.ButtonComponent;
import com.example.seance6cas2.model.Recette;
import com.example.seance6cas2.model.Step;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class MainController extends ButtonComponent {

    @FXML
    private Button printRecetteButton;

    @FXML
    private Button deleteStepButton;

    @FXML
    private Button addStepButton;

    @FXML
    private TextField nameRecetteTextField;

    @FXML
    private TextField timeTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextArea consoleTextArea;

    @FXML
    private ListView<String> ingredientsListView;

    @FXML
    private ListView<Step> stepsListView;

    public void initialize() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll("Farine", "Eau", "Sucre", "Sel", "Oeufs", "Beurre", "Lait");
        this.ingredientsListView.setItems(observableList);
        this.ingredientsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.printRecetteButton.setDisable(true);
    }

    @FXML
    public void canPrintRecette() {
        Recette recette = getRecette();
        this.printRecetteButton.setDisable(!pressPrintRecette(recette));
    }

    @FXML
    public void printRecette() {
        Recette recette = getRecette();
        this.consoleTextArea.setText(recette.toString());
    }

    @FXML
    public void addStep(ActionEvent action) {
        Recette recette = getRecette();
        String desc = descriptionTextArea.getText();
        ObservableList<String> ingredients = ingredientsListView.getSelectionModel().getSelectedItems();

        List<String> ingredientsList = new ArrayList<>(ingredients);

        Step step = new Step(desc, ingredientsList, recette);
        if(pressAddStep(step)) {
            var stepsList = this.stepsListView.getItems();
            stepsList.add(step);
            clearAll();
        } else {
            this.consoleTextArea.setText("Il manque des éléments, remplissez le nom de la recette, le temps (> 0) et sélectionner au moins un ingrédient");
        }
        canPrintRecette();
    }

    private void clearAll() {
        descriptionTextArea.clear();
        ingredientsListView.getSelectionModel().clearSelection();
        consoleTextArea.clear();
    }

    private Recette getRecette() {
        String name = nameRecetteTextField.getText();
        String timestr = timeTextField.getText();
        int time = 0;
        if(!timestr.equals("") && timestr.matches("[0-9]*"))
            time = Integer.parseInt(timestr);

        ObservableList<Step> steps = stepsListView.getItems();
        List<Step> stepsList = new ArrayList<>(steps);

        return new Recette(name, time, stepsList);
    }


    public boolean atLeastOneStep(Recette recette) {
        return recette.countSteps() > 0;
    }

    public boolean atLeastOneIngredient(Step step) {
        return step.countIngredients() > 0;
    }
}