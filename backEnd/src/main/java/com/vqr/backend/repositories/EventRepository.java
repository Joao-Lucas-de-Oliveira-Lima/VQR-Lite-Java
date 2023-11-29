package com.vqr.backend.repositories;

import com.vqr.backend.models.ClientModel;
import com.vqr.backend.models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<EventModel, UUID> {
    List<EventModel> findAllByEventOwner(ClientModel eventOwner);
}
