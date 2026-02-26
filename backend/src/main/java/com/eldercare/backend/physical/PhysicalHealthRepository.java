package com.eldercare.backend.physical;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PhysicalHealthRepository extends JpaRepository<PhysicalHealth, Long> {

    List<PhysicalHealth> findByUserId(Long userId);

    Optional<PhysicalHealth> findByUserIdAndDate(Long userId, LocalDate date);
}