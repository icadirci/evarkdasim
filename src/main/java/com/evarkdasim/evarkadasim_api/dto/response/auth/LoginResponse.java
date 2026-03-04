package com.evarkdasim.evarkadasim_api.dto.response.auth;

import java.util.UUID;

public record LoginResponse(
        UUID id,
        String email,
        String token
) {
}
