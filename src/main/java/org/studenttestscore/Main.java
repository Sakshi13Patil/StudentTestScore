package org.studenttestscore;

import org.studenttestscore.repository.ScoringRepository;
import org.studenttestscore.service.ScoreService;

public class Main {
    static ScoringRepository scoringRepository = new ScoringRepository();
    static ScoreService scoreService = new ScoreService(scoringRepository);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        scoreService.addStudentData("UC11A345", "Sidharth Suresh");
        scoreService.addStudentData("UC11A346", "Shyam Dixit");
        scoreService.addStudentData("UC11A347", "Manav Awasthi");

        scoreService.addScore("UC11A345","ENG",80.00);
        scoreService.addScore("UC11A345","MATH",30.00);

        scoreService.addScore("UC11A346","ENG",90.00);

        scoreService.addScore("UC11A347","MATH",20.00);
        System.out.println(scoreService.getBestScorer("ENG"));
        System.out.println(scoreService.getScore("UC11A347","ENG"));

    }
}

