package com.eldercare.backend.vital;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vitals")
@CrossOrigin(origins = "*")
public class VitalStatusController {

    private final VitalStatusService service;

    public VitalStatusController(VitalStatusService service) {
        this.service = service;
    }

    // Save today's vitals
    @PostMapping
    public VitalStatus saveToday(@RequestBody VitalStatus vital) {
        return service.saveToday(vital);
    }

    // Get today's vitals
    @GetMapping("/today/{userId}")
    public VitalStatus getToday(@PathVariable Long userId) {
        return service.getToday(userId);
    }

    // Get history
    @GetMapping("/history/{userId}")
    public List<VitalStatus> getHistory(@PathVariable Long userId) {
        return service.getHistory(userId);
    }
}