package com.vqr.backend.services;

import com.vqr.backend.dtos.ClientDto;
import com.vqr.backend.models.ClientModel;

import java.util.List;

public interface ClientService {
    ClientModel saveClient(ClientDto clientData);

    List<ClientModel> findAllClientsByName(String name);
}
