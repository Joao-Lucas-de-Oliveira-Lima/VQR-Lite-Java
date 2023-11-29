package com.vqr.backend.services;

import com.vqr.backend.dtos.password.PasswordPatchDto;
import com.vqr.backend.dtos.password.PasswordPostDto;
import com.vqr.backend.dtos.password.PasswordResponseDto;
import com.vqr.backend.models.EventModel;
import com.vqr.backend.models.PasswordModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PasswordService {
    //PasswordResponseDto saveNewPassword(PasswordPostDto passwordData);

    List<PasswordModel> createListOfEmptyPasswordsForStartingAnEvent(
            int numberOfPasswordsToBeCreated,
            EventModel eventToBeUsed);

    Boolean increaseTheNumberOfAvailableEventPasswords(
            int numberOfPasswordsToBeAdded,
            EventModel eventToBeUsed);

    Optional<PasswordResponseDto> modifyPassword(UUID id, PasswordPatchDto passwordData);

    Optional<List<PasswordResponseDto>> findEventPasswords(UUID eventId, Boolean wasItSold);
}
