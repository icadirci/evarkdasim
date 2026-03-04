package com.evarkdasim.evarkadasim_api.repository;

import com.evarkdasim.evarkadasim_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
