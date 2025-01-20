package com.vqr.backend.dtos.location;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record LocationPatchDto(
        @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿÇç\\s.-]+$")
        String county,
        @Pattern(regexp = "^[a-zA-ZÀ-ÖØ-öø-ÿÇç\\s.-]+$")
        String state) {
}
