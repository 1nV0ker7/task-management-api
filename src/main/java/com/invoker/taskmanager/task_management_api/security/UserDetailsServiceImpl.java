package com.invoker.taskmanager.task_management_api.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Encode the password for "secret"
        String encodedPassword = passwordEncoder.encode("secret");

        // This is a simple in-memory implementation; replace with database logic
        if ("admin".equals(username)) {
            return new User("admin", encodedPassword, new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}