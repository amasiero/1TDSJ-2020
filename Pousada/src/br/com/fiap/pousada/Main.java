package br.com.fiap.pousada;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.pousada.dao.QuartoDAO;
import br.com.fiap.pousada.domain.Categoria;
import br.com.fiap.pousada.domain.Pousada;
import br.com.fiap.pousada.domain.Quarto;
import br.com.fiap.pousada.domain.Reserva;
import br.com.fiap.pousada.exception.ReservaException;
import br.com.fiap.pousada.helper.DateHelper;

public class Main {

	public static void main(String[] args) {
		Pousada pousada = new Pousada();
		try(Scanner scan = new Scanner(System.in)) {
			pousada.atualiza();
			int opcao = 0;
			do {
				menu();
				System.out.print("> ");
				opcao = scan.nextInt();
				
				// A partir do Java 14
				switch(opcao) {
					case 1 -> cadastraQuarto(scan);
					case 2 -> cadastraReserva(scan, pousada);
					case 3 -> consultaQuartos();
					case 4 -> consultaReservas(pousada);
				}
				
				System.out.println("\n\n");
			} while(opcao != 0);
			
			System.out.println("#--- Programa finalizado com suscesso ---#");
		} catch(ClassNotFoundException | IOException | SQLException e) {
			System.err.println(e.getMessage());
		}

	}
	
	private static void cadastraReserva(Scanner scan, Pousada pousada) {
		System.out.println("\n#--> Cadastro de Reserva");
		
		System.out.print("\nInforme o numero do quarto: > ");
		Integer numero = scan.nextInt();
		scan.nextLine();
		
		System.out.print("\nInforme a data de entrada: > ");
		LocalDate dataEntrada = DateHelper.toDate(scan.nextLine());
		
		System.out.print("\nInforme a data de saida: > ");
		LocalDate dataSaida = DateHelper.toDate(scan.nextLine());
		
		System.out.print("\nInforme o numero de pessoas: > ");
		Integer qtdePessoas = scan.nextInt();
		
		try {
			Quarto quarto = new QuartoDAO().consultaPorNumero(numero);
			
			if(quarto == null) {
				System.err.println("Quarto informado nao existe.");
				return;
			}
			
			Reserva reserva = new Reserva(quarto, dataEntrada, dataSaida, qtdePessoas);
			pousada.efetuaReserva(reserva);
			
		} catch(ReservaException | ClassNotFoundException | IOException | SQLException e) {
			System.err.println(e.getClass().getName() + " - " + e.getMessage());
		}
		
		System.out.println("\nReserva cadastrada com sucesso. #-->");
	}
	
	private static void consultaReservas(Pousada pousada) {
		System.out.println("\n#--> Consulta Reservas Realizadas\n");
		List<Reserva> reservas = pousada.consultaReservas();
		reservas.forEach(System.out::println);	
		System.out.println("\nConsulta realizada com sucesso. #-->");
	}

	private static void consultaQuartos() {
		System.out.println("\n#--> Consulta Quartos Cadastrados\n");
		try {
			List<Quarto> quartos = new QuartoDAO().consultaTodos();
			quartos.forEach(System.out::println);
		} catch(IOException | SQLException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("\nConsulta realizada com sucesso. #-->");
	}

	private static void cadastraQuarto(Scanner scan) {
		System.out.println("\n#--> Cadastro de Quarto");
		
		System.out.print("\nInforme o numero do quarto: > ");
		Integer numero = scan.nextInt();
		
		System.out.println("\nEscolha a categoria do quarto.");
		System.out.print("Digite: 1 - VIP | 2 - Apartamento > ");
		Categoria categoria = scan.nextInt() == 1 ? Categoria.VIP : Categoria.APARTAMENTO;
		
		System.out.print("\nInforme a capacidade maxima de pessoas: > ");
		Integer maxPessoas = scan.nextInt();
		
		System.out.print("\nInforme o valor da diaria: > ");
		Double valorDiaria = scan.nextDouble();
		
		Quarto quarto = new Quarto(numero, categoria, maxPessoas, valorDiaria);

		try {
			new QuartoDAO().salva(quarto);
		} catch(IOException | SQLException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("\nQuarto cadastrado com sucesso. #-->");
	}

	private static void menu() {
		System.out.println("|-----------------------------|");
		System.out.println("|          POUSADA            |");
		System.out.println("|                             |");
		System.out.println("| Digite a opcao desejada:    |");
		System.out.println("| 1 - Cadastrar quarto        |");
		System.out.println("| 2 - Cadastrar reserva       |");
		System.out.println("| 3 - Consultar quartos       |");
		System.out.println("| 4 - Consultar reservas      |");
		System.out.println("| 0 - Sair do sistema         |");
		System.out.println("|-----------------------------|");
	}

}



/**
	-- Teste do Enum
	System.out.println(Categoria.APARTAMENTO.name()); 
	System.out.println(Categoria.APARTAMENTO);
	System.out.println(Categoria.APARTAMENTO.ordinal());
	System.out.println(Categoria.APARTAMENTO.getValue());
	
	Quarto quarto = new Quarto(10, Categoria.APARTAMENTO, 3, 150.);
	
	if(quarto.getCategoria() == Categoria.APARTAMENTO) {
		System.out.println(quarto);
	}
*/

