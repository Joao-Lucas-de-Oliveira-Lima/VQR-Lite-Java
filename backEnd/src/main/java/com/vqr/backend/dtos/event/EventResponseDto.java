package com.vqr.backend.dtos.event;

import com.vqr.backend.dtos.location.LocationDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventResponseDto(
        UUID id,
        String name,
        int numberOfInitialEventPasswords,
        int numberOfTotalEventPasswords,
        LocalDateTime beginDateTime,
        LocationDto location) {
}
