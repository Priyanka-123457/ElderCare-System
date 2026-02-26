package com.eldercare.backend.physical;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PhysicalHealthService {

    private final PhysicalHealthRepository repository;

    public PhysicalHealthService(PhysicalHealthRepository repository) {
        this.repository = repository;
    }

    // Save or update today's record
    public PhysicalHealth saveToday(PhysicalHealth health) {

        LocalDate today = LocalDate.now();

        return repository.findByUserIdAndDate(health.getUserId(), today)
                .map(existing -> {
                    existing.setSteps(health.getSteps());
                    existing.setExerciseMinutes(health.getExerciseMinutes());
                    existing.setSleepHours(health.getSleepHours());
                    existing.setMedicineTaken(health.isMedicineTaken());
                    return repository.save(existing);
                })
                .orElseGet(() -> repository.save(health));
    }

    // Get today's record
    public PhysicalHealth getToday(Long userId) {
        return repository.findByUserIdAndDate(userId, LocalDate.now())
                .orElse(null);
    }

    // Get history
    public List<PhysicalHealth> getHistory(Long userId) {
        return repository.findByUserId(userId);
    }
}