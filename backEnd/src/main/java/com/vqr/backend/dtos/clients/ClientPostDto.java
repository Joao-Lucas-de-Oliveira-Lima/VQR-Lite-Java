package com.vqr.backend.dtos.clients;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClientPostDto(
        @NotBlank(message = "name not given")
        @Pattern(regexp = ".*[a-zA-Z]+.*")
        String name,
        @Email
        String email,
        @Pattern(regexp = "^([0-9]{2})([0-9]{9})$")
        String phoneNumber) { 
}