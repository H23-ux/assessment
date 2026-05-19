package com.example.assessment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tracker {

    @Id
    private String taskName;

    private String description;
    private boolean completionStatus;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

}
