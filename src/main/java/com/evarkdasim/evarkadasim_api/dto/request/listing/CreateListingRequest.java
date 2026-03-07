package com.evarkdasim.evarkadasim_api.dto.request.listing;

import com.evarkdasim.evarkadasim_api.enums.listing.GenderPreference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;

public record CreateListingRequest(
        @NotBlank @Size(min = 3, max = 255) String title,
        @NotNull @Positive BigDecimal price,
        @NotNull @Positive Integer roomCount,
        @NotNull GenderPreference genderPreference,
        @NotNull Long cityId,
        @NotNull Long districtId,
        @NotNull Long neighborhoodId,
        @NotBlank String description
        ) {
}
