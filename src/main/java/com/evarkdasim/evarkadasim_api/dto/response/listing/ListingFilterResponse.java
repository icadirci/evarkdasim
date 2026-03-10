package com.evarkdasim.evarkadasim_api.dto.response.listing;

import java.math.BigDecimal;
import java.util.UUID;

public record ListingFilterResponse(
        UUID id,
        String title,
        BigDecimal price,
        String cityName,
        String districtName
) {
}
