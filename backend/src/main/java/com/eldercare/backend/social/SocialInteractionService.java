package com.eldercare.backend.social;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class SocialInteractionService {

    private final SocialInteractionRepository repository;

    public SocialInteractionService(SocialInteractionRepository repository) {
        this.repository = repository;
    }

    // Save or update today's record
    public SocialInteraction saveToday(SocialInteraction social) {

        LocalDate today = LocalDate.now();

        return repository.findByUserIdAndDate(social.getUserId(), today)
                .map(existing -> {
                    existing.setCallsMade(social.getCallsMade());
                    existing.setFamilyInteractions(social.getFamilyInteractions());
                    existing.setCommunityEvents(social.getCommunityEvents());
                    return repository.save(existing);
                })
                .orElseGet(() -> repository.save(social));
    }

    // Get today's record
    public SocialInteraction getToday(Long userId) {
        return repository.findByUserIdAndDate(userId, LocalDate.now())
                .orElse(null);
    }

    // Get history
    public List<SocialInteraction> getHistory(Long userId) {
        return repository.findByUserId(userId);
    }
}