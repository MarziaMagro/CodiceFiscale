package com.example.cf_api.controller;

import cf.api.CittadinoApi;
import cf.model.CittadinoInputDto;
import cf.model.CittadinoOutputDto;
import com.example.cf_api.entity.CittadinoEntity;
import com.example.cf_api.service.CittadinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CittadinoController implements CittadinoApi {

    @Autowired
    CittadinoService cittadinoService;

    @Override
    public ResponseEntity<CittadinoOutputDto> getCittadinoByCodiceFiscale(CittadinoInputDto cittadinoInputDto) {
        String codiceFiscale = cittadinoInputDto.getCodiceFiscale();
        CittadinoEntity cittadinoEntity = cittadinoService.getInfosByCodiceFiscale(codiceFiscale);
        CittadinoOutputDto cittadinoOutputDto = new CittadinoOutputDto();
        cittadinoOutputDto.setBirthDate(cittadinoEntity.getBirthDate());
        cittadinoOutputDto.setAge(cittadinoEntity.getAge());
        return ResponseEntity.ok(cittadinoOutputDto);
    }
}
