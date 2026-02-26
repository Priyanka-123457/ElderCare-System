package com.eldercare.backend.physical;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "physical_health")
public class PhysicalHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int steps;

    private int exerciseMinutes;

    private int sleepHours;

    private boolean medicineTaken;

    private LocalDate date;

    public PhysicalHealth() {}

    public PhysicalHealth(Long userId, int steps, int exerciseMinutes,
                          int sleepHours, boolean medicineTaken) {
        this.userId = userId;
        this.steps = steps;
        this.exerciseMinutes = exerciseMinutes;
        this.sleepHours = sleepHours;
        this.medicineTaken = medicineTaken;
        this.date = LocalDate.now();
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public int getSteps() { return steps; }
    public int getExerciseMinutes() { return exerciseMinutes; }
    public int getSleepHours() { return sleepHours; }
    public boolean isMedicineTaken() { return medicineTaken; }
    public LocalDate getDate() { return date; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setSteps(int steps) { this.steps = steps; }
    public void setExerciseMinutes(int exerciseMinutes) { this.exerciseMinutes = exerciseMinutes; }
    public void setSleepHours(int sleepHours) { this.sleepHours = sleepHours; }
    public void setMedicineTaken(boolean medicineTaken) { this.medicineTaken = medicineTaken; }
}