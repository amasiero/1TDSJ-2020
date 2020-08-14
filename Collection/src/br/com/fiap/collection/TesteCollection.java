package br.com.fiap.collection;

import java.util.List;
import java.util.function.Consumer;

public class TesteCollection {

	public static void main(String[] args) {
		// int[] numeros = new int[10];
		// int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

//		List<Integer> numeros = new ArrayList<>();
//		numeros.add(1);
//		numeros.add(2);
//		numeros.add(3);
//		
//		System.out.println(numeros);
//		
//		numeros.remove(1);
//		
//		System.out.println(numeros);

		// Até o Java 10
		// List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// A partir do Java 11
		List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(numeros);
		System.out.println("--------------------------");

		// For tradicional --> Programação Imperativa
		for (int i = 0; i < numeros.size(); i++) {
			System.out.printf("%d ", numeros.get(i));
		}
		System.out.println("\n--------------------------");

		// Python # for numero in numeros
		// for each
		for (Integer numero : numeros) {
			System.out.printf("%d ", numero);
		}
		System.out.println("\n--------------------------");

		// Java 8 -> ForEach #JAVAPWR ==> Programação Declarativa
		ExibeNumeros exibe = new ExibeNumeros();
		numeros.forEach(exibe);
		System.out.println("\n--------------------------");

		numeros.forEach(new ExibeNumeros());
		System.out.println("\n--------------------------");

		// Classe Anonima
		Consumer<Integer> consumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer numero) {
				System.out.printf("%d ", numero);
			}
		};
		numeros.forEach(consumer);
		System.out.println("\n--------------------------");

		numeros.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer numero) {
				System.out.printf("%d ", numero);
			}
		});
		System.out.println("\n--------------------------");

		// Expressão Lambda
		numeros.forEach((Integer numero) -> {
			System.out.printf("%d ", numero);
		});
		System.out.println("\n--------------------------");

		numeros.forEach((numero) -> {
			System.out.printf("%d ", numero);
		});
		System.out.println("\n--------------------------");

		numeros.forEach(numero -> {
			System.out.printf("%d ", numero);
		});
		System.out.println("\n--------------------------");
					// lambda numero : print(numero) ==> PYTHON
		numeros.forEach(numero -> System.out.printf("%d ", numero));
		System.out.println("\n--------------------------");
		
		// Method Reference
		numeros.forEach(System.out::println);
		System.out.println("\n--------------------------");

	}

}
