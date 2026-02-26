package com.eldercare.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eldercare.backend.wellbeing.WellBeing;

public interface WellBeingRepository extends JpaRepository<WellBeing, Long> {

    List<WellBeing> findByUserId(Long userId);

}
