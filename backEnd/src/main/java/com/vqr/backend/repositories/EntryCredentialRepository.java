package com.vqr.backend.repositories;

import com.vqr.backend.models.EntryCredentialModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntryCredentialRepository extends JpaRepository<EntryCredentialModel, UUID> {
}
