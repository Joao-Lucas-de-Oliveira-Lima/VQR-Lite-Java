package com.vqr.backend.dtos.events;

import com.vqr.backend.models.Locality;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.UUID;

public record EventResponseDto(
        UUID id,
        String name,
        int numberOfInitialEventPasswords,
        int numberOfTotalEventPasswords,
        LocalDateTime dataAndTime,
        Locality locality) {
}
