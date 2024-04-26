package com.example.PersonalFinanceManagement.management.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface AdjustingTime {

     static LocalDate StartOfMonth(LocalDate l) {

        String local = l.toString();
        int year = Integer.parseInt(local.split("-")[0]);
        int month = Integer.parseInt(local.split("-")[1]);
        return LocalDate.of(year, month, 1);
    }

     static LocalDate EndOfMonth(LocalDate l) {
        return StartOfMonth(l.plusMonths(1)).minusDays(1);
    }
    private static LocalDate starYear(LocalDate l) {

        String local = l.toString();
        int ano = Integer.parseInt(local.split("-")[0]);
        return LocalDate.of(ano, 1, 1);
    }

    private static LocalDate endYear(LocalDate l) {
        String local = l.toString();
        int ano = Integer.parseInt(local.split("-")[0]);
        return LocalDate.of(ano, 12, 31);

    }
    static String FormattingDate(LocalDate l) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        return  l.format(formatter);
    }
}
