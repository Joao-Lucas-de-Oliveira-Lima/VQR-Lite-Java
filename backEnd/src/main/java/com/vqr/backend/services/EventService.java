package com.vqr.backend.services;

import com.vqr.backend.dtos.event.EventPostDto;
import com.vqr.backend.dtos.event.EventResponseDto;
import com.vqr.backend.models.EventModel;

import java.util.Optional;

public interface EventService {
    Optional<EventResponseDto> saveNewEvent(EventPostDto eventData);
    EventResponseDto converterToEventResponseDto(EventModel eventData);
}
