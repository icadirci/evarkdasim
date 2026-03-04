package com.evarkdasim.evarkadasim_api.dto.request.auth;

import com.evarkdasim.evarkadasim_api.enums.listing.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @NotBlank String name,
        @Email @NotBlank String email,
        @NotBlank String password,
        @NotBlank String password_confirmation,
        Gender gender
) {
}
