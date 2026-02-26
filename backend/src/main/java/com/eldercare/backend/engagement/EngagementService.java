package com.eldercare.backend.engagement;

import com.eldercare.backend.attendance.Attendance;
import com.eldercare.backend.attendance.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngagementService {

    private final AttendanceRepository attendanceRepository;

    public EngagementService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public EngagementSummary getEngagementForUser(Long userId) {

        List<Attendance> attendanceList =
                attendanceRepository.findByUserId(userId);

        int totalSessions = attendanceList.size();

        long attendedSessions = attendanceList.stream()
                .filter(Attendance::isAttended)
                .count();

        int attendancePercentage = totalSessions == 0
                ? 0
                : (int) ((attendedSessions * 100) / totalSessions);

        return new EngagementSummary(
                totalSessions,
                (int) attendedSessions,
                attendancePercentage
        );
    }
}