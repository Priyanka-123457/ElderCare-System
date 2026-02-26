package com.eldercare.backend.analytics;

import com.eldercare.backend.attendance.Attendance;
import com.eldercare.backend.attendance.AttendanceRepository;
import com.eldercare.backend.wellbeing.WellBeing;
import com.eldercare.backend.repository.WellBeingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LonelinessAttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final WellBeingRepository wellBeingRepository;

    public LonelinessAttendanceService(AttendanceRepository attendanceRepository,
                                       WellBeingRepository wellBeingRepository) {
        this.attendanceRepository = attendanceRepository;
        this.wellBeingRepository = wellBeingRepository;
    }

    public LonelinessAttendanceSummary getLonelinessVsAttendance(Long userId) {

        List<Attendance> attendanceList =
                attendanceRepository.findByUserId(userId);

        List<WellBeing> wellBeingList =
                wellBeingRepository.findByUserId(userId);

        // Map date -> loneliness score
        Map<LocalDate, Integer> lonelinessByDate = new HashMap<>();
        for (WellBeing wb : wellBeingList) {
            lonelinessByDate.put(wb.getDate(), wb.getLonelinessScore());
        }

        int attendedSum = 0;
        int attendedCount = 0;

        int missedSum = 0;
        int missedCount = 0;

        for (Attendance attendance : attendanceList) {
            LocalDate date = attendance.getDate();

            if (!lonelinessByDate.containsKey(date)) {
                continue; // skip days without well-being data
            }

            int lonelinessScore = lonelinessByDate.get(date);

            if (attendance.isAttended()) {
                attendedSum += lonelinessScore;
                attendedCount++;
            } else {
                missedSum += lonelinessScore;
                missedCount++;
            }
        }

        double avgAttended = attendedCount == 0
                ? 0
                : (double) attendedSum / attendedCount;

        double avgMissed = missedCount == 0
                ? 0
                : (double) missedSum / missedCount;

        return new LonelinessAttendanceSummary(avgAttended, avgMissed);
    }
}