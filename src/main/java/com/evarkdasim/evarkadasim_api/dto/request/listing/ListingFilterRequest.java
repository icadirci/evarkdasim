package com.evarkdasim.evarkadasim_api.dto.request.listing;

import com.evarkdasim.evarkadasim_api.enums.listing.ListingSortType;
import jakarta.annotation.Nullable;

import java.math.BigDecimal;

public record ListingFilterRequest(
        Integer page,
//        @Nullable String title,
        @Nullable Long cityId,
        @Nullable Long districtId,
        @Nullable Long neighborhoodId,
        @Nullable BigDecimal minPrice,
        @Nullable BigDecimal maxPrice,
        @Nullable ListingSortType sortBy

) {
}
