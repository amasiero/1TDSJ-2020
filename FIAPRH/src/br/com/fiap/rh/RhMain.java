package br.com.fiap.rh;

import br.com.fiap.rh.model.Gerente;
import br.com.fiap.rh.model.Vendedor;

public class RhMain {

	public static void main(String[] args) {
		
		Vendedor v = new Vendedor("Gustavo", 12345, 4500.0);
		v.setTotalVendas(10000);
		System.out.println(v.calculaSalario());
		
		Vendedor v2 = new Vendedor("Martin", 12346, 4500.0);
		v2.setTotalVendas(12000);
		System.out.println(v2.calculaSalario());
		
		Gerente g = new Gerente("Pedro", 23456, 15000.0);
		g.adicionaVendedor(v);
		g.adicionaVendedor(v2);
		System.out.println(g.calculaSalario());
		
	}

}
