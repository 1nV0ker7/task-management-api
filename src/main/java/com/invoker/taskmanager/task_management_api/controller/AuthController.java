package com.invoker.taskmanager.task_management_api.controller;

import com.invoker.taskmanager.task_management_api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        // Replace with actual user validation (e.g., from a database)
        if ("admin1".equals(username) && "secret1".equals(password)) {
            return jwtUtil.generateToken(username);
        }
        throw new RuntimeException("Invalid credentials");
    }
}