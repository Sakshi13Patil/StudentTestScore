package org.studenttestscore.service;

import org.studenttestscore.exception.ScoringExceptions;
import org.studenttestscore.model.Student;
import org.studenttestscore.model.Subject;
import org.studenttestscore.repository.ScoringRepository;

import java.util.Optional;

public class ScoreService {
    private final ScoringRepository scoringRepository;

    public ScoreService(ScoringRepository scoringRepository) {
        this.scoringRepository = scoringRepository;
    }

    public void addStudentData(String id, String name) {
        Optional<Student> optionalStudent = scoringRepository.getUserById(id);
        if (optionalStudent.isPresent())
            throw new ScoringExceptions("Student Id " + id + " already present");

        Student student = new Student(id, name);

        scoringRepository.save(student);
    }

    public void addScore(String id, String subject, Double score) {
        Subject subjectToBeAdded = new Subject(subject,score);
        scoringRepository.addScore(id, subjectToBeAdded);
    }

    public Double getScore(String id, String name) {
        Optional<Subject> subject = scoringRepository.getSubjectForUserById(id, name);
        if (subject.isPresent())
            return subject.get().getScore();
        else
            throw new ScoringExceptions("Subject " + name + " doesn't exist for user " + id);
    }

    public String getBestScorer(String name) {
        return scoringRepository.getMarksForSubject(name);
    }
}
