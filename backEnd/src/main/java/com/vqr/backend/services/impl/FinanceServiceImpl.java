package com.vqr.backend.services.impl;

import com.vqr.backend.dtos.Finance.FinanceResponseDto;
import com.vqr.backend.enums.PaymentMethod;
import com.vqr.backend.models.EventModel;
import com.vqr.backend.models.FinanceModel;
import com.vqr.backend.models.PasswordModel;
import com.vqr.backend.repositories.EventRepository;
import com.vqr.backend.repositories.FinanceRepository;
import com.vqr.backend.services.FinanceService;
import com.vqr.backend.services.PasswordService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FinanceServiceImpl implements FinanceService {
    private final FinanceRepository financeRepository;
    private final EventRepository eventRepository;
    private final PasswordService passwordService;

    public FinanceServiceImpl(
            FinanceRepository financeRepository,
            EventRepository eventRepository,
            PasswordService passwordService) {
        this.financeRepository = financeRepository;
        this.eventRepository = eventRepository;
        this.passwordService = passwordService;
    }

    public FinanceResponseDto createFinance(EventModel eventData) {
        FinanceModel financeToBeCreated = financeRepository.save(new FinanceModel(eventData));
        return financeToBeCreated.convertToResponseDto();
    }

    //todo improve algorithm efficiency
    public Optional<FinanceResponseDto> findEventFinances(UUID eventId) {
        Optional<EventModel> eventToBeFound = eventRepository.findById(eventId);
        if (eventToBeFound.isEmpty()) {
            return Optional.empty();
        }
        EventModel event = eventToBeFound.get();
        Optional<FinanceModel> financeToBeFound = financeRepository.findByEvent(event);
        if (financeToBeFound.isEmpty()) {
            return Optional.empty();
        }
        FinanceModel eventFinances = financeToBeFound.get();
        //Metrics
        eventFinances.setTotalNumberOfPasswords(
                event.getNumberOfTotalPasswords()
        );
        eventFinances.setTotalPasswordsAdded(
                event.getNumberOfTotalPasswords() - event.getNumberOfInitialPasswords()
        );
        Optional<List<PasswordModel>> eventPasswords = passwordService.findEventPasswordsAsModels(eventId);
        if (eventPasswords.isPresent()) {
            List<PasswordModel> eventPasswordsFound = eventPasswords.get();
            //Assistants
            int totalPasswordsSold = 0;
            int totalOfBullsTv = 0;
            BigDecimal totalMoney = new BigDecimal("0.0");
            BigDecimal totalAmountRaisedViaPix = new BigDecimal("0.0");
            BigDecimal totalAmountOfCashCollected = new BigDecimal("0.0");
            BigDecimal totalAmountOfMoneyCollectedViaCard = new BigDecimal("0.0");

            for (PasswordModel password : eventPasswordsFound) {
                if (password.isWasItSold()) {
                    totalPasswordsSold++;
                    totalMoney = BigDecimal.valueOf(totalMoney.doubleValue() + password.getPayment().getValue().doubleValue());
                    if (password.getPayment().getPaymentMethod() == PaymentMethod.CARD) {
                        totalAmountOfMoneyCollectedViaCard = BigDecimal.valueOf(totalAmountOfMoneyCollectedViaCard.doubleValue() + password.getPayment().getValue().doubleValue());
                    }
                    if (password.getPayment().getPaymentMethod() == PaymentMethod.CASH) {
                        totalAmountOfCashCollected = BigDecimal.valueOf(totalAmountOfCashCollected.doubleValue() + password.getPayment().getValue().doubleValue());
                    }
                    if(password.getPayment().getPaymentMethod() == PaymentMethod.PIX){
                        totalAmountRaisedViaPix = BigDecimal.valueOf(totalAmountRaisedViaPix.doubleValue() + password.getPayment().getValue().doubleValue());
                    }
                }
                if (password.isBullTv()) {
                    totalOfBullsTv++;
                }
            }
            eventFinances.setTotalPasswordsSold(
                    totalPasswordsSold
            );
            eventFinances.setTotalOfBullsTv(
                    totalOfBullsTv
            );
            eventFinances.setTotalMoney(
                    totalMoney
            );
            eventFinances.setTotalAmountOfCashCollected(
                    totalAmountOfCashCollected
            );
            eventFinances.setTotalAmountOfMoneyCollectedViaCard(
                    totalAmountOfMoneyCollectedViaCard
            );
            eventFinances.setTotalAmountRaisedViaPix(
                    totalAmountRaisedViaPix
            );
        }
        return Optional.of(eventFinances.convertToResponseDto());
    }
}
