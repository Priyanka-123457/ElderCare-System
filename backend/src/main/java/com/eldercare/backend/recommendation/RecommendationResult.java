package com.eldercare.backend.recommendation;

public class RecommendationResult {

    private String recommendedCategory;
    private String reason;

    public RecommendationResult(String recommendedCategory, String reason) {
        this.recommendedCategory = recommendedCategory;
        this.reason = reason;
    }

    public String getRecommendedCategory() {
        return recommendedCategory;
    }

    public String getReason() {
        return reason;
    }
}