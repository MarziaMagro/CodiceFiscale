package com.example.cf_api.controller;

import cf.api.CittadinoApi;
import cf.model.CittadinoDto;
import com.example.cf_api.service.CittadinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CittadinoController implements CittadinoApi {

    @Autowired
    CittadinoService cittadinoService;

    @Override
    public ResponseEntity<CittadinoDto> getCittadinoByCodiceFiscale(String codiceFiscale) {
        return null;
    }
}
