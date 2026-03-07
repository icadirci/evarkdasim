package com.evarkdasim.evarkadasim_api.repository;

import com.evarkdasim.evarkadasim_api.entity.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {
}
