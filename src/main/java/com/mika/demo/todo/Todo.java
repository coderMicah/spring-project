package com.mika.demo.todo;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String username;
    private String description;
    private LocalDate startDate;
    private boolean status;

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
        return "Todo [id=" + id + ", username =" + username + ", description= " + description + ", startDate= "
                + startDate + ", status= " + status + "]";
    }
}
