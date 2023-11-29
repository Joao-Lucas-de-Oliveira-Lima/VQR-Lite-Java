package com.vqr.backend.repositories;

import com.vqr.backend.models.EventModel;
import com.vqr.backend.models.FinanceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FinanceRepository extends JpaRepository<FinanceModel, UUID> {
    Optional<FinanceModel> findByEvent(EventModel event);
}
