package com.example.assessment.Controller;

import com.example.assessment.Entity.Result;
import com.example.assessment.Service.ResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService service;

    // ADD RESULT
    @PostMapping
    public Result addResult(@RequestBody Result result) {
        return service.saveResult(result);
    }

    // GET ALL RESULTS
    @GetMapping
    public List<Result> getAllResults() {
        return service.getAllResults();
    }

    // TOP SCORERS
    @GetMapping("/topscorers")
    public String topScorers() {

        service.getTopScorers();

        return "Top scorers printed in console";
    }

    // PASS PERCENTAGE
    @GetMapping("/passpercentage")
    public String passPercentage() {

        service.getPassPercentage();

        return "Pass percentage printed in console";
    }
}
