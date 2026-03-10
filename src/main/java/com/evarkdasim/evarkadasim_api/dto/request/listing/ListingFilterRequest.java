package com.evarkdasim.evarkadasim_api.dto.request.listing;

import java.math.BigDecimal;

public record ListingFilterRequest(
        String title,
        Long cityId,
        Long districtId,
        Long neighborhoodId,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        String sortBy,

) {
}
