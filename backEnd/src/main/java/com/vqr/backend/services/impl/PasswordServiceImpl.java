package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.password.PasswordPatchDto;
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

    public Boolean increaseTheNumberOfAvailableEventPasswords(
            int numberOfPasswordsToBeAdded,
            EventModel eventToBeUsed) {
        for (int quantity = eventToBeUsed.getNumberOfTotalPasswords() + 1;
             quantity <= eventToBeUsed.getNumberOfTotalPasswords() + numberOfPasswordsToBeAdded;
             quantity++) {
            passwordRepository.save(new PasswordModel(quantity, eventToBeUsed));
        }
        return true;
    }

    public Optional<List<PasswordResponseDto>> findEventPasswords(UUID eventId, Boolean wasItSold) {
        Optional<EventModel> eventToBeFound = eventRepository.findById(eventId);
        if (eventToBeFound.isEmpty()) {
            return Optional.empty();
        }
        List<PasswordModel> passwords = new ArrayList<>();
        if(wasItSold != null){
            if(!wasItSold){
                passwords = passwordRepository.findAllByEventToBeUsedAndWasItSoldIsFalseOrderByPasswordNumberAsc(eventToBeFound.get());
            }else{
                passwords = passwordRepository.findAllByEventToBeUsedAndWasItSoldIsTrueOrderByPasswordNumberAsc(eventToBeFound.get());
            }
        }else{
            passwords = passwordRepository.findAllByEventToBeUsedOrderByPasswordNumberAsc(eventToBeFound.get());
        }
        List<PasswordResponseDto> passwordsDto = new ArrayList<>();
        passwords.forEach(password -> {
            passwordsDto.add(password.convertToResponseDto());
        });
        return Optional.of(passwordsDto);
    }

    public Optional<PasswordResponseDto> modifyPassword(UUID id, PasswordPatchDto passwordData){
        Optional<PasswordModel> passwordToBeModified = passwordRepository.findById(id);
        if(passwordToBeModified.isEmpty()){
            return Optional.empty();
        }
        if(passwordData.puller() != null){
            passwordToBeModified.get().setPuller(passwordData.puller());
        }
        if(passwordData.pullerHorse() != null){
            passwordToBeModified.get().setPullerHorse(passwordData.pullerHorse());
        }
        if(passwordData.grabber() != null){
            passwordToBeModified.get().setGrabber(passwordData.grabber());
        }
        if(passwordData.grabberHorse() != null){
            passwordToBeModified.get().setGrabberHorse(passwordData.grabberHorse());
        }
        if(passwordData.location() != null){
            if(passwordData.location().county() != null){
                passwordToBeModified.get().getLocation().setCounty(passwordData.location().county());
            }
            if(passwordData.location().state() != null){
                passwordToBeModified.get().getLocation().setState(passwordData.location().state());
            }
        }
        if(passwordData.bullTv().isPresent()){
            passwordToBeModified.get().setBullTv(passwordData.bullTv().get());
        }
        if(passwordData.wasItSold().isPresent()){
            passwordToBeModified.get().setWasItSold(passwordData.wasItSold().get());
        }
        return Optional.of(passwordRepository.save(passwordToBeModified.get()).convertToResponseDto());
    }
}
