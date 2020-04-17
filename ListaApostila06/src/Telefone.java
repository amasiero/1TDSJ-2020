
public class Telefone {
	private int numero;
	private int ramal;
	private int operadora;
	private int ddd;
	
	public Telefone(int numero, int ramal, int operadora, int ddd) {
		this.numero = numero;
		this.ramal = ramal;
		this.operadora = operadora;
		this.ddd = ddd;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getRamal() {
		return ramal;
	}

	public void setRamal(int ramal) {
		this.ramal = ramal;
	}

	public int getOperadora() {
		return operadora;
	}

	public void setOperadora(int operadora) {
		this.operadora = operadora;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	
	
}
