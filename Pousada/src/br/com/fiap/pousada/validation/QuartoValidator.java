package br.com.fiap.pousada.validation;

import java.util.List;

import br.com.fiap.pousada.domain.Categoria;
import br.com.fiap.pousada.domain.Quarto;

public class QuartoValidator {

	private static final int MAX_VIPS = 5;
	private static final int MAX_APARTAMENTOS = 10;

	public static boolean validaMaxQuartos(List<Quarto> quartos, Categoria categoria) {
		if (Categoria.VIP == categoria) {
			return quartos.size() > MAX_VIPS;
		}
		return quartos.size() > MAX_APARTAMENTOS;
	}

}
