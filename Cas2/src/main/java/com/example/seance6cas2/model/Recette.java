package com.example.seance6cas2.model;

import java.util.List;

public class Recette {

    private String name;
    private int time;
    private List<Step> steps;

    public Recette(String name, int time, List<Step> steps) {
        this.name = name;
        this.time = time;
        this.steps = steps;
    }

    public String getName() {
        return this.name;
    }

    public int getTime() {return this.time;}

    public int countSteps() {
        return this.steps.size();
    }

    public String toString() {
        String[] stepsString = new String[steps.size()];
        int i = 0;
        for(Step step : steps) {
            stepsString[i] = step.toString();
            i++;
        }
        StringBuilder strSteps = new StringBuilder();
        for(String step : stepsString) {
            strSteps.append(step).append("\n");
        }
        return this.name + " à faire en " + time + " minutes.\nEtapes :\n" + strSteps;
    }
}
