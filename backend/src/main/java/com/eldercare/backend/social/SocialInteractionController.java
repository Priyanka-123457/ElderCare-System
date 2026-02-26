package com.eldercare.backend.social;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/social")
@CrossOrigin(origins = "*")
public class SocialInteractionController {

    private final SocialInteractionService service;

    public SocialInteractionController(SocialInteractionService service) {
        this.service = service;
    }

    // Save today's social interaction
    @PostMapping
    public SocialInteraction saveToday(@RequestBody SocialInteraction social) {
        return service.saveToday(social);
    }

    // Get today's data
    @GetMapping("/today/{userId}")
    public SocialInteraction getToday(@PathVariable Long userId) {
        return service.getToday(userId);
    }

    // Get history
    @GetMapping("/history/{userId}")
    public List<SocialInteraction> getHistory(@PathVariable Long userId) {
        return service.getHistory(userId);
    }
}