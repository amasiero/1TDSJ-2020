package br.com.fiap.concessionaria;

public class Principal {
	public static void main(String[] args) {
		Automovel a = new Automovel("Fiat", "Palio", 1500.);
		Automovel b = new Automovel("Fiat", "Toro",  6000.);
		Automovel c = new Automovel("VW", "Fusca", 45000.);
		Automovel d = new Automovel("VW", "Gol", 1500.);
		Automovel e = new Automovel("Ford", "Edge", 6000.);
		Automovel f = new Automovel("Ford", "Ka", 2500.);
		
		Concessionaria concessionaria =  new Concessionaria();
		concessionaria.adicionaVeiculo(a);
		concessionaria.adicionaVeiculo(b);
		concessionaria.adicionaVeiculo(c);
		concessionaria.adicionaVeiculo(d);
		concessionaria.adicionaVeiculo(e);
		concessionaria.adicionaVeiculo(f);
		
		concessionaria.vendaVeiculo(new Automovel("Fiat", "Palio", 1500.));
		
		concessionaria.consultaEstoqueVeiculos().forEach(System.out::println);
		
		System.out.println(concessionaria.somaEstoque());
		System.out.println(concessionaria.consultaVeiculo(new Automovel("Ford", "Ka", 2500.)));
		
		
	}
}
