package com.evarkdasim.evarkadasim_api.repository;

import com.evarkdasim.evarkadasim_api.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface DistrictRepository extends JpaRepository<District, BigInteger> {
}
