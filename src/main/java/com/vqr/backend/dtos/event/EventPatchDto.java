package com.vqr.backend.dtos.event;

import com.vqr.backend.dtos.location.LocationPatchDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Optional;

public record EventPatchDto(
        @Pattern(regexp = ".*[a-zA-Z]+.*")
        String name,
        Optional<Integer> numberOfPasswordsToBeAdded,
        @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
        @FutureOrPresent
        LocalDateTime beginDateTime,
        @Valid
        LocationPatchDto location) {
}
