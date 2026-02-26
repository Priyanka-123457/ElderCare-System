package com.eldercare.backend.attendance;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    // Mark or update attendance for today
    public Attendance markAttendance(Long userId, Long activityId, boolean attended) {

        LocalDate today = LocalDate.now();

        Attendance attendance = attendanceRepository
                .findByUserIdAndActivityIdAndDate(userId, activityId, today)
                .orElse(new Attendance(userId, activityId, today, attended));

        attendance.setAttended(attended);

        return attendanceRepository.save(attendance);
    }

    // Get all attendance records for a user
    public List<Attendance> getAttendanceByUser(Long userId) {
        return attendanceRepository.findByUserId(userId);
    }

    // Get all attendance records for an activity
    public List<Attendance> getAttendanceByActivity(Long activityId) {
        return attendanceRepository.findByActivityId(activityId);
    }
}
