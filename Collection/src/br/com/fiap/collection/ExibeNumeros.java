package br.com.fiap.collection;

import java.util.function.Consumer;

public class ExibeNumeros implements Consumer<Integer>{

	@Override
	public void accept(Integer numero) {
		System.out.printf("%d ", numero);
	}

}
