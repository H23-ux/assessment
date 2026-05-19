package com.example.assessment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Result {

    public String grade
    

    public String getGrade() {
        return grade;
    }

    public void setStatus(String grade) {
        this.grade = grade;;
    }

}

