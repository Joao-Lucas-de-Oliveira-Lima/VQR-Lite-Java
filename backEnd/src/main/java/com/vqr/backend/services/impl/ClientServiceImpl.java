package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.clients.ClientResponseDto;
import com.vqr.backend.dtos.clients.ClientPatchDto;
import com.vqr.backend.dtos.clients.ClientPostDto;
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

    public ClientResponseDto saveNewClient(ClientPostDto clientData) {
        ClientModel clientToSave = new ClientModel();
        BeanUtils.copyProperties(clientData, clientToSave);
        clientToSave = clientRepository.save(clientToSave);
        return createDtoReponse(clientToSave);
    }

    public Optional<ClientResponseDto> findClientById(UUID id) {
        Optional<ClientModel> clientToBeFound = clientRepository.findById(id);
        if (clientToBeFound.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(createDtoReponse(clientToBeFound.get()));
    }

    public List<ClientResponseDto> findClients(String name) {
        List<ClientModel> foundClients;
        if (name != null) {
            foundClients = clientRepository.findAllByNameContainingIgnoreCase(name);
        }
        foundClients = clientRepository.findAll();
        List<ResponseClientDto> found
    }

    private static ClientResponseDto createDtoReponse(ClientModel clientData) {
        ClientResponseDto response = new ClientResponseDto(
                clientData.getId(),
                clientData.getName(),
                clientData.getEmail(),
                clientData.getPhoneNumber());
        return response;
    }

}
