package com.evarkdasim.evarkadasim_api.repository;

import com.evarkdasim.evarkadasim_api.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ListingRepository extends JpaRepository<Listing, UUID> {
    List<Listing> findAllByUserId(UUID userId);

    @Query("""
            select l
            from Listing l
              join fetch l.city
              join fetch l.district
            where l.user.id = :userId
            """)
    List<Listing> findAllByUserIdWithCityDistrict(@Param("userId") UUID userId);
}
