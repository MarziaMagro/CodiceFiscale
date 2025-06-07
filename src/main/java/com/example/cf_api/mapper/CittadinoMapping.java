package com.example.cf_api.mapper;

import cf.model.CittadinoInputDto;
import cf.model.CittadinoOutputDto;
import com.example.cf_api.entity.CittadinoEntity;

public class CittadinoMapping {

    public static CittadinoOutputDto convToDto(CittadinoEntity cittadinoEntity) {
        CittadinoOutputDto cittadinoDto = new CittadinoOutputDto();
        cittadinoDto.setAge(cittadinoEntity.getAge());
        return cittadinoDto;
    }

    public static CittadinoEntity convToEntity(CittadinoInputDto cittadinoDto) {
        CittadinoEntity cittadinoEntity = new CittadinoEntity();
        cittadinoEntity.setCodiceFiscale(cittadinoDto.getCodiceFiscale());
        return cittadinoEntity;
    }
}