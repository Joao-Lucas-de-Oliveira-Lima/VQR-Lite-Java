package com.vqr.backend.controllers;

import com.vqr.backend.dtos.event.EventPatchDto;
import com.vqr.backend.dtos.event.EventPostDto;
import com.vqr.backend.dtos.event.EventResponseDto;
import com.vqr.backend.services.EventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventResponseDto> saveClient(@RequestBody @Valid EventPostDto eventData) {
        Optional<EventResponseDto> result = eventService.saveNewEvent(eventData);
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result.get());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable(value = "id") UUID id){
        Optional<EventResponseDto> result = eventService.findEventById(id);
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }
    @GetMapping()
    public ResponseEntity<List<EventResponseDto>> getEvents(){
        List<EventResponseDto> response = eventService.findEvents();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EventResponseDto> modifyEvent(
            @PathVariable(name = "id")UUID id,
            @RequestBody @Valid EventPatchDto eventData){
        Optional<EventResponseDto> response = eventService.modifyEvent(id, eventData);
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }
}
