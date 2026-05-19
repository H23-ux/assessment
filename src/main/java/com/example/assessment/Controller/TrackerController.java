package com.example.assessment.Controller;

import com.example.assessment.Entity.Tracker;
import com.example.assessment.Service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/tracker")
public class TrackerController {

	@Autowired
	private TrackerService service;

	// GET ALL
	@GetMapping
	public List<Tracker> getAll() {
		return service.getAll();
	}

	// GET BY ID
	@GetMapping("/{taskName}")
	public Optional<Tracker> getById(@PathVariable String taskName) {
		return service.getById(taskName);
	}

	// ADD
	@PostMapping
	public Tracker add(@RequestBody Tracker tracker) {
		return service.add(tracker);
	}

	// UPDATE
	@PutMapping("/{taskName}")
	public Tracker update(@PathVariable String taskName, @RequestBody Tracker tracker) {
		return service.update(taskName, tracker);
	}

	// DELETE
	@DeleteMapping("/{taskName}")
	public void delete(@PathVariable String taskName) {
		service.delete(taskName);
	}

	// GET STATUS (returns "completed" or "not completed")
	@GetMapping("/{taskName}/status")
	public String status(@PathVariable String taskName) {
		Optional<Tracker> t = service.getById(taskName);
		return t.map(tracker -> tracker.isCompletionStatus() ? "completed" : "not completed")
				.orElse("not found");
	}
}
