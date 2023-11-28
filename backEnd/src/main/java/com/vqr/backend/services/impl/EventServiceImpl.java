package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.event.EventPatchDto;
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
        return Optional.of(eventRepository.save(eventToBeSaved).convertToResponseDto());
    }

    public Optional<EventResponseDto> findEventById(UUID id){
        Optional<EventModel> eventToBeFound = eventRepository.findById(id);
        if(eventToBeFound.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(eventToBeFound.get().convertToResponseDto());
    }

    public List<EventResponseDto> findEvents(){
        List<EventModel> foundEvents = eventRepository.findAll();
        List<EventResponseDto> foundEventsDto = new ArrayList<EventResponseDto>();
        foundEvents.forEach(
                event -> {
                    foundEventsDto.add(event.convertToResponseDto());
                }
        );
        return foundEventsDto;
    }

    public Optional<EventResponseDto> modifyEvent(UUID id, EventPatchDto eventData){
        Optional<EventModel> eventToBeModified = eventRepository.findById(id);
        if(eventToBeModified.isEmpty()){
            return Optional.empty();
        }
        if(eventData.name() != null){
            eventToBeModified.get().setName(eventData.name());
        }
        return Optional.of(eventRepository.save(eventToBeModified.get()).convertToResponseDto());
    }
}
