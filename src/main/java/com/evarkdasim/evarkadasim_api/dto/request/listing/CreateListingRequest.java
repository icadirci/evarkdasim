package com.evarkdasim.evarkadasim_api.dto.request.listing;

import com.evarkdasim.evarkadasim_api.enums.listing.GenderPreference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public record CreateListingRequest(
        @NotBlank String title,
        @NotNull BigDecimal price,
        Integer roomCount,
        @NotNull GenderPreference genderPreference,
        @NotNull BigInteger cityId,
        @NotNull BigInteger districtId,
        @NotNull BigInteger neighborhoodsId,
        @NotBlank String description
        ) {
}
