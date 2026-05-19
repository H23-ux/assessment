package com.example.assessment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stdName;

    private Integer course1;
    private Integer course2;
    private Integer course3;

    private String grade;

    // GETTERS

    public Long getId() {
        return id;
    }

    public String getStdName() {
        return stdName;
    }

    public Integer getCourse1() {
        return course1;
    }

    public Integer getCourse2() {
        return course2;
    }

    public Integer getCourse3() {
        return course3;
    }

    public String getGrade() {
        return grade;
    }

    // SETTERS

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public void setCourse1(Integer course1) {
        this.course1 = course1;
    }

    public void setCourse2(Integer course2) {
        this.course2 = course2;
    }

    public void setCourse3(Integer course3) {
        this.course3 = course3;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
