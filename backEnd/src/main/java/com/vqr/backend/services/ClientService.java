package com.vqr.backend.services;

import com.vqr.backend.dtos.ClientDto;
import com.vqr.backend.models.ClientModel;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    ResponseEntity<ClientModel> saveClient(ClientDto clientData);
}
