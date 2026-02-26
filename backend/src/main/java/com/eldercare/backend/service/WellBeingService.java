package com.eldercare.backend.service;

import java.util.List;
import java.time.LocalDate;   // ✅ ADDED

import org.springframework.stereotype.Service;

import com.eldercare.backend.repository.WellBeingRepository;
import com.eldercare.backend.user.User;
import com.eldercare.backend.wellbeing.WellBeing;

@Service
public class WellBeingService {

    private final WellBeingRepository wellBeingRepository;

    public WellBeingService(WellBeingRepository wellBeingRepository) {
        this.wellBeingRepository = wellBeingRepository;
    }

    // Save daily wellbeing entry
    public WellBeing addEntry(WellBeing entry, User user) {
        entry.setUser(user);
        entry.setDate(LocalDate.now());   // ✅ ADDED (CRITICAL FIX)
        return wellBeingRepository.save(entry);
    }

    // Existing history method (used by WellBeingController)
    public List<WellBeing> getHistory(User user) {
        return wellBeingRepository.findByUserId(user.getId());
    }

    // Used by Analytics & Recommendation
    public List<WellBeing> getHistoryByUserId(Long userId) {
        return wellBeingRepository.findByUserId(userId);
    }

    // Latest wellbeing (used by Recommendation)
    public WellBeing getLatestForUser(Long userId) {
        List<WellBeing> history = wellBeingRepository.findByUserId(userId);
        return history.isEmpty() ? null : history.get(history.size() - 1);
    }
}