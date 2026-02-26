package com.eldercare.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eldercare.backend.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByCategory(String category);
}
