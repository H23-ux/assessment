package com.example.assessment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String std_course;
    private String std_exam;
    private String name;

    // GETTERS
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getStd_course() {
        return std_course;
    }
    public String getStd_exam(){
        return std_exam;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setStd_course(String std_course) {
        this.std_course = std_course;
    }
    public void setStd_exam(String std_exam) {
        this.std_exam = std_exam;
    }

}
