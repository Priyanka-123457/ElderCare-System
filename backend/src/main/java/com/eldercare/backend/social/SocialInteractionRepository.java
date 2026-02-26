package com.eldercare.backend.social;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SocialInteractionRepository extends JpaRepository<SocialInteraction, Long> {

    List<SocialInteraction> findByUserId(Long userId);

    Optional<SocialInteraction> findByUserIdAndDate(Long userId, LocalDate date);
}