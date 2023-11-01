package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.ClientDto;
import com.vqr.backend.models.ClientModel;
import com.vqr.backend.repositories.ClientRepository;
import com.vqr.backend.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<ClientModel> saveClient(ClientDto clientData){
        var clientToSave = new ClientModel();
        BeanUtils.copyProperties(clientData, clientToSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(clientToSave));
    }
}
