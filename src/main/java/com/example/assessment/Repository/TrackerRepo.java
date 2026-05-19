package com.example.assessment.Repository;

import com.example.assessment.Entity.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackerRepo extends JpaRepository<Tracker, String> {

}
