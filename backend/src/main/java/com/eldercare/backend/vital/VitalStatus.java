package com.eldercare.backend.vital;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vital_status")
public class VitalStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int heartRate;        // bpm
    private String bloodPressure; // e.g. 120/80
    private int oxygenLevel;      // %

    private LocalDate date;

    public VitalStatus() {}

    public VitalStatus(Long userId, int heartRate, String bloodPressure, int oxygenLevel) {
        this.userId = userId;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.oxygenLevel = oxygenLevel;
        this.date = LocalDate.now();
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public int getHeartRate() { return heartRate; }
    public String getBloodPressure() { return bloodPressure; }
    public int getOxygenLevel() { return oxygenLevel; }
    public LocalDate getDate() { return date; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setHeartRate(int heartRate) { this.heartRate = heartRate; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
    public void setOxygenLevel(int oxygenLevel) { this.oxygenLevel = oxygenLevel; }
}