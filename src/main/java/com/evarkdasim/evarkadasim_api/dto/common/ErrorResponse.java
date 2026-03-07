package com.evarkdasim.evarkadasim_api.dto.common;

import java.util.List;

public record ErrorResponse(
        int status,
        String message,
        long timestamp,
        List<String> errors // Özellikle validasyon hataları için
) {}