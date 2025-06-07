package com.example.cf_api.mapper;

import cf.model.CittadinoFullOutputDto;
import cf.model.CittadinoInputDto;
import cf.model.CittadinoOutputCfDto;
import com.example.cf_api.entity.CittadinoEntity;

public class CittadinoMapping {

    public static CittadinoOutputCfDto convToCfDto(CittadinoEntity cittadinoEntity) {
        CittadinoOutputCfDto cittadinoCfDto = new CittadinoOutputCfDto();
        cittadinoCfDto.setAge(cittadinoEntity.getAge());
        cittadinoCfDto.setBirthDate(cittadinoEntity.getBirthDate());
        return cittadinoCfDto;
    }

    public static CittadinoFullOutputDto convToFullDto(CittadinoEntity cittadinoEntity) {
        CittadinoFullOutputDto cittadinoFullDto = new CittadinoFullOutputDto();
        cittadinoFullDto.setName(cittadinoEntity.getName());
        cittadinoFullDto.setSurname(cittadinoEntity.getSurname());
        cittadinoFullDto.setCodiceFiscale(cittadinoEntity.getCodiceFiscale());
        cittadinoFullDto.setBirthDate(cittadinoEntity.getBirthDate());
        cittadinoFullDto.setAge(cittadinoEntity.getAge());
        return cittadinoFullDto;
    }

    public static CittadinoEntity convToEntity(CittadinoInputDto cittadinoDto) {
        CittadinoEntity cittadinoEntity = new CittadinoEntity();
        cittadinoEntity.setCodiceFiscale(cittadinoDto.getCodiceFiscale());
        cittadinoEntity.setName(cittadinoDto.getName());
        cittadinoEntity.setSurname(cittadinoDto.getSurname());
        cittadinoEntity.setBirthDate(cittadinoDto.getBirthDate());
        cittadinoEntity.setAge(cittadinoDto.getAge());
        return cittadinoEntity;
    }
}