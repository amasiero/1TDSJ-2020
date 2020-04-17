
public class Veiculo {

	private String modelo;
	private String motor;
	private int qtdPortas;
	private boolean zero;
	
	public Veiculo(String modelo, String motor, int qtdPortas, boolean zero) {
		this.modelo = modelo;
		this.motor = motor;
		this.qtdPortas = qtdPortas;
		this.zero = zero;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public int getQtdPortas() {
		return qtdPortas;
	}

	public void setQtdPortas(int qtdPortas) {
		this.qtdPortas = qtdPortas;
	}

	public boolean isZero() {
		return zero;
	}

	public void setZero(boolean zero) {
		this.zero = zero;
	}
	
}
