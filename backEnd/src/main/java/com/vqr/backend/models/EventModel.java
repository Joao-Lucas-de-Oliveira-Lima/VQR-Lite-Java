package com.vqr.backend.models;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Events")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class EventModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private int numberOfInitialEventPasswords;
    private int numberOfTotalEventPasswords;
    private LocalDateTime dataAndTime;
    @Embedded
    private Locality locality;
}
