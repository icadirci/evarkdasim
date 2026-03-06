package com.evarkdasim.evarkadasim_api.repository;

import com.evarkdasim.evarkadasim_api.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ListingRepository extends JpaRepository<Listing, UUID> {
    List<Listing> findAllByUserId(UUID userId);
}
