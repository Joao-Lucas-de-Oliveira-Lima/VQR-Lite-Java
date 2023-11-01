package com.vqr.backend.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AddressModel {
    private String municipality;
    private String state;

    public AddressModel(String municipality, String state) {
        this.municipality = municipality;
        this.state = state;
    }
}
