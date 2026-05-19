package com.example.assessment.Controller;

import com.example.assessment.Entity.Student;
import com.example.assessment.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    // GET ALL
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    // ADD
    @PostMapping
    public Student add(@RequestBody Student student) {
        return service.add(student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
} 
