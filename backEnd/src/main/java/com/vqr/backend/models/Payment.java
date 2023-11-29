package com.vqr.backend.models;

import com.vqr.backend.enums.PaymentMethod;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class Payment {
    private PaymentMethod paymentMethod;
    private BigDecimal value;

    public Payment(PaymentMethod paymentMethod, BigDecimal value){
        this.paymentMethod = paymentMethod;
        this.value = value;
    }
}
