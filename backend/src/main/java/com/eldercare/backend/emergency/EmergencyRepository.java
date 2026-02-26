package com.eldercare.backend.emergency;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmergencyRepository extends JpaRepository<EmergencyAlert, Long> {

    List<EmergencyAlert> findByStatus(String status);
}