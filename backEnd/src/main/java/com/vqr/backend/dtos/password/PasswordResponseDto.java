package com.vqr.backend.dtos.password;

import com.vqr.backend.dtos.location.LocationDto;

import java.util.UUID;

public record PasswordResponseDto(
        UUID id,
        String puller,
        String pullerHorse,
        String grabber,
        String grabberHorse,
        LocationDto location,
        int passwordNumber,
        boolean bullTv,
        boolean wasItSold) {
}
