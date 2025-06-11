package com.example.cf_api.controller;

import cf.api.CittadinoApi;
import cf.model.CittadinoDto;
import com.example.cf_api.service.CittadinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CittadinoController implements CittadinoApi {

    private final CittadinoService cittadinoService;
    //dependency injection
    public CittadinoController(CittadinoService cittadinoService) {
        this.cittadinoService = cittadinoService;
    }

    @Override
    public ResponseEntity<CittadinoDto> getCittadinoByCodiceFiscale(String codiceFiscale) {
        CittadinoDto cittadinoDto = cittadinoService.getFromCodiceFiscale(codiceFiscale);
        return ResponseEntity.ok(cittadinoDto);
    }
}
