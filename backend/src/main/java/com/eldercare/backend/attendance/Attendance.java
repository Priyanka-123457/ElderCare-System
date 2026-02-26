package com.eldercare.backend.attendance;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
    name = "attendance",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "activity_id", "date"})
    }
)
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long activityId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean attended;

    // Required by JPA
    public Attendance() {
    }

    // Used by service logic
    public Attendance(Long userId, Long activityId, LocalDate date, boolean attended) {
        this.userId = userId;
        this.activityId = activityId;
        this.date = date;
        this.attended = attended;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
}
