package br.com.fiap.locadora.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DataUtils {

    public static LocalDate adicionaDias(LocalDate data, int dias) {
        return data.plusDays(dias);
    }

    public static LocalDate obterDataComDiferencaDias(int dias) {
        return adicionaDias(LocalDate.now(), dias);
    }

    public static LocalDate obterData(int dia, int mes, int ano) {
        return LocalDate.of(ano, mes, dia);
    }

    public static boolean ehMesmaData(LocalDate d1, LocalDate d2) {
        return d1.isEqual(d2);
    }

    public static boolean verificaDiaSemana(LocalDate data, DayOfWeek diaSemana) {
        return data.getDayOfWeek() == diaSemana;
    }
}
