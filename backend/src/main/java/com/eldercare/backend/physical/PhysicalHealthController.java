package com.eldercare.backend.physical;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/physical")
@CrossOrigin(origins = "*")
public class PhysicalHealthController {

    private final PhysicalHealthService service;

    public PhysicalHealthController(PhysicalHealthService service) {
        this.service = service;
    }

    // Save today's physical health data
    @PostMapping
    public PhysicalHealth saveToday(@RequestBody PhysicalHealth health) {
        return service.saveToday(health);
    }

    // Get today's data
    @GetMapping("/today/{userId}")
    public PhysicalHealth getToday(@PathVariable Long userId) {
        return service.getToday(userId);
    }

    // Get history
    @GetMapping("/history/{userId}")
    public List<PhysicalHealth> getHistory(@PathVariable Long userId) {
        return service.getHistory(userId);
    }
}