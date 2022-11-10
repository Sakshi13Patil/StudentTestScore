package org.studenttestscore.model;
public class Subject {

    private String name;
    private Double score;

    public Subject(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

}
