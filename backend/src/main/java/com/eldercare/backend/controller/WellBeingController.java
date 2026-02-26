package com.eldercare.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.eldercare.backend.service.WellBeingService;
import com.eldercare.backend.user.User;
import com.eldercare.backend.wellbeing.WellBeing;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/wellbeing")
public class WellBeingController {

    private final WellBeingService wellBeingService;

    public WellBeingController(WellBeingService wellBeingService) {
        this.wellBeingService = wellBeingService;
    }

    @PostMapping("/user/{userId}")
    public WellBeing addEntry(
            @PathVariable Long userId,
            @RequestBody WellBeing entry) {

        User user = new User();
        user.setId(userId);

        return wellBeingService.addEntry(entry, user);
    }

    @GetMapping("/user/{userId}")
    public List<WellBeing> getHistory(@PathVariable Long userId) {

        User user = new User();
        user.setId(userId);

        return wellBeingService.getHistory(user);
    }
}
