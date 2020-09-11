package br.com.fiap.escola.exception;

public class CadastroAlunoException extends Exception {

	private static final long serialVersionUID = 4869886697471883291L;

	public CadastroAlunoException() {
		this("Erro durante o cadastro.");
	}
	
	public CadastroAlunoException(String msg) {
		super(msg);
	}
}
