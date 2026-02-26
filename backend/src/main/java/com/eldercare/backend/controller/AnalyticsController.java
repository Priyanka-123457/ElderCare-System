package com.eldercare.backend.controller;

import org.springframework.web.bind.annotation.*;

import com.eldercare.backend.analytics.AnalyticsService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/analytics")


public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    // Average loneliness for a user
    @GetMapping("/loneliness/{userId}")
    public double getAverageLoneliness(@PathVariable Long userId) {
        return analyticsService.getAverageLoneliness(userId);
    }
}
