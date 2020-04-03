
public class SelecaoModelo {
	private Modelo pessoa1;
	private Modelo pessoa2;
	private int pontos1;
	private int pontos2;
	
	public SelecaoModelo(Modelo pessoa1, Modelo pessoa2) {
		this.pessoa1 = pessoa1;
		this.pessoa2 = pessoa2;
		this.pontos1 = 0;
		this.pontos2 = 0;
	}

	public Modelo getPessoa1() {
		return pessoa1;
	}

	public void setPessoa1(Modelo pessoa1) {
		this.pessoa1 = pessoa1;
	}

	public Modelo getPessoa2() {
		return pessoa2;
	}

	public void setPessoa2(Modelo pessoa2) {
		this.pessoa2 = pessoa2;
	}

	public int getPontos1() {
		return pontos1;
	}

	public void setPontos1(int pontos1) {
		this.pontos1 = pontos1;
	}

	public int getPontos2() {
		return pontos2;
	}

	public void setPontos2(int pontos2) {
		this.pontos2 = pontos2;
	}
	
	public Modelo menorIMC() {
		if(pessoa1.imc() < pessoa2.imc()) {
			this.pontos1++;
			return this.pessoa1;
		} else {
			this.pontos2++;
			return this.pessoa2;
		}
	}
	
	public Modelo maisAlta() {
		if(pessoa1.getAltura() > pessoa2.getAltura()) {
			this.pontos1++;
			return this.pessoa1;
		} else {
			this.pontos2++;
			return this.pessoa2;
		}
	}
	
	public Modelo maisMagra() {
		if(pessoa1.getPeso() < pessoa2.getPeso()) {
			this.pontos1++;
			return this.pessoa1;
		} else {
			this.pontos2++;
			return this.pessoa2;
		}
	}
	
	public Modelo melhorPerfil() {
		if(this.pontos1 > this.pontos2) {
			return this.pessoa1;
		} else {
			return this.pessoa2;
		}
	}
	
}
