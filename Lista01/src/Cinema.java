
public class Cinema {
 
	private double precoIngresso;
	private Sala sala; // TODO posteriormente vira uma lista de salas
	
	public Cinema(Sala sala, double precoIngresso) {
		this.sala = sala;
		this.precoIngresso = precoIngresso;
	}

	public double getPrecoIngresso() {
		return precoIngresso;
	}

	public void setPrecoIngresso(double precoIngresso) {
		this.precoIngresso = precoIngresso;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public void vendeIngresso() {
		this.sala.ocuparLugar();
	}
	
	public double calculaFaturamento() {
		return this.sala.getLugaresOcupados() * this.precoIngresso;
	}
	
	public String finalizaSessao() {
		int lugaresOcupados = this.sala.getLugaresOcupados();
		double faturamento = this.calculaFaturamento();
		this.sala.esvaziar();
		return "A sessão teve " + lugaresOcupados + " participantes, " +
				"e obteve um faturamento de R$ " + faturamento;
	}
}
