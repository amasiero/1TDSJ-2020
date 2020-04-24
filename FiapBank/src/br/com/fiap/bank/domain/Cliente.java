package br.com.fiap.bank.domain;

public class Cliente {
	private String nome;
	private int rm;
	private String turma;

	public Cliente(String nome, int rm, String turma) {
		this.nome = nome;
		this.rm = rm;
		this.turma = turma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

}
