package com.eldercare.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Activity name cannot be empty")
    private String name;

    @NotBlank(message = "Category cannot be empty")
    private String category;

    // ✅ REQUIRED by JPA & Jackson
    public Activity() {
    }

    // Optional constructor
    public Activity(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    // ✅ GETTERS
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    // ✅ SETTERS (THIS WAS MISSING)
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
