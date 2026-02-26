package com.eldercare.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eldercare.backend.repository.UserRepository;
import com.eldercare.backend.user.User;
import com.eldercare.backend.user.UserRole;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Assign role (IMPORTANT for Admin / Elderly / Family / Buyer)
    public User assignRole(Long userId, UserRole role) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole(role);
        return userRepository.save(user);
    }
}
