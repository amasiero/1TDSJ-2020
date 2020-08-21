package br.com.fiap.concessionaria;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DemoDeclarativeProgramming {

	public static void main(String[] args) {
		List<Automovel> automoveis = getAutomoveis();
		
		// Filter
		List<Automovel> filtrado = automoveis
				.stream()
				.filter(automovel -> automovel.getPreco() < 6000)
				.collect(Collectors.toList());
		filtrado.forEach(System.out::println);
		
		// Sorted -> Ordenar a lista
		List<Automovel> ordenado = automoveis
				.stream()
				.sorted(Comparator
						.comparing(Automovel::getMarca)
						.thenComparing(Automovel::getPreco))
				.collect(Collectors.toList());
		ordenado.forEach(System.out::println);
		
		// All Match
		boolean allMatch = automoveis
				.stream()
				.allMatch(automovel -> automovel.getPreco() > 1000);
		System.out.println(allMatch);
		
		// Any Match
		boolean anyMatch = automoveis
				.stream()
				.anyMatch(automovel -> automovel.getPreco() > 10000);
		System.out.println(anyMatch);
		
		// None Match
		boolean noneMatch = automoveis
				.stream()
				.noneMatch(automovel -> automovel.getPreco() < 1000);
		System.out.println(noneMatch);
		
		// Max
		Optional<Automovel> max = automoveis
				.stream()
				.max(Comparator
						.comparing(Automovel::getPreco));
		
		if(max.isPresent()) System.out.println(max.get());
		max.ifPresent(System.out::println);
		
		
		// Min
		Optional<Automovel> min = automoveis
				.stream()
				.min(Comparator
						.comparing(Automovel::getPreco));
		
		if(min.isPresent()) System.out.println(min.get());
		min.ifPresent(System.out::println);
		
		// Group
		Map<String, List<Automovel>> agrupado = automoveis
				.stream()
				.collect(Collectors.groupingBy(Automovel::getMarca));
		
		agrupado.forEach((marca, autos) -> {
			System.out.println(marca);
			autos.forEach(System.out::println);
			System.out.println("-----------------------");
		});
		
		automoveis.stream()
			.filter(automovel -> automovel.getMarca().equals("Fiat"))
			.max(Comparator.comparing(Automovel::getPreco))
			.map(Automovel::getModelo)
			.ifPresent(System.out::println);
		
		
	}
	
	
	public static List<Automovel> getAutomoveis() {
		return List.of(
			new Automovel("Fiat", "Palio", 1500.),
			new Automovel("Ford", "Edge", 6000.),
			new Automovel("VW", "Fusca", 45000.),
			new Automovel("Fiat", "Toro",  6000.),
			new Automovel("VW", "Gol", 1500.),
			new Automovel("Fiat", "Freemont",  6500.),
			new Automovel("Ford", "Ka", 2500.)
		);
	}

}
