package br.com.fiap.collection;

enum Categoria {
	APARTAMENTO, // 0
	VIP; // 1
}

public class TesteCategoria {
	
	public static void main(String[] args) {
		Categoria a = Categoria.APARTAMENTO;
		
		if(a == Categoria.VIP) {
			System.out.println(Categoria.VIP);
		} else {
			System.out.println(Categoria.APARTAMENTO);
		}
	}
	
}
