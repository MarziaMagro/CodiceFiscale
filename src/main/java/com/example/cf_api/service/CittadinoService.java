package com.example.cf_api.service;

import cf.model.CittadinoDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CittadinoService {

    //GET cittadino/codicefiscale

    public CittadinoDto getFromCodiceFiscale(String codiceFiscale) {
        CodiceFiscale cf = new CodiceFiscale(codiceFiscale);
        LocalDate birthDate = cf.getDateOfBirth();
        //Calcolo età
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        CittadinoDto cittadinoDto = new CittadinoDto();
        cittadinoDto.setBirthDate(birthDate);
        cittadinoDto.setAge(age);
        return cittadinoDto;
    }
}


