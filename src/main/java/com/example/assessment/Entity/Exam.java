
package com.example.assessment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ex_dept;
    private String ex_course;
    private String ex_date;
    private String ex_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // GETTERS
    public String getEx_dept() {
        return ex_dept;
    }

    public String getEx_course() {
        return ex_course;
    }
    public String getEx_date() {
        return ex_date;
    }
    public String getEx_time(){
        return ex_time;
    }

    // SETTERS
    public void setEx_dept(String ex_dept) {
        this.ex_dept = ex_dept;
    }
    public void setEx_course(String ex_course) {
        this.ex_course = ex_course;
    }
    public void setEx_date(String ex_date) {
        this.ex_date = ex_date;
    }
    public void setEx_time(String ex_time) {
        this.ex_time = ex_time;
    }
}
