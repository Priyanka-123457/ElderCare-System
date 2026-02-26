package com.eldercare.backend.attendance;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // Mark or update attendance for today
    @PostMapping
    public Attendance markAttendance(
            @RequestParam Long userId,
            @RequestParam Long activityId,
            @RequestParam boolean attended
    ) {
        return attendanceService.markAttendance(userId, activityId, attended);
    }

    // Get attendance history for a user
    @GetMapping("/user/{userId}")
    public List<Attendance> getAttendanceByUser(@PathVariable Long userId) {
        return attendanceService.getAttendanceByUser(userId);
    }

    // Get attendance for an activity
    @GetMapping("/activity/{activityId}")
    public List<Attendance> getAttendanceByActivity(@PathVariable Long activityId) {
        return attendanceService.getAttendanceByActivity(activityId);
    }
}
