package com.vqr.backend.dtos.events;

import com.vqr.backend.models.Locality;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventPostDto(
        @NotBlank
        @Pattern(regexp = ".*[a-zA-Z]+.*")
        String name,
        @NotNull
        @Positive
        int numberOfInitialEventPasswords,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd-hh-mm-ss")
        LocalDateTime dataAndTime,
        @NotBlank
        @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿÇç\\s.-]+$")
        String county,
        @NotBlank
        @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿÇç\\s.-]+$")
        String state) {
}
