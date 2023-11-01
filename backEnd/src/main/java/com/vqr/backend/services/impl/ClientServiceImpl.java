package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.ClientDto;
import com.vqr.backend.models.ClientModel;
import com.vqr.backend.repositories.ClientRepository;
import com.vqr.backend.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<ClientModel> findClientById(UUID id){
        return clientRepository.findById(id);
    }

    public List<ClientModel> findClients(String name) {
        if(name != null){
            return clientRepository.findAllByNameContainingIgnoreCase(name);
        }
        return clientRepository.findAll();
    }
}
