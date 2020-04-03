import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
	
	private Veiculo veiculo;
	private Date entrada;
	private Date saida;
	private double valor;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private DecimalFormat formataMoeda = new DecimalFormat("R$ #0.00");
	
	public Ticket(Veiculo veiculo) {
		this.veiculo = veiculo;
		this.entrada = new Date();
		this.saida = null;
		this.valor = 0.;
	}
	
	public Ticket(Veiculo veiculo, Date entrada) {
		this(veiculo);
		this.entrada = entrada;
		this.saida = null;
		this.valor = 0.;
	}
	
	public Ticket(Veiculo veiculo, Date entrada, Date saida, double valor) {
		this(veiculo, entrada);
		this.saida = saida;
		this.valor = valor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getEntrada() {
		return entrada;
	}
	
	public String entradaParaTexto() {
		return sdf.format(entrada);
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}
	
	public String saidaParaTexto() {
		// Operador Ternario
		String saida = this.saida == null ? "estacionado" : sdf.format(this.saida);
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public double getValor() {
		return valor;
	}
	
	public String valorFormatado() {
		return formataMoeda.format(this.valor);
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void registraSaida() {
		this.saida = new Date();
		this.calculaValor();
	}

	private void calculaValor() {
		long diferenca = this.saida.getTime() - this.entrada.getTime();
		int horas = (int) (diferenca / 1000 / 60 / 60);
		int minutos = (int) (diferenca / 1000 / 60) - (horas * 60);
		
		this.valor = horas * 3.5;
		if(minutos > 0) {
			this.valor += 3.5; // this.valor = this.valor + 3.5
		}
	}
	
	public String toString() {
		return veiculo.toString() + " | " + this.entradaParaTexto() + " | " +
				this.saidaParaTexto() + " | " + this.valorFormatado();
	}

}
