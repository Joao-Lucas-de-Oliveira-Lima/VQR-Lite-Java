package com.vqr.backend.repositories;

import com.vqr.backend.models.PasswordModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PasswordRepository extends JpaRepository<PasswordModel, UUID> { }
