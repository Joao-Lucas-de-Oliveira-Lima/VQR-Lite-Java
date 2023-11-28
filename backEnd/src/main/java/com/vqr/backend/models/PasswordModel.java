package com.vqr.backend.models;

import com.vqr.backend.dtos.location.LocationDto;
import com.vqr.backend.dtos.password.PasswordResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Passwords")
public class PasswordModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "password_id")
    private UUID id;
    private String puller;
    private String pullerHorse;
    private String grabber;
    private String grabberHorse;
    @Embedded
    private Location location;
    private int passwordNumber;
    private boolean bullTv;
    private boolean wasItSold;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventModel eventToBeUsed;

    public PasswordModel(
            String puller,
            String pullerHorse,
            String grabber,
            String grabberHorse,
            Location location,
            int passwordNumber,
            boolean bullTv,
            boolean wasItSold) {
        this.puller = puller;
        this.pullerHorse = pullerHorse;
        this.grabber = grabber;
        this.grabberHorse = grabberHorse;
        this.location = location;
        this.passwordNumber = passwordNumber;
        this.bullTv = bullTv;
        this.wasItSold = wasItSold;
    }

    public PasswordModel(int passwordNumber, EventModel eventToBeUsed) {
        this.puller = null;
        this.pullerHorse = null;
        this.grabber = null;
        this.grabberHorse = null;
        this.location = new Location(
                "none",
                "none"
        );
        this.passwordNumber = passwordNumber;
        this.bullTv = false;
        this.wasItSold = false;
        this.eventToBeUsed = eventToBeUsed;
    }

    public PasswordResponseDto convertToResponseDto() {
        return new PasswordResponseDto(
                this.id,
                this.puller,
                this.pullerHorse,
                this.grabber,
                this.grabberHorse,
                new LocationDto(
                        this.location.getCounty(),
                        this.location.getState()
                ),
                this.passwordNumber,
                this.bullTv,
                this.wasItSold
        );
    }
}
