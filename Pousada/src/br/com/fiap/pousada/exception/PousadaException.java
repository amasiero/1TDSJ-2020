package br.com.fiap.pousada.exception;

public class PousadaException extends Exception {

	private static final long serialVersionUID = 7119956877011757839L;

	public PousadaException() {
		this("Ocorreu um erro no sistema.");
	}
	
	public PousadaException(String msg) {
		super(msg);
	}
}
