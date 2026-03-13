package com.evarkdasim.evarkadasim_api.repository;

import com.evarkdasim.evarkadasim_api.entity.Listing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
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
    Page<Listing> findAllByUserIdWithCityDistrict(@Param("userId") UUID userId, Pageable pageable);

    @Query("SELECT COUNT(c) > 0 FROM City c " +
            "JOIN c.districts d " +
            "JOIN d.neighborhoods n " +
            "WHERE c.id = :cityId AND d.id = :districtId AND n.id = :neighborhoodId")
    boolean validateLocationHierarchy(Long cityId, Long districtId, Long neighborhoodId);

    @Query("""
            select l
            from Listing l
              join fetch l.city c
              join fetch l.district d
            where (:cityId is null or l.city_id = :cityId)
            and (:districtId is null or l.district_id = :districtId)
            and (:neighborhoodId is null or l.neighborhood_id = :neighborhoodId)
            and l.user_id = :userId
            """)
    Page<Listing> getAllListings(Long cityId, Long districtId, Long neighborhoodId, UUID userId, Pageable pageable);
}
