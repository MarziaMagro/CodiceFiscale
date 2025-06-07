package com.example.cf_api.controller;

import cf.api.CittadinoApi;
import cf.model.CittadinoFullOutputDto;
import cf.model.CittadinoInputDto;
import cf.model.CittadinoOutputCfDto;
import com.example.cf_api.entity.CittadinoEntity;
import com.example.cf_api.mapper.CittadinoMapping;
import com.example.cf_api.service.CittadinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CittadinoController implements CittadinoApi {

    @Autowired
    CittadinoService cittadinoService;

    @Override
    public ResponseEntity<CittadinoFullOutputDto> createCittadino(CittadinoInputDto cittadinoInputDto) {
        CittadinoEntity entityToSave = cittadinoService.createEntity(cittadinoInputDto);
        CittadinoFullOutputDto cittadinoFullOutputDto = CittadinoMapping.convToFullDto(entityToSave);
        return ResponseEntity.ok(cittadinoFullOutputDto);
    }

    @Override
    public ResponseEntity<CittadinoOutputCfDto> getCittadinoByCodiceFiscale(String codiceFiscale) {
        CittadinoEntity cittadinoEntity = cittadinoService.getInfosByCodiceFiscale(codiceFiscale);
        CittadinoOutputCfDto dto = CittadinoMapping.convToCfDto(cittadinoEntity);
        return ResponseEntity.ok(dto);
    }


}
