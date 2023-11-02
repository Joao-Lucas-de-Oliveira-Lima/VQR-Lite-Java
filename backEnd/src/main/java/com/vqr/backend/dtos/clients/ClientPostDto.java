package com.vqr.backend.dtos.clients;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClientPostDto(
        @NotBlank @Pattern(regexp = "^.*[a-zA-Z].*$") String name,
        @Email String email,
        String phoneNumber) { 
}