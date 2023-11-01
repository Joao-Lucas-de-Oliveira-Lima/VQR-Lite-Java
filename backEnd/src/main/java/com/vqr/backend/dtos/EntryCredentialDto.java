package com.vqr.backend.dtos;

import com.vqr.backend.enums.PaymentEnum;
import com.vqr.backend.models.AddressModel;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record EntryCredentialDto(
        @NotNull @PositiveOrZero int entryCredentialNumber,
        @NotNull Boolean isAvailable,
        @NotBlank String tailPuller,
        @NotBlank String tailPullerHorse,
        @NotBlank String helper,
        @NotBlank String helperHorse,
        @NotNull AddressModel address,
        @NotNull boolean hasBullTv,
        @NotNull BigDecimal entryCredentialCost,
        @NotNull PaymentEnum paymentMethod
) {
}
