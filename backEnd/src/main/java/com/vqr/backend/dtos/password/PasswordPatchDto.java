package com.vqr.backend.dtos.password;

import com.vqr.backend.dtos.location.LocationPatchDto;
import jakarta.validation.Valid;

import java.util.Optional;

public record PasswordPatchDto(
        String puller,
        String pullerHorse,
        String grabber,
        String grabberHorse,
        @Valid
        LocationPatchDto location,
        Optional<Boolean> bullTv,
        Optional<Boolean> wasItSold) { }
