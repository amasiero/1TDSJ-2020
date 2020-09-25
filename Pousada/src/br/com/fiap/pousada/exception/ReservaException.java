package br.com.fiap.pousada.exception;

public class ReservaException extends Exception {

	private static final long serialVersionUID = 7119956877011757839L;

	public ReservaException() {
		this("Ocorreu um erro no sistema.");
	}
	
	public ReservaException(String msg) {
		super(msg);
	}
}
