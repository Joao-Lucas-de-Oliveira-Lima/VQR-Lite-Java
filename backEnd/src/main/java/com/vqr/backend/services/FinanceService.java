package com.vqr.backend.services;

import com.vqr.backend.dtos.Finance.FinanceResponseDto;
import com.vqr.backend.models.EventModel;
import com.vqr.backend.models.FinanceModel;

import java.util.Optional;
import java.util.UUID;

public interface FinanceService {

    FinanceResponseDto createFinance(EventModel eventData);

    Optional<FinanceResponseDto> findEventFinances(UUID eventId);
}
