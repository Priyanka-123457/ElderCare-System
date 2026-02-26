package com.eldercare.backend.engagement;

public class EngagementSummary {

    private int totalSessions;
    private int attendedSessions;
    private int attendancePercentage;

    public EngagementSummary(int totalSessions, int attendedSessions, int attendancePercentage) {
        this.totalSessions = totalSessions;
        this.attendedSessions = attendedSessions;
        this.attendancePercentage = attendancePercentage;
    }

    public int getTotalSessions() {
        return totalSessions;
    }

    public int getAttendedSessions() {
        return attendedSessions;
    }

    public int getAttendancePercentage() {
        return attendancePercentage;
    }
}