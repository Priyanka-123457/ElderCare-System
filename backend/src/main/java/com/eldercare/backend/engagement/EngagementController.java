package com.eldercare.backend.engagement;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/engagement")
@CrossOrigin(origins = "*")
public class EngagementController {

    private final EngagementService engagementService;

    public EngagementController(EngagementService engagementService) {
        this.engagementService = engagementService;
    }

    @GetMapping("/user/{userId}")
    public EngagementSummary getEngagementForUser(@PathVariable Long userId) {
        return engagementService.getEngagementForUser(userId);
    }
}