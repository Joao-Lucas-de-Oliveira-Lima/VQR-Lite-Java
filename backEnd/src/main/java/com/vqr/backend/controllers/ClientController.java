package com.vqr.backend.controllers;

import com.vqr.backend.dtos.ClientDto;
import com.vqr.backend.models.ClientModel;
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
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public ResponseEntity<ClientModel> saveNewClient(@RequestBody @Valid ClientDto clientData){
        ClientModel result = clientService.saveClient(clientData);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Object> finClientById(@PathVariable(value = "id") UUID id){
        Optional<ClientModel> result = clientService.findClientById(id);
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientModel>> findClients(
            @RequestParam(value = "name", required = false) String name){
        List<ClientModel> result = clientService.findClients(name);
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
