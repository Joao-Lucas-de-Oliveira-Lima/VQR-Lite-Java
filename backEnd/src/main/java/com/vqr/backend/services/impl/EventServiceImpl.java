package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.event.EventPostDto;
import com.vqr.backend.dtos.event.EventResponseDto;
import com.vqr.backend.dtos.location.LocationDto;
import com.vqr.backend.models.ClientModel;
import com.vqr.backend.models.EventModel;
import com.vqr.backend.models.Location;
import com.vqr.backend.repositories.EventRepository;
import com.vqr.backend.services.ClientService;
import com.vqr.backend.services.EventService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ClientService clientService;

    public EventServiceImpl(
            EventRepository eventRepository,
            ClientService clientService) {
        this.eventRepository = eventRepository;
        this.clientService = clientService;
    }

    public Optional<EventResponseDto> saveNewEvent(EventPostDto eventData) {
        System.out.println(eventData.toString());
        Optional<ClientModel> eventOwner = clientService.findForAnEventOwner(eventData.eventOwnerId());
        if (eventOwner.isEmpty()) {
            return Optional.empty();
        }
        EventModel eventToBeSaved = new EventModel(
                eventData.name(),
                eventData.numberOfInitialPasswords(),
                eventData.beginDateTime(),
                new Location(
                        eventData.location().county(),
                        eventData.location().state()
                ),
                eventOwner.get()
        );
        return Optional.of(converterToEventResponseDto(eventRepository.save(eventToBeSaved)));
    }

    public Optional<EventResponseDto> findEventById(UUID id){
        Optional<EventModel> eventToBeFound = eventRepository.findById(id);
        if(eventToBeFound.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(converterToEventResponseDto(eventToBeFound.get()));
    }

    public List<EventResponseDto> findEvents(){
        List<EventModel> foundEvents = eventRepository.findAll();
        List<EventResponseDto> response = new ArrayList<EventResponseDto>();
        foundEvents.forEach(
                event -> {
                    response.add(converterToEventResponseDto(event));
                }
        );
        return response;
    }

    public EventResponseDto converterToEventResponseDto(EventModel eventData) {
        return new EventResponseDto(
                eventData.getId(),
                eventData.getName(),
                eventData.getNumberOfInitialPasswords(),
                eventData.getNumberOfTotalPasswords(),
                eventData.getBeginDateTime(),
                new LocationDto(
                        eventData.getLocation().getCounty(),
                        eventData.getLocation().getState()
                ),
                clientService.convertToClientResponseDto(eventData.getEventOwner())
        );
    }
}
