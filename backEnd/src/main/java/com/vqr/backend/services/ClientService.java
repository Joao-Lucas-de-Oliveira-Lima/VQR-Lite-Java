package com.vqr.backend.services;

import com.vqr.backend.dtos.client.ClientPatchDto;
import com.vqr.backend.dtos.client.ClientResponseDto;
import com.vqr.backend.dtos.client.ClientPostDto;

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
