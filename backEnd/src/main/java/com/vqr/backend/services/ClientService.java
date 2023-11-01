package com.vqr.backend.services;

import com.vqr.backend.dtos.ClientDto;
import com.vqr.backend.models.ClientModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {
    ClientModel saveClient(ClientDto clientData);

    Optional<ClientModel> findClientById(UUID id);

    List<ClientModel> findClients(String name);
}
