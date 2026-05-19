package com.example.assessment.Repository;

import com.example.assessment.Entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepo extends JpaRepository<Result, Long> {
}
