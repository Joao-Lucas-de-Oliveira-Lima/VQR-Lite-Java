package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.client.ClientPatchDto;
import com.vqr.backend.dtos.client.ClientPostDto;
import com.vqr.backend.dtos.client.ClientResponseDto;
import com.vqr.backend.models.ClientModel;
import com.vqr.backend.repositories.ClientRepository;
import com.vqr.backend.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientResponseDto saveNewClient(ClientPostDto clientData) {
        ClientModel clientToSave = new ClientModel();
        BeanUtils.copyProperties(clientData, clientToSave);
        clientToSave = clientRepository.save(clientToSave);
        return clientToSave.convertToResponseDto();
    }

    public Optional<ClientResponseDto> findClientById(UUID id) {
        Optional<ClientModel> clientToBeFound = clientRepository.findById(id);
        if (clientToBeFound.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(clientToBeFound.get().convertToResponseDto());
    }

    public List<ClientResponseDto> findClients(String name) {
        List<ClientModel> foundClients;
        if (name != null) {
            foundClients = clientRepository.findAllByNameContainingIgnoreCase(name);
        } else {
            foundClients = clientRepository.findAll();
        }
        List<ClientResponseDto> foundClientsDto = new ArrayList<>();
        foundClients.forEach(client -> {
            foundClientsDto.add(client.convertToResponseDto());
        });
        return foundClientsDto;
    }

    public Optional<ClientResponseDto> modifyClient(UUID id, ClientPatchDto clientData) {
        Optional<ClientModel> clientToBeModified = clientRepository.findById(id);
        if (clientToBeModified.isEmpty()) {
            return Optional.empty();
        }
        if (clientData.name() != null) {
            clientToBeModified.get().setName(clientData.name());
        }
        if (clientData.email() != null) {
            clientToBeModified.get().setEmail(clientData.email());
        }
        if (clientData.phoneNumber() != null) {
            clientToBeModified.get().setPhoneNumber(clientData.phoneNumber());
        }
        return Optional.of(clientRepository.save(clientToBeModified.get()).convertToResponseDto());
    }

    public Boolean deleteClient(UUID id) {
        Optional<ClientModel> clientToBeDeleted = clientRepository.findById(id);
        if (clientToBeDeleted.isEmpty()) {
            return false;
        }
        clientRepository.deleteById(id);
        return true;
    }

    public Optional<ClientModel> findForAnEventOwner(UUID id){
        Optional<ClientModel> clientToBeFound = clientRepository.findById(id);
        if(clientToBeFound.isEmpty()){
            return Optional.empty();
        }
        return clientToBeFound;
    }
}
