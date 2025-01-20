package com.vqr.backend.dtos.location;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record LocationDto(
        @NotBlank
        @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿÇç\\s.-]+$")
        String county,
        @NotBlank
        @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿÇç\\s.-]+$")
        String state) {
}
