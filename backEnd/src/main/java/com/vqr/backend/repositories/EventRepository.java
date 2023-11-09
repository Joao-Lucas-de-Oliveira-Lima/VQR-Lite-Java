package com.vqr.backend.repositories;

import com.vqr.backend.models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<EventModel, UUID> { }
