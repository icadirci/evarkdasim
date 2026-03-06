package com.evarkdasim.evarkadasim_api.dto.response.listing;

import com.evarkdasim.evarkadasim_api.entity.City;
import com.evarkdasim.evarkadasim_api.entity.District;
import com.evarkdasim.evarkadasim_api.entity.Listing;
import com.evarkdasim.evarkadasim_api.entity.Neighborhood;
import com.evarkdasim.evarkadasim_api.enums.listing.GenderPreference;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public record CreateListingResponse(
        UUID id,
        String title,
        BigDecimal price,
        Integer roomCount,
        GenderPreference genderPreference,
        String city,
        String district,
        String neighborhoods
) {

    public static CreateListingResponse fromEntity(Listing listing) {
        return new CreateListingResponse(
            listing.getId(),
            listing.getTitle(),
            listing.getPrice(),
            listing.getRoomCount(),
            listing.getGenderPreference(),
            listing.getCity().getName(),
            listing.getDistrict().getName(),
            listing.getNeighborhood().getName()
        );
    }
}
