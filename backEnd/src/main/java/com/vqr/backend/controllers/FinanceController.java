package com.vqr.backend.controllers;

import com.vqr.backend.dtos.Finance.FinanceResponseDto;
import com.vqr.backend.services.FinanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/finances")
public class FinanceController {
    private final FinanceService financeService;

    public FinanceController(FinanceService financeService){
        this.financeService = financeService;
    }

    @GetMapping
    public ResponseEntity<FinanceResponseDto> findEventFinances(
            @RequestParam(name = "eventId") UUID eventId){
        Optional<FinanceResponseDto> result = financeService.findEventFinances(eventId);
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
    }
}
