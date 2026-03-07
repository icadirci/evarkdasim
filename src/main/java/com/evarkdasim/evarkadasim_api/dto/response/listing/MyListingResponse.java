package com.evarkdasim.evarkadasim_api.dto.response.listing;

import com.evarkdasim.evarkadasim_api.entity.Listing;

import java.math.BigDecimal;
import java.util.UUID;

public record MyListingResponse(
        UUID id,
        String title,
        BigDecimal price,
        String cityName,
        String districtName
) {
    public static MyListingResponse fromEntity(Listing listing) {
        return new MyListingResponse(
                listing.getId(),
                listing.getTitle(),
                listing.getPrice(),
                listing.getCity().getName(),
                listing.getDistrict().getName()
        );
    }
}