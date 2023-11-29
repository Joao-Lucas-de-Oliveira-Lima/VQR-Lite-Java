package com.vqr.backend.models;

import com.vqr.backend.dtos.Finance.FinanceResponseDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Finances")
//todo passwords sold by users
public class FinanceModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "finance_id")
    private UUID id;
    private int numberOfInitialPasswords;
    private int totalPasswordsAdded;
    private int totalNumberOfPasswords;
    private int totalPasswordsSold;
    private int totalOfBullsTv;
    private BigDecimal totalMoney;
    private BigDecimal totalAmountRaisedViaPix;
    private BigDecimal totalAmountOfCashCollected;
    private BigDecimal totalAmountOfMoneyCollectedViaCard;
    @OneToOne
    @JoinColumn(name = "event_id")
    private EventModel event;

    public FinanceModel(EventModel event) {
        this.numberOfInitialPasswords = event.getNumberOfInitialPasswords();
        this.totalPasswordsAdded = 0;
        this.totalNumberOfPasswords = event.getNumberOfTotalPasswords();
        this.totalPasswordsSold = 0;
        this.totalOfBullsTv = 0;
        this.totalMoney = new BigDecimal(0);
        this.totalAmountRaisedViaPix = new BigDecimal(0);
        this.totalAmountOfCashCollected = new BigDecimal(0);
        this.totalAmountOfMoneyCollectedViaCard = new BigDecimal(0);
        this.event = event;
    }

    public FinanceResponseDto convertToResponseDto() {
        return new FinanceResponseDto(
                this.id,
                this.numberOfInitialPasswords,
                this.totalPasswordsAdded,
                this.totalNumberOfPasswords,
                this.totalPasswordsSold,
                this.totalOfBullsTv,
                this.totalMoney,
                this.totalAmountRaisedViaPix,
                this.totalAmountOfCashCollected,
                this.totalAmountOfMoneyCollectedViaCard
        );
    }
}
