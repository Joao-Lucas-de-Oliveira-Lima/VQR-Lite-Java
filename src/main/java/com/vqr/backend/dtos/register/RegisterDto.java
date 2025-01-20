package com.vqr.backend.dtos.register;

import com.vqr.backend.enums.UserRole;

public record RegisterDto(String login, String password, UserRole role) {
}