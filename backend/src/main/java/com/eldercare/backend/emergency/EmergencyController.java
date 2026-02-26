package com.eldercare.backend.emergency;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/emergency")
@CrossOrigin(origins = "*")
public class EmergencyController {

    private final EmergencyRepository repository;

    public EmergencyController(EmergencyRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public EmergencyAlert triggerEmergency(@RequestParam Long userId) {
        EmergencyAlert alert = new EmergencyAlert(userId);
        return repository.save(alert);
    }

    @GetMapping("/active")
    public List<EmergencyAlert> getActiveEmergencies() {
        return repository.findByStatus("ACTIVE");
    }
}