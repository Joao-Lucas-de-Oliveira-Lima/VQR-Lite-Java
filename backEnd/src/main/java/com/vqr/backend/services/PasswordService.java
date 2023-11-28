package com.vqr.backend.services;

import com.vqr.backend.dtos.password.PasswordPostDto;
import com.vqr.backend.dtos.password.PasswordResponseDto;
import com.vqr.backend.models.EventModel;
import com.vqr.backend.models.PasswordModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PasswordService {
    PasswordResponseDto saveNewPassword(PasswordPostDto passwordData);

    List<PasswordModel> createListOfEmptyPasswordsForStartingAnEvent(
            int numberOfPasswordsToBeCreated,
            EventModel eventToBeUsed);

    Optional<List<PasswordResponseDto>> findEventPasswords(UUID eventId);
}
