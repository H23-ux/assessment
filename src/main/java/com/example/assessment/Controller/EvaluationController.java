package com.example.assessment.Controller;

import com.example.assessment.Entity.Evaluation;
import com.example.assessment.Service.EvaluationServide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

	@Autowired
	private EvaluationServide service;

	// ADD evaluation with three course marks
	@PostMapping
	public Evaluation add(@RequestBody Evaluation evaluation) {
		return service.add(evaluation);
	}

	// GET total and percent for an evaluation
	@GetMapping("/{id}/summary")
	public Optional<EvaluationServide.EvaluationSummary> summary(@PathVariable Long id) {
		return service.evaluate(id);
	}
}
