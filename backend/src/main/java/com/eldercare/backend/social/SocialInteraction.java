package com.eldercare.backend.social;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "social_interaction")
public class SocialInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int callsMade;          // number of calls today
    private int familyInteractions; // family visits or calls
    private int communityEvents;    // activities attended

    private LocalDate date;

    public SocialInteraction() {}

    public SocialInteraction(Long userId, int callsMade,
                             int familyInteractions, int communityEvents) {
        this.userId = userId;
        this.callsMade = callsMade;
        this.familyInteractions = familyInteractions;
        this.communityEvents = communityEvents;
        this.date = LocalDate.now();
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public int getCallsMade() { return callsMade; }
    public int getFamilyInteractions() { return familyInteractions; }
    public int getCommunityEvents() { return communityEvents; }
    public LocalDate getDate() { return date; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setCallsMade(int callsMade) { this.callsMade = callsMade; }
    public void setFamilyInteractions(int familyInteractions) { this.familyInteractions = familyInteractions; }
    public void setCommunityEvents(int communityEvents) { this.communityEvents = communityEvents; }
}