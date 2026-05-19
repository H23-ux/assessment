package com.example.assessment.Service;

import com.example.assessment.Entity.Student;
import com.example.assessment.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    // GET ALL
    public List<Student> getAll() {
        return repo.findAll();
    }

    // ADD
    public Student add(Student student) {
        return repo.save(student);
    }

    // DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
