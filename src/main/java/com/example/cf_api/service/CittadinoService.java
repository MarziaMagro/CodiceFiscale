package com.example.cf_api.service;

import cf.model.CittadinoInputDto;
import com.example.cf_api.entity.CittadinoEntity;
import com.example.cf_api.mapper.CittadinoMapping;
import com.example.cf_api.repository.CittadinoRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CittadinoService {

    private CittadinoRepo cittadinoRepo;

    //Injection
    public CittadinoService(CittadinoRepo cittadinoRepo) {
        this.cittadinoRepo = cittadinoRepo;
    }

    //CREATE
    public CittadinoEntity createEntity(CittadinoInputDto cittadinoInputDto) {
        CittadinoEntity cittadinoEntity = CittadinoMapping.convToEntity(cittadinoInputDto);
        return cittadinoRepo.save(cittadinoEntity);
    }

    //GET By codice fiscale
    public CittadinoEntity getInfosByCodiceFiscale(String codiceFiscale) {
        CittadinoEntity cittadinoEntityCf = cittadinoRepo.findByCodiceFiscale(codiceFiscale)
                .orElseThrow(() -> new EntityNotFoundException("Cittadino non trovato"));
        return cittadinoEntityCf;
    }
}
