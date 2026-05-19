package com.example.assessment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tracker {

    @Id
    private String taskName;

    private boolean completed;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
