package com.example.cf_api.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CodiceFiscale {

    private LocalDate dateOfBirth;

    private static final Map<Character, Integer> months = new HashMap<>();

    static {
        months.put('A', 1);
        months.put('B', 2);
        months.put('C', 3);
        months.put('D', 4);
        months.put('E', 5);
        months.put('H', 6);
        months.put('L', 7);
        months.put('M', 8);
        months.put('P', 9);
        months.put('R', 10);
        months.put('S', 11);
        months.put('T', 12);
    }

    //CONTROLLO VALIDITA CODICE FISCALE
    public CodiceFiscale(String codiceFiscale) {
        if (codiceFiscale == null || codiceFiscale.length() != 16) {
            throw new IllegalArgumentException("Codice fiscale non valido");
        }
        this.dateOfBirth = extractDateOfBirth(codiceFiscale.substring(6, 11));
    }

    //METODO PER ESTRARRE LA DATA
    private LocalDate extractDateOfBirth(String code) {

        int yy = Integer.parseInt(code.substring(0, 2));
        int year;
        if (yy > 50) {
            year = 1900 + yy; // 51-99 -> 1951-1999
        } else {
            year = 2000 + yy; // 00-50 -> 2000-2050
        }

        char monthChar = code.charAt(2);
        if (!months.containsKey(monthChar)) {
            throw new IllegalArgumentException("Carattere mese non valido nel codice fiscale");
        }
        int month = months.get(monthChar);

        int dd = Integer.parseInt(code.substring(3, 5));
        if (dd > 40) {
            dd -= 40;
        }
        return LocalDate.of(year, month, dd);
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

}