package com.evarkdasim.evarkadasim_api.dto.response.auth;

public record RegisterResponse (
        String token,
        String email
){
}
