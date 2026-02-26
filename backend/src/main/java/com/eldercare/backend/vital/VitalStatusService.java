package com.eldercare.backend.vital;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class VitalStatusService {

    private final VitalStatusRepository repository;

    public VitalStatusService(VitalStatusRepository repository) {
        this.repository = repository;
    }

    // Save or update today's vitals
    public VitalStatus saveToday(VitalStatus vital) {

        LocalDate today = LocalDate.now();

        return repository.findByUserIdAndDate(vital.getUserId(), today)
                .map(existing -> {
                    existing.setHeartRate(vital.getHeartRate());
                    existing.setBloodPressure(vital.getBloodPressure());
                    existing.setOxygenLevel(vital.getOxygenLevel());
                    return repository.save(existing);
                })
                .orElseGet(() -> repository.save(vital));
    }

    // Get today's vitals
    public VitalStatus getToday(Long userId) {
        return repository.findByUserIdAndDate(userId, LocalDate.now())
                .orElse(null);
    }

    // Get history
    public List<VitalStatus> getHistory(Long userId) {
        return repository.findByUserId(userId);
    }
}