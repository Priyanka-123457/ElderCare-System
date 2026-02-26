package com.eldercare.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eldercare.backend.model.Activity;
import com.eldercare.backend.repository.ActivityRepository;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
    public Activity updateActivity(Long id, Activity updatedActivity) {
        Activity existing = activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        existing.setName(updatedActivity.getName());
        existing.setCategory(updatedActivity.getCategory());

        return activityRepository.save(existing);
    }
    public List<Activity> getActivitiesByCategory(String category) {
        return activityRepository.findByCategory(category);
    }


}
