package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.password.PasswordPostDto;
import com.vqr.backend.dtos.password.PasswordResponseDto;
import com.vqr.backend.models.EventModel;
import com.vqr.backend.models.Location;
import com.vqr.backend.models.PasswordModel;
import com.vqr.backend.repositories.EventRepository;
import com.vqr.backend.repositories.PasswordRepository;
import com.vqr.backend.services.PasswordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PasswordServiceImpl implements PasswordService {
    private final PasswordRepository passwordRepository;
    private final EventRepository eventRepository;

    public PasswordServiceImpl(PasswordRepository passwordRepository, EventRepository eventRepository) {
        this.passwordRepository = passwordRepository;
        this.eventRepository = eventRepository;
    }

    //todo: decouple knowledge from the model attributes
    public PasswordResponseDto saveNewPassword(PasswordPostDto passwordData) {
        PasswordModel passwordToSave = new PasswordModel(
                passwordData.puller(),
                passwordData.pullerHorse(),
                passwordData.grabber(),
                passwordData.grabberHorse(),
                new Location(
                        passwordData.location().county(),
                        passwordData.location().state()
                ),
                passwordData.passwordNumber(),
                passwordData.bullTv(),
                passwordData.wasItSold());
        return passwordRepository.save(passwordToSave).convertToResponseDto();
    }

    public List<PasswordModel> createListOfEmptyPasswordsForStartingAnEvent(
            int numberOfPasswordsToBeCreated,
            EventModel eventToBeUsed) {
        List<PasswordModel> passwords = new ArrayList<>();
        for (int quantity = 1; quantity <= numberOfPasswordsToBeCreated; quantity++) {
            passwords.add(passwordRepository.save(new PasswordModel(quantity, eventToBeUsed)));
        }
        return passwords;
    }

    public Optional<List<PasswordResponseDto>> findEventPasswords(UUID eventId){
        Optional<EventModel> eventToBeFound = eventRepository.findById(eventId);
        if(eventToBeFound.isEmpty()){
            return Optional.empty();
        }
        List<PasswordModel> passwords = passwordRepository.findAllByEventToBeUsed(eventToBeFound.get());
        List<PasswordResponseDto> passwordsDto = new ArrayList<>();
        passwords.forEach(password -> {
            passwordsDto.add(password.convertToResponseDto());
        });
        return Optional.of(passwordsDto);
    }
}
