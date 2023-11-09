package com.vqr.backend.services;

import com.vqr.backend.dtos.clients.ClientPatchDto;
import com.vqr.backend.dtos.clients.ClientResponseDto;
import com.vqr.backend.dtos.clients.ClientPostDto;
import com.vqr.backend.models.ClientModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {
    ClientResponseDto saveNewClient(ClientPostDto clientData);

    Optional<ClientResponseDto> findClientById(UUID id);

    List<ClientResponseDto> findClients(String name);

    Optional<ClientResponseDto> modifyClient(UUID id, ClientPatchDto clientData);

    Boolean deleteClient(UUID id);
}
