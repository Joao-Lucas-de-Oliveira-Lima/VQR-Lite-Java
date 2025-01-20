package com.vqr.backend.dtos.payment;

import com.vqr.backend.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record PaymentPatchDto(
        @NotNull
        PaymentMethod paymentMethod,
        @NotNull
        @PositiveOrZero
        BigDecimal value) { }
