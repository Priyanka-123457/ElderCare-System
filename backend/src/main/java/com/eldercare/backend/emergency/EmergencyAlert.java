package com.eldercare.backend.emergency;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EmergencyAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private LocalDateTime timestamp;

    private String status; // ACTIVE or RESOLVED

    public EmergencyAlert() {}

    public EmergencyAlert(Long userId) {
        this.userId = userId;
        this.timestamp = LocalDateTime.now();
        this.status = "ACTIVE";
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}