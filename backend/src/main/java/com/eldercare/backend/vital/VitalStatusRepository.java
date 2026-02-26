package com.eldercare.backend.vital;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VitalStatusRepository extends JpaRepository<VitalStatus, Long> {

    List<VitalStatus> findByUserId(Long userId);

    Optional<VitalStatus> findByUserIdAndDate(Long userId, LocalDate date);
}