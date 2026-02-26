package com.eldercare.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.eldercare.backend.service.UserService;
import com.eldercare.backend.user.User;
import com.eldercare.backend.user.UserRole;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Assign role to user
    @PutMapping("/{id}/role/{role}")
    public User assignRole(
            @PathVariable Long id,
            @PathVariable UserRole role) {
        return userService.assignRole(id, role);
    }
}
