package com.vqr.backend.repositories;

import com.vqr.backend.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
    List<ClientModel> findAllByNameContainingIgnoreCase(String name);
}