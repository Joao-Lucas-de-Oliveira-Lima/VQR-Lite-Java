package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.event.EventPostDto;
import com.vqr.backend.dtos.event.EventResponseDto;
import com.vqr.backend.dtos.location.LocationDto;
import com.vqr.backend.models.EventModel;
import com.vqr.backend.models.Location;
import com.vqr.backend.repositories.EventRepository;
import com.vqr.backend.services.EventService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventResponseDto saveNewEvent(EventPostDto eventData) {
        System.out.println(eventData.toString());
        EventModel eventToBeSaved = new EventModel(
                eventData.name(),
                eventData.numberOfInitialPasswords(),
                new Location(
                        eventData.location().county(),
                        eventData.location().state()
                )
        );
        return createResponseDto(eventRepository.save(eventToBeSaved));
    }

    private EventResponseDto createResponseDto(EventModel eventData) {
        return new EventResponseDto(
                eventData.getId(),
                eventData.getName(),
                eventData.getNumberOfInitialPasswords(),
                eventData.getNumberOfTotalPasswords(),
                eventData.getBeginDateTime(),
                new LocationDto(
                        eventData.getLocation().getCounty(),
                        eventData.getLocation().getState()
                )
        );
    }
}
