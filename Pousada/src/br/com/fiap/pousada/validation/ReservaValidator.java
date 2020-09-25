package br.com.fiap.pousada.validation;

import java.util.List;

import br.com.fiap.pousada.domain.Categoria;
import br.com.fiap.pousada.domain.Reserva;
import br.com.fiap.pousada.exception.ReservaException;
import br.com.fiap.pousada.helper.DateHelper;

public class ReservaValidator {

	private static final int MAX_VIPS = 5;
	private static final int MAX_APARTAMENTOS = 10;

	public static void validaMaxQuartos(List<Reserva> reservas, Categoria categoria) throws ReservaException {
		Long qtdeQuartos = quantidadeQuartosNaCategoria(reservas, categoria);
		if(qtdeQuartos > MAX_VIPS || qtdeQuartos > MAX_APARTAMENTOS) {
			throw new ReservaException(
					String.format("N�o existe disponibilidade de quartos para a categoria %s.", categoria)
			);
		}
	}
	
	private static Long quantidadeQuartosNaCategoria(List<Reserva> reservas, Categoria categoria) {
		return reservas.stream()
				.filter(reserva -> reserva.getQuarto().getCategoria() == categoria)
				.count();
	}
	
	public static void validaDataEntrada(Reserva reserva) throws ReservaException {
		if(DateHelper.ehAnteriorAtual(reserva.getDataEntrada())) {
			throw new ReservaException("A data de entrada deve ser igual ou maior que a atual.");
		}
	}

	public static void validaDataSaida(Reserva reserva) throws ReservaException {
		if(DateHelper.ehMaiorQueEntrada(reserva.getDataEntrada(), reserva.getDataSaida())) {
			throw new ReservaException("A data de saida deve ser no m�nimo dois dias ap�s a entrada.");
		}
	}

	public static void validaQuantidadePessoas(Reserva reserva) throws ReservaException {
		if(superouACapacidadeDoQuarto(reserva)) {
			String msg = String.format("O m�ximo de pessoas permitidas nesse quarto � %s pessoas.", 
					reserva.getQuarto().getMaxPessoas());
			throw new ReservaException(msg);
		}
	}

	private static boolean superouACapacidadeDoQuarto(Reserva reserva) {
		return reserva.getQtdePessoas().compareTo(reserva.getQuarto().getMaxPessoas()) > 0;
	}
}
