package com.eldercare.backend.recommendation;

import com.eldercare.backend.engagement.EngagementService;
import com.eldercare.backend.engagement.EngagementSummary;
import com.eldercare.backend.service.WellBeingService;
import com.eldercare.backend.wellbeing.WellBeing;
import org.springframework.stereotype.Service;

@Service
public class RecommendationRuleService {

    private final WellBeingService wellBeingService;
    private final EngagementService engagementService;

    public RecommendationRuleService(WellBeingService wellBeingService,
                                     EngagementService engagementService) {
        this.wellBeingService = wellBeingService;
        this.engagementService = engagementService;
    }

    public RecommendationResult getRecommendationForUser(Long userId) {

        WellBeing latestWellBeing = wellBeingService.getLatestForUser(userId);
        EngagementSummary engagement = engagementService.getEngagementForUser(userId);

        // Defensive defaults
        if (latestWellBeing == null || engagement == null) {
            return new RecommendationResult(
                    "General",
                    "Insufficient data available for personalized recommendation"
            );
        }

        int loneliness = latestWellBeing.getLonelinessScore();
        String mood = latestWellBeing.getMood();
        int attendancePercent = engagement.getAttendancePercentage();

        // Rule 1: High loneliness + low attendance
        if (loneliness >= 4 && attendancePercent < 40) {
            return new RecommendationResult(
                    "Social",
                    "High loneliness and low activity attendance detected"
            );
        }

        // Rule 2: Sad mood + missed activities
        if ("sad".equalsIgnoreCase(mood) && attendancePercent < 50) {
            return new RecommendationResult(
                    "Relaxation",
                    "Low mood and reduced participation observed"
            );
        }

        // Rule 3: Good engagement
        if (attendancePercent >= 70) {
            return new RecommendationResult(
                    "Skill",
                    "Consistent participation indicates readiness for skill-based activities"
            );
        }

        // Default fallback
        return new RecommendationResult(
                "General",
                "Balanced engagement and well-being observed"
        );
    }
}