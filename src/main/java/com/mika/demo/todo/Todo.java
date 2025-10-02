package com.mika.demo.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

public class Todo {

    private int id;

    // @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Description cannot be empty")
    @Size(min = 5, max = 100, message = "Description must be between 5 and 100 characters")
    private String description;

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date cannot be in the past")
    private LocalDate startDate;

    private boolean status;

    public Todo() {
    } // ✅ Required for form binding

    public Todo(int id, String username, String description, LocalDate startDate, boolean status) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.startDate = startDate;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", username=" + username + ", description=" + description
                + ", startDate=" + startDate + ", status=" + status + "]";
    }
}
