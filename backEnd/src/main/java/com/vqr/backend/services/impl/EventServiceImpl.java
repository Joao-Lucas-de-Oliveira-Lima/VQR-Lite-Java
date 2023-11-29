package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.event.EventPatchDto;
import com.vqr.backend.dtos.event.EventPostDto;
import com.vqr.backend.dtos.event.EventResponseDto;
import com.vqr.backend.models.ClientModel;
import com.vqr.backend.models.EventModel;
import com.vqr.backend.models.Location;
import com.vqr.backend.repositories.EventRepository;
import com.vqr.backend.services.ClientService;
import com.vqr.backend.services.EventService;
import com.vqr.backend.services.FinanceService;
import com.vqr.backend.services.PasswordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final PasswordService passwordService;
    private final ClientService clientService;
    private final FinanceService financeService;

    public EventServiceImpl(
            EventRepository eventRepository,
            ClientService clientService,
            PasswordService passwordService,
            FinanceService financeService) {
        this.eventRepository = eventRepository;
        this.clientService = clientService;
        this.passwordService = passwordService;
        this.financeService = financeService;
    }

    //todo: decouple knowledge from the model attributes
    public Optional<EventResponseDto> saveNewEvent(EventPostDto eventData) {
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
        EventModel savedEvent = eventRepository.save(eventToBeSaved);
        passwordService.createListOfEmptyPasswordsForStartingAnEvent(
                eventToBeSaved.getNumberOfInitialPasswords(),
                savedEvent);
        financeService.createFinance(savedEvent);
        return Optional.of(eventRepository.save(eventToBeSaved).convertToResponseDto());
    }

    public Optional<EventResponseDto> findEventById(UUID id) {
        Optional<EventModel> eventToBeFound = eventRepository.findById(id);
        if (eventToBeFound.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(eventToBeFound.get().convertToResponseDto());
    }

    public List<EventResponseDto> findEvents(UUID eventOwnerId) {
        List<EventModel> foundEvents = new ArrayList<>();
        if(eventOwnerId != null){
            Optional<ClientModel> eventOwner = clientService.findForAnEventOwner(eventOwnerId);
            if(eventOwner.isPresent()){
                foundEvents = eventRepository.findAllByEventOwner(eventOwner.get());
            }
        }else{
            foundEvents = eventRepository.findAll();
        }
        List<EventResponseDto> foundEventsDto = new ArrayList<EventResponseDto>();
        foundEvents.forEach(
                event -> {
                    foundEventsDto.add(event.convertToResponseDto());
                }
        );
        return foundEventsDto;
    }

    //todo: improve copying of common attributes
    public Optional<EventResponseDto> modifyEvent(UUID id, EventPatchDto eventData) {
        Optional<EventModel> eventToBeModified = eventRepository.findById(id);
        if (eventToBeModified.isEmpty()) {
            return Optional.empty();
        }
        if (eventData.name() != null) {
            eventToBeModified.get().setName(eventData.name());
        }
        if(eventData.beginDateTime() != null){
            eventToBeModified.get().setBeginDateTime(eventData.beginDateTime());
        }
        if(eventData.location() != null){
            if(eventData.location().county() != null){
                eventToBeModified.get().getLocation().setCounty(eventData.location().county());
            }
            if(eventData.location().state() != null){
                eventToBeModified.get().getLocation().setState(eventData.location().state());
            }
        }
        if(eventData.numberOfPasswordsToBeAdded().isPresent()){
            int numberOfPasswordsToBeAdded = eventData.numberOfPasswordsToBeAdded().get();
            if(numberOfPasswordsToBeAdded > 0){
                passwordService.increaseTheNumberOfAvailableEventPasswords(
                        numberOfPasswordsToBeAdded,
                        eventToBeModified.get()
                );
                eventToBeModified.get().setNumberOfTotalPasswords(
                        eventToBeModified.get().getNumberOfTotalPasswords() + numberOfPasswordsToBeAdded
                );
                eventToBeModified.get().setTotalNumberOfTimesMorePasswordsWereAdded(
                        eventToBeModified.get().getTotalNumberOfTimesMorePasswordsWereAdded() + 1
                );
            }else{
                return Optional.empty();
            }
        }
        return Optional.of(eventRepository.save(eventToBeModified.get()).convertToResponseDto());
    }
}
