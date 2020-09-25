package br.com.fiap.pousada.domain;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.pousada.dao.ReservaDAO;
import br.com.fiap.pousada.exception.ReservaException;
import br.com.fiap.pousada.validation.ReservaValidator;

public class Pousada {
	
	private List<Reserva> reservas;
	
	public Pousada() {
		this.reservas = new ArrayList<>();
	}
	
	public void atualiza() throws ClassNotFoundException, SQLException, IOException {
		List<Reserva> reservas = new ReservaDAO().consultaTodas();
		if(reservas != null) this.reservas = reservas;
	}
	
	public void efetuaReserva(Reserva reserva) throws ReservaException, ClassNotFoundException, SQLException, IOException {
		ReservaValidator.validaMaxQuartos(reservas, reserva.getQuarto().getCategoria());
		ReservaValidator.validaDataEntrada(reserva);
		ReservaValidator.validaDataSaida(reserva);
		ReservaValidator.validaQuantidadePessoas(reserva);
		
		Reserva reservaEfetuada = new ReservaDAO().salva(reserva);
		if(reservaEfetuada !=  null) reservas.add(reservaEfetuada);
	}
	
	public List<Reserva> consultaReservas() {
		return reservas;
	}

}
