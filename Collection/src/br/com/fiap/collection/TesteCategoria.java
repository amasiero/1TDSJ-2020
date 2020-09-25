package br.com.fiap.collection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

enum Categoria {
	APARTAMENTO("Apartamento"), // 0
	VIP("Vip"); // 1
	
	private String nome;
	
	private Categoria(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}

public class TesteCategoria {
	
	public static void main(String[] args) {
		Categoria a = Categoria.APARTAMENTO;
		
		if(a == Categoria.VIP) {
			System.out.println(Categoria.VIP.getNome());
		} else {
			System.out.println(Categoria.APARTAMENTO.getNome());
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.now();
		LocalDate amanha = LocalDate.of(2020, 8, 29);
		
		LocalDate doisDiasAFrente = data.plusDays(2);
		
		System.out.println(formatter.format(data));
		System.out.println(formatter.format(doisDiasAFrente));
		System.out.println(formatter.format(amanha));
		System.out.println(amanha.isBefore(data));
		System.out.println(doisDiasAFrente.isAfter(amanha));
	}
	
}
