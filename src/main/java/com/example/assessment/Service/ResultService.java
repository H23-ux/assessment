package com.example.assessment.Service;

import com.example.assessment.Entity.Result;
import com.example.assessment.Repository.ResultRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResultService {

    private static final int PASS_MARK = 35;

    private final ResultRepo resultRepo;

    public ResultService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    public ResultSummary getResultSummary() {
        List<Result> results = resultRepo.findAll();
        Map<String, Integer> topScoresBySubject = calculateTopScoresBySubject(results);
        double passPercent = calculatePassPercent(results);
        return new ResultSummary(topScoresBySubject, passPercent);
    }

    private Map<String, Integer> calculateTopScoresBySubject(List<Result> results) {
        if (results.isEmpty()) {
            return Collections.emptyMap();
        }
        return results.stream()
                .filter(result -> result.getSubject() != null && result.getMarks() != null)
                .collect(Collectors.groupingBy(
                        Result::getSubject,
                        Collectors.collectingAndThen(Collectors.maxBy((a, b) -> Integer.compare(a.getMarks(), b.getMarks())),
                                optional -> optional.map(Result::getMarks).orElse(0))));
    }

    private double calculatePassPercent(List<Result> results) {
        if (results.isEmpty()) {
            return 0.0;
        }
        long passedCount = results.stream()
                .filter(result -> result.getMarks() != null && result.getMarks() >= PASS_MARK)
                .count();
        return passedCount * 100.0 / results.size();
    }

    public ResultGrade getGrade(Long id) {
        return resultRepo.findById(id)
                .map(result -> new ResultGrade(result.getMarks(), gradeFor(result.getMarks())))
                .orElse(null);
    }

    private String gradeFor(Integer marks) {
        if (marks == null) {
            return "unknown";
        }
        if (marks >= 90) {
            return "A";
        }
        if (marks >= 80) {
            return "B";
        }
        if (marks >= 70) {
            return "C";
        }
        if (marks >= 60) {
            return "D";
        }
        if (marks >= PASS_MARK) {
            return "P";
        }
        return "F";
    }

    public static class ResultSummary {
        private final Map<String, Integer> topScoresBySubject;
        private final double passPercent;

        public ResultSummary(Map<String, Integer> topScoresBySubject, double passPercent) {
            this.topScoresBySubject = topScoresBySubject;
            this.passPercent = passPercent;
        }

        public Map<String, Integer> getTopScoresBySubject() {
            return topScoresBySubject;
        }

        public double getPassPercent() {
            return passPercent;
        }
    }

    public static class ResultGrade {
        private final Integer marks;
        private final String grade;

        public ResultGrade(Integer marks, String grade) {
            this.marks = marks;
            this.grade = grade;
        }

        public Integer getMarks() {
            return marks;
        }

        public String getGrade() {
            return grade;
        }
    }
}

