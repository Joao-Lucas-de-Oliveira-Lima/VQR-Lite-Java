package com.vqr.backend.dtos.impl;

import com.vqr.backend.dtos.ClientDto;
import jakarta.validation.constraints.NotBlank;

public record ClientDtoImpl(@NotBlank String name) implements ClientDto { }
