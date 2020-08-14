package br.com.fiap.collection;

import java.util.List;

public class TesteNumeros {
	public static void main(String[] args) {
		List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		Predicado par = numero -> numero % 2 == 0;
		Predicado impar = numero -> numero % 2 == 1;
		Predicado multiplosTres = numero -> numero % 3 == 0;
		
		System.out.println(NumeroUtils.filtra(numeros, par));
		System.out.println(NumeroUtils.filtra(numeros, impar));
		System.out.println(NumeroUtils.filtra(numeros, multiplosTres));
	}
}
