package com.tasktracker.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    private String description;

    @FutureOrPresent(message = "Due date cannot be in the past")
    private LocalDate dueDate;

    @Pattern(regexp = "^(TODO|IN_PROGRESS|DONE)$", message = "Status must be TODO, IN_PROGRESS, or DONE")
    private String status;

    @Pattern(regexp = "LOW|MEDIUM|HIGH", message = "Priority must be LOW, MEDIUM, or HIGH")
    @NotNull(message = "Priority cannot be null")
    private String priority;

    // Constructors
    public Task() {
        super();
    }

    public Task(Long id, String title, String description, LocalDate dueDate, String status, String priority) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    // toString
    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description +
               ", dueDate=" + dueDate + ", status=" + status + ", priority=" + priority + "]";
    }
}
