package br.com.fiap.concessionaria;

import java.util.ArrayList;
import java.util.List;

public class Concessionaria {
	
	private List<Automovel> automoveis;
	
	public Concessionaria() {
		this.automoveis = new ArrayList<>();
	}
	
	public void adicionaVeiculo(Automovel automovel) {
		this.automoveis.add(automovel);
	}
	
	public void vendaVeiculo(Automovel automovel) {
		this.automoveis.remove(automovel);
	}
	
	public List<Automovel> consultaEstoqueVeiculos() {
		return this.automoveis;
	}
	
	public double somaEstoque() {
		return this.automoveis
				.stream() 
				.mapToDouble(Automovel::getPreco)
				.sum();
	}
	
	public boolean consultaVeiculo(Automovel automovel) {
		return this.automoveis
				.stream()
				.filter(automovel::equals)  //.filter(a -> automovel.equals(a))
				.count() == 1;
	}

}
