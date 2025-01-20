package com.vqr.backend.dtos.password;

import com.vqr.backend.dtos.location.LocationDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record PasswordPostDto(
        @NotBlank
        String puller,
        @NotBlank
        String pullerHorse,
        @NotBlank
        String grabber,
        @NotBlank
        String grabberHorse,
        @NotNull
        @Valid
        LocationDto location,
        @NotNull
        @PositiveOrZero
        int passwordNumber,
        @NotNull
        boolean bullTv,
        @NotNull
        boolean wasItSold) {
}
