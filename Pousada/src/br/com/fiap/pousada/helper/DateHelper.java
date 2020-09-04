package br.com.fiap.pousada.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static String toText(LocalDate date) {
		return formatter.format(date);
	}
	
	public static LocalDate toDate(String value) {
		return LocalDate.parse(value, formatter);
	}
}
