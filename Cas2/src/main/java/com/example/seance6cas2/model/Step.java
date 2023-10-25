package com.example.seance6cas2.model;

import java.util.List;

public class Step {

    private String description;
    private List<String> ingredients;
    private Recette recette;

    public Step(String description, List<String> ingredients, Recette recette) {
        this.description = description;
        this.ingredients = ingredients;
        this.recette = recette;
    }

    public int countIngredients() {
        return this.ingredients.size();
    }

    public Recette getRecette() {return this.recette;}

    public String toString(){
        StringBuilder str = new StringBuilder();
        for(String ingredient : ingredients) {
            str.append(ingredient).append(" -");
        }
        str.append("-> ").append(description);
        return str.toString();
    }
}
