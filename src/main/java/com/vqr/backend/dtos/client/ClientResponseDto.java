package com.vqr.backend.dtos.client;

import java.util.UUID;

public record ClientResponseDto(
        UUID id,
        String name,
        String email,
        String phoneNumber) {
}
