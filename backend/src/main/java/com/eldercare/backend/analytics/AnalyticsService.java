package com.eldercare.backend.analytics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eldercare.backend.service.WellBeingService;
import com.eldercare.backend.wellbeing.WellBeing;

@Service
public class AnalyticsService {
    private final WellBeingService wellBeingService;
    public AnalyticsService(WellBeingService wellBeingService) {
        this.wellBeingService = wellBeingService;
    }


    // Average loneliness score
    public double averageLoneliness(List<WellBeing> entries) {
        if (entries.isEmpty()) return 0;

        return entries.stream()
                .mapToInt(WellBeing::getLonelinessScore)
                .average()
                .orElse(0);
    }

    // Count entries where mood improved
    public long positiveMoodCount(List<WellBeing> entries) {
        return entries.stream()
                .filter(e -> e.getMood().equalsIgnoreCase("Happy"))
                .count();
    }
    public double getAverageLoneliness(Long userId) {
    List<WellBeing> history = wellBeingService.getHistoryByUserId(userId);

    if (history.isEmpty()) return 0;

    return history.stream()
            .mapToInt(WellBeing::getLonelinessScore)
            .average()
            .orElse(0);
}

}
