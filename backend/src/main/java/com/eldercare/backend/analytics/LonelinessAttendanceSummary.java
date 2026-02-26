package com.eldercare.backend.analytics;

public class LonelinessAttendanceSummary {

    private double averageLonelinessOnAttendedDays;
    private double averageLonelinessOnMissedDays;

    public LonelinessAttendanceSummary(double averageLonelinessOnAttendedDays,
                                       double averageLonelinessOnMissedDays) {
        this.averageLonelinessOnAttendedDays = averageLonelinessOnAttendedDays;
        this.averageLonelinessOnMissedDays = averageLonelinessOnMissedDays;
    }

    public double getAverageLonelinessOnAttendedDays() {
        return averageLonelinessOnAttendedDays;
    }

    public double getAverageLonelinessOnMissedDays() {
        return averageLonelinessOnMissedDays;
    }
}