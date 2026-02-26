package com.eldercare.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.eldercare.backend.model.Activity;
import com.eldercare.backend.recommendation.RecommendationService;
import com.eldercare.backend.service.ActivityService;
import com.eldercare.backend.service.WellBeingService;
import com.eldercare.backend.wellbeing.WellBeing;
@CrossOrigin(origins = "*")
//@RestController
@RequestMapping("/api/recommendations")   // 🔴 THIS WAS MISSING
public class RecommendationController {

    private final RecommendationService recommendationService;
    private final WellBeingService wellBeingService;
    private final ActivityService activityService;

    public RecommendationController(
            RecommendationService recommendationService,
            WellBeingService wellBeingService,
            ActivityService activityService) {

        this.recommendationService = recommendationService;
        this.wellBeingService = wellBeingService;
        this.activityService = activityService;
    }

    @GetMapping("/user/{userId}")
    public List<Activity> getRecommendations(@PathVariable Long userId) {

        WellBeing latest = wellBeingService.getLatestForUser(userId);
        List<Activity> allActivities = activityService.getAllActivities();

        return recommendationService.recommendActivities(latest, allActivities);
    }
}
