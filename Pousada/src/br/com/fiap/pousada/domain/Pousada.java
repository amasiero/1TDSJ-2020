package br.com.fiap.pousada.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.pousada.dao.ReservaDAO;
import br.com.fiap.pousada.exception.PousadaException;
import br.com.fiap.pousada.validation.QuartoValidator;

public class Pousada {
	
	private List<Reserva> reservas;
	
	public Pousada() {
		this.reservas = new ArrayList<>();
	}
	
	public void atualiza() throws ClassNotFoundException, SQLException {
		List<Reserva> reservas = new ReservaDAO().consultaTodas();
		if(reservas != null) this.reservas = reservas;
	}
	
	public void efetuaReserva(Reserva reserva) throws Exception {
		if(QuartoValidator
				.validaMaxQuartos(
						this.consultaPorCategoria(reserva.getQuarto().getCategoria()), 
						reserva.getQuarto().getCategoria()
				)
		) throw new PousadaException(
					String.format("Quartos na categoria %s não estão disponíveis no momento", 
							reserva.getQuarto().getCategoria())
		);
		
		Reserva reservaEfetuada = new ReservaDAO().salva(reserva);
		if(reservaEfetuada !=  null) reservas.add(reservaEfetuada);
	}
	
	public List<Reserva> consultaReservas() {
		return reservas;
	}
	
	public List<Quarto> consultaPorCategoria(Categoria categoria) {
		return reservas.stream()
				.filter(reserva -> reserva.getQuarto().getCategoria() == categoria)
				.map(Reserva::getQuarto)
				.collect(Collectors.toList());
	}

}
