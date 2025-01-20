package com.vqr.backend.dtos.event;

import ch.qos.logback.core.net.server.Client;
import com.vqr.backend.dtos.client.ClientResponseDto;
import com.vqr.backend.dtos.location.LocationDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventResponseDto(
        UUID id,
        String name,
        int numberOfInitialEventPasswords,
        int numberOfTotalEventPasswords,
        int totalNumberOfTimesMorePasswordsWereAdded,
        LocalDateTime beginDateTime,
        LocationDto location,
        ClientResponseDto eventOwner) {
}
