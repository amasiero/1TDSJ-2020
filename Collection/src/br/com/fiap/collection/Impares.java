package br.com.fiap.collection;

public class Impares implements Predicado {

	@Override
	public boolean valida(Integer numero) {
		return numero % 2 == 1;
	}

}
