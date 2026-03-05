package com.evarkdasim.evarkadasim_api.dto.response.user;

import com.evarkdasim.evarkadasim_api.entity.User;
import com.evarkdasim.evarkadasim_api.enums.listing.Gender;

import java.time.LocalDate;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String email,
        String fullName,
        Gender gender,
        LocalDate birthday,
        String description
) {
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getGender(),
                user.getBirthday(),
                user.getDescription()
        );
    }
}
