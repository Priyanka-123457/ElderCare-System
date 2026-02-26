package com.eldercare.backend.attendance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByUserIdAndActivityIdAndDate(
            Long userId,
            Long activityId,
            LocalDate date
    );

    List<Attendance> findByUserId(Long userId);

    List<Attendance> findByActivityId(Long activityId);
}
