package com.vqr.backend.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
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
    //todo create response dto
}
