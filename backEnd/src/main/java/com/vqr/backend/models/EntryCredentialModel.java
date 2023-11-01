package com.vqr.backend.models;

import com.vqr.backend.enums.PaymentEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "EntryCredentials")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class EntryCredentialModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true)
    private int entryCredentialNumber;
    private boolean isAvailable;
    private String tailPuller;
    private String tailPullerHorse;
    private String helper;
    private String helperHorse;
    @Embedded
    private AddressModel address;
    private boolean hasBullTv;
    private BigDecimal entryCredentialCost;
    private PaymentEnum paymentMethod;

    public EntryCredentialModel(int entryCredentialNumber) {
        this.entryCredentialNumber = entryCredentialNumber;
        this.isAvailable = false;
        this.tailPuller = "None";
        this.tailPullerHorse = "None";
        this.helper = "None";
        this.helperHorse = "None";
        this.address = new AddressModel("None", "None");
        this.hasBullTv = false;
        this.entryCredentialCost = new BigDecimal("00.00");
        this.paymentMethod = PaymentEnum.NONE;

    }
}
