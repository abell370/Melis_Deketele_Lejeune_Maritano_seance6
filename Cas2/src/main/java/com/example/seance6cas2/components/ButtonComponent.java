package com.example.seance6cas2.components;

import com.example.seance6cas2.model.Recette;
import com.example.seance6cas2.model.Step;

public abstract class ButtonComponent {
    public ButtonComponent() {}

    public boolean pressPrintRecette(Recette recette) {
        if(recetteInfosOk(recette) && recette.countSteps() > 0) {
            return atLeastOneStep(recette);
        }
        return false;
    }

    public boolean pressAddStep(Step step) {
        Recette recette = step.getRecette();
        if(step.countIngredients() > 0 && recetteInfosOk(recette)) {
            return atLeastOneIngredient(step);
        }
        return false;
    }

    private boolean recetteInfosOk(Recette recette) {
        return !recette.getName().equals("") && recette.getTime() > 0;
    }

    public abstract boolean atLeastOneStep(Recette recette);
    public abstract boolean atLeastOneIngredient(Step step);
}
