package com.example.cf_api.service;

import com.example.cf_api.entity.CittadinoEntity;
import com.example.cf_api.repository.CittadinoRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CittadinoService {

    private CittadinoRepo cittadinoRepo;

    //GET By codice fiscale
    public CittadinoEntity getInfosByCodiceFiscale(String codiceFiscale) {
        CittadinoEntity cittadinoEntity = cittadinoRepo.findByCodiceFiscale(codiceFiscale)
                .orElseThrow(() -> new EntityNotFoundException("Cittadino non trovato"));
        return cittadinoEntity;
    }
}
