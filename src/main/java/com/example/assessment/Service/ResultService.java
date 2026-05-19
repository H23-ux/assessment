package com.example.assessment.Service;

import com.example.assessment.Entity.Result;
import com.example.assessment.Repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResultService {

    @Autowired
    private ResultRepo repo;

    // SAVE RESULT
    public Result saveResult(Result result) {
        return repo.save(result);
    }

    // GET ALL
    public List<Result> getAllResults() {
        return repo.findAll();
    }

    // TOP SCORER IN EACH SUBJECT
    public void getTopScorers() {

        List<Result> results = repo.findAll();

        Map<String, Result> topScorers = new HashMap<>();

        for (Result r : results) {

            String subject = r.getSubject();

            if (!topScorers.containsKey(subject)
                    || r.getMarks() > topScorers.get(subject).getMarks()) {

                topScorers.put(subject, r);
            }
        }

        System.out.println("TOP SCORERS:");

        for (String subject : topScorers.keySet()) {

            Result r = topScorers.get(subject);

            System.out.println(
                    subject + " -> "
                    + r.getStdName()
                    + " : "
                    + r.getMarks()
            );
        }
    }

    // PASS PERCENTAGE
    public void getPassPercentage() {

        List<Result> results = repo.findAll();

        int total = results.size();
        int pass = 0;

        for (Result r : results) {

            if (r.getMarks() >= 40) {
                pass++;
            }
        }

        double percentage = ((double) pass / total) * 100;

        System.out.println("PASS PERCENTAGE = " + percentage + "%");
    }
}

