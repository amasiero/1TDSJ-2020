
public class Modelo {
	
	private String nome;
	private double peso;
	private double altura;
	
	public Modelo(String nome, double peso, double altura) {
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double imc() {
		return this.peso / (this.altura * this.altura);
	}
	
	
}
