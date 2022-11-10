package org.studenttestscore.repository;

import org.studenttestscore.exception.ScoringExceptions;
import org.studenttestscore.model.Student;
import org.studenttestscore.model.Subject;

import java.util.*;
import java.util.stream.Collectors;

public class ScoringRepository {

    List<Student> students = new ArrayList<>();
    Map<String, Map<String, Double>> subjectStudentMaping = new HashMap<>();

    public Optional<Student> getUserById(String id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    public void save(Student student) {
        students.add(student);
    }

    public void addScore(String id, Subject subjectToBeAdded) {
        Optional<Student> optionalStudent = getUserById(id);
        if (optionalStudent.isEmpty())
            throw new ScoringExceptions("Student Id " + id + " id not present");

        optionalStudent.get()
                .setSubjectScores(optionalStudent.get().getSubjectScores()
                        .stream().filter(a -> !a.getName().equals(subjectToBeAdded.getName()))
                        .collect(Collectors.toList()));

        optionalStudent.get().getSubjectScores().add(subjectToBeAdded);
        subjectStudentMaping.putIfAbsent(subjectToBeAdded.getName(), new HashMap<>());
        subjectStudentMaping.get(subjectToBeAdded.getName()).put(id, subjectToBeAdded.getScore());
    }

    public Optional<Subject> getSubjectForUserById(String id, String name) {
        Optional<Student> optionalStudent = getUserById(id);
        if (optionalStudent.isEmpty())
            throw new ScoringExceptions("Student Id " + id + " already present");

        return optionalStudent.get().getSubjectScores()
                .stream()
                .filter(a -> a.getName().equals(name)).findFirst();
    }

    public String getMarksForSubject(String name) {
        Map<String, Double> studentScores = subjectStudentMaping.get(name);
        Double maxScore = Collections.max(studentScores.values());
        String maxScorer = null;
        for (Map.Entry<String, Double> entry : studentScores.entrySet())
            if (entry.getValue() == maxScore)
                maxScorer = entry.getKey();
        return maxScorer;
    }
}