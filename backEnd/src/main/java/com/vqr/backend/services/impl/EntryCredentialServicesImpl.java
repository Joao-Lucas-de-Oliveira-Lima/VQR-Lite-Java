package com.vqr.backend.services.impl;

import com.vqr.backend.repositories.EntryCredentialRepository;
import com.vqr.backend.services.EntryCredentialServices;
import org.springframework.stereotype.Service;

@Service
public class EntryCredentialServicesImpl implements EntryCredentialServices {
    private final EntryCredentialRepository entryCredentialRepository;

    public EntryCredentialServicesImpl(EntryCredentialRepository entryCredentialRepository){
        this.entryCredentialRepository = entryCredentialRepository;
    }
}
