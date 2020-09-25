package br.com.fiap.escola.exception;

public class ConexaoException extends Exception {
	
	private static final long serialVersionUID = 774970421249613694L;

	public ConexaoException() {
		this("Erro de conexão.");
	}
	
	public ConexaoException(String msg) {
		super(msg);
	}

}
