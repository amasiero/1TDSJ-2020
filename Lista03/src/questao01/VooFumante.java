package questao01;

import java.time.LocalDate;

public class VooFumante extends Voo {
	
	private int numeroVagas;
	private int cadeirasParaFumantes;
	
	public VooFumante(int numero, LocalDate data, int numeroVagas, int cadeirasParaFumantes) {
		super(numero, data, new boolean[numeroVagas]);
		this.numeroVagas = numeroVagas;
		this.cadeirasParaFumantes = cadeirasParaFumantes;
	}
	
	public int maxVagas() {
		return this.numeroVagas;
	}
	
	public int cadeirasFumantes() {
		return this.cadeirasParaFumantes;
	}
	
	public char tipo(int lugar) {
		int inicioFumantes = this.numeroVagas - this.cadeirasParaFumantes;
		int posicaoLugar = lugar - 1;
		return posicaoLugar >= inicioFumantes ? 'F' : 'N';
	}

}
