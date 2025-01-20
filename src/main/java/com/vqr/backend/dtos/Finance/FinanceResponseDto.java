package com.vqr.backend.dtos.Finance;

import java.math.BigDecimal;
import java.util.UUID;

public record FinanceResponseDto(
        UUID id,
        int numberOfInitialPasswords,
        int totalPasswordsAdded,
        int totalNumberOfPasswords,
        int totalPasswordsSold,
        int totalOfBullsTv,
        BigDecimal totalMoney,
        BigDecimal totalAmountRaisedViaPix,
        BigDecimal totalAmountOfCashCollected,
        BigDecimal totalAmountOfMoneyCollectedViaCard) { }
