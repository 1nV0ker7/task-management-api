package com.invoker.taskmanager.task_management_api.model;

public class AuthRequest {
    private String username;
    private String password;

    // Default constructor (required for Jackson deserialization)
    public AuthRequest() {}

    // Parameterized constructor
    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}