package br.com.fiap.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumeroUtils {
	
	public static List<Integer> filtra(List<Integer> numeros, Predicado regra) { // Stream API
		return numeros.stream()
				.filter(regra::valida)
				.collect(Collectors.toList());
	}
	
	public static List<Integer> filtraComStreamAPI(List<Integer> numeros, Predicado regra) { // Stream API
		return numeros.stream()
				.filter(numero -> regra.valida(numero))
				.collect(Collectors.toList());
	}

	public static List<Integer> filtraComForEach(List<Integer> numeros, Predicado regra) {
		List<Integer> filtrado = new ArrayList<>();
		numeros.forEach(numero -> {
			if(regra.valida(numero)) {
				filtrado.add(numero);
			}
		});
		return filtrado;
	}
		
	public static List<Integer> pares(List<Integer> numeros) {
		List<Integer> pares = new ArrayList<>();
		for(Integer numero: numeros) {
			if(numero % 2 == 0) {
				pares.add(numero);
			}
		}
		return pares;
	}
	
	public static List<Integer> impares(List<Integer> numeros) {
		List<Integer> impares = new ArrayList<>();
		for(Integer numero: numeros) {
			if(numero % 2 == 1) {
				impares.add(numero);
			}
		}
		return impares;
	}
 
}
