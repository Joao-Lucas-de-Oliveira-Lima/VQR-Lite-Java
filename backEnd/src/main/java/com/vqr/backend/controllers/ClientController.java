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

    @GetMapping("/clients")
    public ResponseEntity<List<ClientModel>> findAllClientsByName(
            @RequestParam(value = "name") String name){
        List<ClientModel> result = clientService.findAllClientsByName(name);
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(result);
    }
}
