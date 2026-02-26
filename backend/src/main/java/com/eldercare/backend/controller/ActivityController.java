package com.eldercare.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eldercare.backend.model.Activity;
import com.eldercare.backend.service.ActivityService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<Activity> getActivities() {
        return activityService.getAllActivities();
    }

    @PostMapping
    public Activity addActivity(@Valid @RequestBody Activity activity) {
        return activityService.addActivity(activity);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
    }

    @PutMapping("/{id}")
    public Activity updateActivity(
            @PathVariable Long id,
            @Valid @RequestBody Activity activity) {
        return activityService.updateActivity(id, activity);
    }

    @GetMapping("/category/{category}")
    public List<Activity> getByCategory(@PathVariable String category) {
        return activityService.getActivitiesByCategory(category);
    }
}
