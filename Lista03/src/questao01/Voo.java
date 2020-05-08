package questao01;

import java.time.LocalDate;

public class Voo {
	protected int numero;
	protected LocalDate data;
	protected boolean[] lugares;
	
	public Voo(int numero, LocalDate data) {
		this.numero = numero;
		this.data = data;
		this.lugares = new boolean[100];
		System.out.println("Construtor Publico");
	}
	
	protected Voo(int numero, LocalDate data, boolean[] lugares) {
		this(numero, data);
		this.lugares = lugares;
		System.out.println("Construtor Protegido");
	}
	
	public int proximoLivre() {
		int posicao = 0;
		while(posicao < this.lugares.length) {
			if(!this.lugares[posicao]) {
				return posicao + 1;
			}
			posicao++;
		}
		return -1;
	}
	
	public boolean verifica(int lugar) {
		return this.lugares[lugar - 1];
	}
	
	public boolean ocupa(int lugar) {
		if(!this.verifica(lugar)) { return false; }
		return (this.lugares[lugar - 1] = true);
	}
	
	public int vagas() {
		int vagas = 0;
		for(boolean lugar : this.lugares) {
			if(!lugar) {
				vagas++;
			}
		}
		return vagas;
	}
	
	public int getVoo() {
		return this.numero;
	}
	
	public LocalDate getData() {
		return this.data;
	}
	 
	public Voo clone() {
		return new Voo(this.numero, this.data, this.lugares);
	}
	
}
