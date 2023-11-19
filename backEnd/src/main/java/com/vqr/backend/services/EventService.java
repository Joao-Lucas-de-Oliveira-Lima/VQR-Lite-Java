package com.vqr.backend.services;

import com.vqr.backend.dtos.event.EventPostDto;
import com.vqr.backend.dtos.event.EventResponseDto;
import com.vqr.backend.models.EventModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventService {
    Optional<EventResponseDto> saveNewEvent(EventPostDto eventData);
    Optional<EventResponseDto> findEventById(UUID id);
    List<EventResponseDto> findEvents();
    EventResponseDto converterToEventResponseDto(EventModel eventData);
}
