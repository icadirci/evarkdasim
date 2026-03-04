package com.evarkdasim.evarkadasim_api.dto.response.auth;

import lombok.Builder;

public record RegisterResponse (
        String token,
        String email
){
}
