package com.example.assessment.Controller;

import com.example.assessment.Entity.Result;
import com.example.assessment.Service.ResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/summary")
    public ResultService.ResultSummary getResultSummary() {
        return resultService.getResultSummary();
    }

    @GetMapping("/{id}/grade")
    public ResultService.ResultGrade getResultGrade(@PathVariable Long id) {
        return resultService.getGrade(id);
    }
}

