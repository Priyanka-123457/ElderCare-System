package com.eldercare.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eldercare.backend.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
