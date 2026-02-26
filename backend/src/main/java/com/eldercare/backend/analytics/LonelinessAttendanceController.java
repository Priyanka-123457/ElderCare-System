package com.eldercare.backend.analytics;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics/loneliness-attendance")
@CrossOrigin(origins = "*")
public class LonelinessAttendanceController {

    private final LonelinessAttendanceService lonelinessAttendanceService;

    public LonelinessAttendanceController(
            LonelinessAttendanceService lonelinessAttendanceService) {
        this.lonelinessAttendanceService = lonelinessAttendanceService;
    }

    @GetMapping("/user/{userId}")
    public LonelinessAttendanceSummary getLonelinessVsAttendance(
            @PathVariable Long userId) {
        return lonelinessAttendanceService.getLonelinessVsAttendance(userId);
    }
}