package com.example.assessment.Service;

import com.example.assessment.Entity.Tracker;
import com.example.assessment.Repository.TrackerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackerService {

	@Autowired
	private TrackerRepo repo;

	// GET ALL
	public List<Tracker> getAll() {
		return repo.findAll();
	}

	// GET BY ID
	public Optional<Tracker> getById(String taskName) {
		return repo.findById(taskName);
	}

	// ADD
	public Tracker add(Tracker tracker) {
		return repo.save(tracker);
	}

	// UPDATE
	public Tracker update(String taskName, Tracker tracker) {
		tracker.setTaskName(taskName);
		return repo.save(tracker);
	}

	// DELETE
	public void delete(String taskName) {
		repo.deleteById(taskName);
	}
}
