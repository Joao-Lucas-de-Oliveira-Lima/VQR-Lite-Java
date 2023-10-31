package com.vqr.backend.models.impl;

import com.vqr.backend.models.ClientModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

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
public class ClientModelImpl implements ClientModel, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String cpf;
    
    //todo:relação com a tabela eventos
}
