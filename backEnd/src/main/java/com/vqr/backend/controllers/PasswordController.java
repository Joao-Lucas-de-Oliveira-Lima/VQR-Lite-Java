package com.vqr.backend.controllers;

import com.vqr.backend.dtos.password.PasswordPatchDto;
import com.vqr.backend.dtos.password.PasswordPostDto;
import com.vqr.backend.dtos.password.PasswordResponseDto;
import com.vqr.backend.services.PasswordService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/passwords")
public class PasswordController {
    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    //For testing
    @PostMapping
    public ResponseEntity<PasswordResponseDto> saveNewPassword(
            @Valid @RequestBody PasswordPostDto passwordData) {
        PasswordResponseDto result = passwordService.saveNewPassword(passwordData);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping()
    public ResponseEntity<List<PasswordResponseDto>> findEventPasswords(
            @RequestParam(name = "eventId") UUID eventId,
            @RequestParam(name = "wasItSold", required = false) Boolean wasItSold) {
        Optional<List<PasswordResponseDto>> result = passwordService.findEventPasswords(eventId, wasItSold);
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PasswordResponseDto> modifyPassword(
            @PathVariable(name = "id") UUID id,
            @RequestBody @Valid PasswordPatchDto passwordData){
        Optional<PasswordResponseDto> result = passwordService.modifyPassword(id, passwordData);
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }
}
