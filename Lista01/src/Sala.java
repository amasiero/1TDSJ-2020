// Exercicio 01
public class Sala {

	private int capacidade;
	private int lugaresOcupados;
	
	public Sala(int capacidade) {
		this.capacidade = capacidade;
		this.lugaresOcupados = 0;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getLugaresOcupados() {
		return lugaresOcupados;
	}

	public void setLugaresOcupados(int lugaresOcupados) {
		this.lugaresOcupados = lugaresOcupados;
	}
	
	public boolean temLugar() {
		// TODO completar após aula de if da Fernanda
		return true;
	}
	
	public void ocuparLugar() {
		this.lugaresOcupados++;
	}
	
	public void esvaziar() {
		this.lugaresOcupados = 0;
	}
	
}
