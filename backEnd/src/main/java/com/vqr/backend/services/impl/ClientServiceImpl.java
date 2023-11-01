package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.ClientDto;
import com.vqr.backend.models.ClientModel;
import com.vqr.backend.repositories.ClientRepository;
import com.vqr.backend.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientModel saveClient(ClientDto clientData) {
        ClientModel clientToSave = new ClientModel();
        BeanUtils.copyProperties(clientData, clientToSave);
        return clientRepository.save(clientToSave);
    }

    public List<ClientModel> findAllClientsByName(String name) {
        return clientRepository.findAllByNameContainingIgnoreCase(name);
    }
}
