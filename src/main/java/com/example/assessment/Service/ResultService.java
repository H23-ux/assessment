package com.example.assessment.Service;

import com.example.assessment.Entity.Result;
import com.example.assessment.Repository.ResultRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepo repo;

    // SAVE
    public Result saveResult(Result result) {
        return repo.save(result);
    }

    // GET ALL
    public List<Result> getAllResults() {
        return repo.findAll();
    }

    // TOP SCORERS
    public void getTopScorers() {

        List<Result> results = repo.findAll();

        Result top1 = null;
        Result top2 = null;
        Result top3 = null;

        for(Result r : results) {

            // COURSE 1
            if(top1 == null ||
                    r.getCourse1() > top1.getCourse1()) {

                top1 = r;
            }

            // COURSE 2
            if(top2 == null ||
                    r.getCourse2() > top2.getCourse2()) {

                top2 = r;
            }

            // COURSE 3
            if(top3 == null ||
                    r.getCourse3() > top3.getCourse3()) {

                top3 = r;
            }
        }

        System.out.println("TOP SCORERS");

        System.out.println("Course1 : "
                + top1.getStdName()
                + " -> "
                + top1.getCourse1());

        System.out.println("Course2 : "
                + top2.getStdName()
                + " -> "
                + top2.getCourse2());

        System.out.println("Course3 : "
                + top3.getStdName()
                + " -> "
                + top3.getCourse3());
    }

    // MAX PASS PERCENTAGE
    public void getMaxPassPercentage() {

        List<Result> results = repo.findAll();

        int total = results.size();

        int pass1 = 0;
        int pass2 = 0;
        int pass3 = 0;

        for(Result r : results) {

            if(r.getCourse1() >= 40)
                pass1++;

            if(r.getCourse2() >= 40)
                pass2++;

            if(r.getCourse3() >= 40)
                pass3++;
        }

        double percent1 =
                ((double) pass1 / total) * 100;

        double percent2 =
                ((double) pass2 / total) * 100;

        double percent3 =
                ((double) pass3 / total) * 100;

        double max =
                Math.max(percent1,
                Math.max(percent2, percent3));

        System.out.println("PASS PERCENTAGES");

        System.out.println("Course1 = " + percent1 + "%");

        System.out.println("Course2 = " + percent2 + "%");

        System.out.println("Course3 = " + percent3 + "%");

        System.out.println("MAX PASS PERCENTAGE = "
                + max + "%");
    }
}

  
