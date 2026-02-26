package com.eldercare.backend.wellbeing;

import java.time.LocalDate;

import com.eldercare.backend.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "wellbeing_entries")
public class WellBeing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mood;              // happy, sad, anxious, calm
    private int lonelinessScore;      // 1–10

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public WellBeing() {}

    // getters
    public Long getId() {
        return id;
    }

    public String getMood() {
        return mood;
    }

    public int getLonelinessScore() {
        return lonelinessScore;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    // setters
    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setLonelinessScore(int lonelinessScore) {
        this.lonelinessScore = lonelinessScore;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
