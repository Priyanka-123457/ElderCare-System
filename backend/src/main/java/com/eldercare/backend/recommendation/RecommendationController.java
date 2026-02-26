package com.eldercare.backend.recommendation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendation")
@CrossOrigin(origins = "*")
public class RecommendationController {

    private final RecommendationRuleService recommendationRuleService;

    public RecommendationController(RecommendationRuleService recommendationRuleService) {
        this.recommendationRuleService = recommendationRuleService;
    }

    @GetMapping("/user/{userId}")
    public RecommendationResult getRecommendationForUser(@PathVariable Long userId) {
        return recommendationRuleService.getRecommendationForUser(userId);
    }
}