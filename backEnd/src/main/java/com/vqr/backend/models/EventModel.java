package com.vqr.backend.models;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Events")
@Getter
@Setter
@EqualsAndHashCode
//@NoArgsConstructor
@ToString
public class EventModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private int numberOfInitialPasswords;
    private int numberOfTotalPasswords;
    private LocalDateTime beginDateTime;
    @Embedded
    private Location location;

    public EventModel(String name, int numberOfInitialEventPasswords, Location location) {
        this.name = name;
        this.numberOfInitialPasswords = numberOfInitialEventPasswords;
        this.numberOfTotalPasswords = numberOfInitialEventPasswords;
        this.beginDateTime = beginDateTime;
        this.location = location;
    }

    public EventModel() {
        this.location = new Location();
    }
}
