package com.example.cf_api.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class CodiceFiscale {

    private String codiceFiscale;
    private LocalDate dateOfBirth;
    private String sex;

    // Mappatura Lettera --> Mese

    private static final Map<Character, Integer> meseCodici = new HashMap<>();

    static {
        meseCodici.put('A', 1);
        meseCodici.put('B', 2);
        meseCodici.put('C', 3);
        meseCodici.put('D', 4);
        meseCodici.put('E', 5);
        meseCodici.put('H', 6);
        meseCodici.put('L', 7);
        meseCodici.put('M', 8);
        meseCodici.put('P', 9);
        meseCodici.put('R', 10);
        meseCodici.put('S', 11);
        meseCodici.put('T', 12);
    }

    //CONTROLLO VALIDITA CODICE FISCALE

    public CodiceFiscale(String codiceFiscale) {
        if (codiceFiscale == null || codiceFiscale.length() != 16) {
            throw new IllegalArgumentException("Codice fiscale non valido");
        }
        this.codiceFiscale = codiceFiscale;
    }

    //METODO PER PRENDERE I DATI

    public void extractFromData() {
        dateOfBirth = extractDateOfBirth(codiceFiscale.substring(6, 11));
        sex = extractSex(codiceFiscale.substring(9, 11));
    }

    //METODO PER ESTRARRE LA DATA

    private LocalDate extractDateOfBirth(String code) {
        int yy = Integer.parseInt(code.substring(0, 2));
        char meseChar = code.charAt(2);
        int dd = Integer.parseInt(code.substring(3, 5));

        if (yy < 40) {
            yy += 2000;
        } else {
            yy += 1900;
        }

        int month = meseCodici.getOrDefault(meseChar, 1);
        if (dd > 40) {
            dd -= 40;
        }

        return LocalDate.of(yy, month, dd);
    }

    //CONTROLLO DEL GIORNO PER IL SESSO (F--> M +40)

    private String extractSex(String code) {
        int day = Integer.parseInt(code);
        return (day > 40) ? "F" : "M";
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getDateOfBirth() {
        return dateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}