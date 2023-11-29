package com.vqr.backend.models;


import com.vqr.backend.dtos.client.ClientResponseDto;
import com.vqr.backend.dtos.event.EventResponseDto;
import com.vqr.backend.dtos.location.LocationDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    @Column(name = "event_id")
    private UUID id;
    private String name;
    private int numberOfInitialPasswords;
    private int numberOfTotalPasswords;
    private int totalNumberOfTimesMorePasswordsWereAdded;
    private LocalDateTime beginDateTime;
    @Embedded
    private Location location;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel eventOwner;
    @OneToMany(mappedBy = "eventToBeUsed")
    private List<PasswordModel> passwords;
    @OneToOne(mappedBy = "event")
    FinanceModel finance;

    public EventModel(
            String name,
            int numberOfInitialEventPasswords,
            LocalDateTime beginDateTime,
            Location location, ClientModel eventOwner) {
        this.name = name;
        this.numberOfInitialPasswords = numberOfInitialEventPasswords;
        this.numberOfTotalPasswords = numberOfInitialEventPasswords;
        this.totalNumberOfTimesMorePasswordsWereAdded = 0;
        this.beginDateTime = beginDateTime;
        this.location = location;
        this.eventOwner = eventOwner;
    }

    public EventModel() {
        this.location = new Location();
    }

    //todo create response dto for location
    public EventResponseDto convertToResponseDto(){
        return new EventResponseDto(
                this.id,
                this.name,
                this.numberOfInitialPasswords,
                this.numberOfTotalPasswords,
                this.totalNumberOfTimesMorePasswordsWereAdded,
                this.beginDateTime,
                new LocationDto(
                        this.location.getCounty(),
                        this.location.getState()
                ),
                this.eventOwner.convertToResponseDto()
        );
    }
}
