package com.vqr.backend.repositories;

import com.vqr.backend.dtos.clients.ClientResponseDto;
import com.vqr.backend.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
    List<ClientModel> findAllByNameContainingIgnoreCase(String name);
}