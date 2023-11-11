package com.vqr.backend.dtos.event;

import com.vqr.backend.dtos.location.LocationDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record EventPostDto(
        @NotBlank
        @Pattern(regexp = ".*[a-zA-Z]+.*")
        String name,
        @NotNull
        @Positive
        int numberOfInitialPasswords,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
        @FutureOrPresent
        LocalDateTime beginDateTime,
        @NotNull
        @Valid
        LocationDto location) {
}
