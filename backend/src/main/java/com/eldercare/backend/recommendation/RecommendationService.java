package com.eldercare.backend.recommendation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eldercare.backend.model.Activity;
import com.eldercare.backend.wellbeing.WellBeing;

@Service
public class RecommendationService {

    public List<Activity> recommendActivities(
            WellBeing latestWellBeing,
            List<Activity> allActivities) {

        String mood = latestWellBeing.getMood();

        // If mood is low → suggest physical activities
        if (mood.equalsIgnoreCase("Sad") || mood.equalsIgnoreCase("Lonely")) {
            return allActivities.stream()
                    .filter(a -> a.getCategory().equalsIgnoreCase("Physical"))
                    .collect(Collectors.toList());
        }

        // If mood is happy → suggest creative activities
        if (mood.equalsIgnoreCase("Happy")) {
            return allActivities.stream()
                    .filter(a -> a.getCategory().equalsIgnoreCase("Creative"))
                    .collect(Collectors.toList());
        }

        // Default: return everything
        return allActivities;
    }
}
