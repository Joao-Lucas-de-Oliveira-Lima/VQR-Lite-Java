package com.vqr.backend.dtos.clients;

import java.util.UUID;

public record ClientResponseDto(
        UUID id,
        String name,
        String email,
        String phoneNumber) {
}
