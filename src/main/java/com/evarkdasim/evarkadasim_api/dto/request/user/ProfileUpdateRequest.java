package com.evarkdasim.evarkadasim_api.dto.request.user;

import com.evarkdasim.evarkadasim_api.enums.listing.Gender;

import java.time.LocalDate;

public record ProfileUpdateRequest(
        String email,
        String fullName,
        Gender gender,
        LocalDate birthday,
        String description
) {
}