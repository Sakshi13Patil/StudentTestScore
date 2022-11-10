package org.studenttestscore.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String id;
    private String name;
    private List<Subject> subjectScores;

    public String getId() {
        return id;
    }


    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.subjectScores = new ArrayList<>();
    }

    public List<Subject> getSubjectScores() {
        return subjectScores;
    }

    public void setSubjectScores(List<Subject> subjectScores) {
        this.subjectScores = subjectScores;
    }
}
