package com.vqr.backend.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

//Expressão regular provisória
public record ClientDto(
        @NotBlank @Pattern(regexp = "^([a-zA-Z].+)$") String name,
        @Email String email,
        String phoneNumber) { }
