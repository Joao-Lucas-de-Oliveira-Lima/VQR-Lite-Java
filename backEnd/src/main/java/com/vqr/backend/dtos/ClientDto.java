package com.vqr.backend.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClientDto(@NotBlank String name) { }
