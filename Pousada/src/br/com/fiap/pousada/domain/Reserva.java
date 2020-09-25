package br.com.fiap.pousada.domain;

import java.time.LocalDate;

import br.com.fiap.pousada.helper.DateHelper;

public class Reserva {
	
	private Long id;
	private Quarto quarto;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private Integer qtdePessoas;
	
	public Reserva(Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida, Integer qtdePessoas) {
		this.quarto = quarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.qtdePessoas = qtdePessoas;
	}
	
	public Reserva(Long id, Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida, Integer qtdePessoas) {
		this(quarto, dataEntrada, dataSaida, qtdePessoas);
		this.id = id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public Quarto getQuarto() {
		return quarto;
	}
	
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	
	public LocalDate getDataSaida() {
		return dataSaida;
	}
	
	public Integer getQtdePessoas() {
		return qtdePessoas;
	}
	
	@Override
	public String toString() {
		return String.format("Reserva #%s -> {\n\tQuarto nro: %s, \n\tData de entrada: %s, "
				+ "\n\tData de saída: %s, \n\tQtde. Pessoas: %s \n}", id, quarto.getNumero(), 
				DateHelper.toText(dataEntrada), DateHelper.toText(dataSaida), qtdePessoas);
	}

}
