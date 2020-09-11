package br.com.fiap.escola.domain;

public class Aluno {

	private Integer id;
	private Integer rm;
	private String nome;
	private Boolean ativo;
	private Double nota1;
	private Double nota2;
	
	
	public Aluno(Integer rm, String nome) {
		this.rm = rm;
		this.nome = nome;
		this.ativo = true;
		this.nota1 = 0.0;
		this.nota2 = 0.0;
	}


	public Aluno(Integer rm, String nome, Boolean ativo, Double nota1, Double nota2) {
		this(rm, nome);
		this.ativo = ativo;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}


	public Aluno(Integer id, Integer rm, String nome, Boolean ativo, Double nota1, Double nota2) {
		this(rm, nome, ativo, nota1, nota2);
		this.id = id;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}


	public Double getNota1() {
		return nota1;
	}


	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}


	public Double getNota2() {
		return nota2;
	}


	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}


	public Integer getRm() {
		return rm;
	}


	public String getNome() {
		return nome;
	}
	
	public Double getMedia() {
		return (nota1 + nota2) / 2;
	}
	
	@Override
	public String toString() {
		return String.format("Aluno: {\n\trm: %s,\n\tnome: %s,\n\tativo: %s,\n\t"
				+ "nota 1: %.1f,\n\tnota 2: %.1f,\n\tmedia: %.1f\n}", rm, nome, ativo ? "sim" : "não", 
						nota1, nota2, getMedia());
	}
	
	
}
