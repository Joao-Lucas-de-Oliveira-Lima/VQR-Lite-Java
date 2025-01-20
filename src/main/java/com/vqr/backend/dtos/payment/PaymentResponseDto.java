package com.vqr.backend.dtos.payment;

import com.vqr.backend.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record PaymentResponseDto(
        PaymentMethod paymentMethod,
        BigDecimal value) {
}
