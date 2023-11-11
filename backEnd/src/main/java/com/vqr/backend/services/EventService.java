package com.vqr.backend.services;

import com.vqr.backend.dtos.event.EventPostDto;
import com.vqr.backend.dtos.event.EventResponseDto;

public interface EventService {
    EventResponseDto saveNewEvent(EventPostDto eventData);
}
