package com.vqr.backend.controllers;

import com.vqr.backend.dtos.clients.ClientPatchDto;
import com.vqr.backend.dtos.clients.ClientPostDto;
import com.vqr.backend.dtos.clients.ClientResponseDto;
import com.vqr.backend.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<ClientResponseDto> saveClient(@RequestBody @Valid ClientPostDto clientData) {
        ClientResponseDto result = clientService.saveNewClient(clientData);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> finClientById(@PathVariable(value = "id") UUID id) {
        Optional<ClientResponseDto> result = clientService.findClientById(id);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }

    @GetMapping()
    public ResponseEntity<List<ClientResponseDto>> findClients(
            @RequestParam(value = "name", required = false) String name) {
        List<ClientResponseDto> result = clientService.findClients(name);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Object> modifyClient(
            @PathVariable(value = "id")UUID id,
            @RequestBody @Valid ClientPatchDto clientData){
        Optional<ClientResponseDto> response = clientService.modifyClient(id, clientData);
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value = "id") UUID id){
        Boolean response = clientService.deleteClient(id);
        if(!response){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Client successfully deleted");
    }
}
