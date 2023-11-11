package com.vqr.backend.models;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class Location {
    private String county;
    private String state;

    public Location(String county, String state) {
        this.county = county;
        this.state = state;
    }
}