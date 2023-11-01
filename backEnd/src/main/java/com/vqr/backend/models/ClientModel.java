package com.vqr.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "Clients")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ClientModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String email;
    private String phoneNumber;

    //todo:relação com a tabela eventos
}
