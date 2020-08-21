package br.com.fiap.concessionaria;

import java.util.Objects;

public class Automovel {
	
	private String marca;
	private String modelo;
	private Double preco;
	
	public Automovel(String marca, String modelo, Double preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Double getPreco() {
		return preco;
	}
	
	@Override // Class Object
	public String toString() {
		return String.format("Automovel : { %s, %s, %s }", 
				marca, modelo, preco);
	}
	
	@Override // Class Object
	public boolean equals(Object o) {
		if(o instanceof Automovel) {
			Automovel automovel = (Automovel) o; // Casting ou Coerção
			return marca.equals(automovel.getMarca()) &&
					modelo.equals(automovel.getModelo()) &&
					preco.equals(automovel.getPreco());
		}
		return false;
	}
	
	@Override // Class Object
	public int hashCode() {
		return Objects.hash(marca, modelo, preco);
	}

}
