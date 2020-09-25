package br.com.fiap.salarios;

import br.com.fiap.salarios.model.*;

public class TesteColaboradores {

	public static void main(String[] args) {
		Colaborador manuel = new Horista("Manuel", "Inform�tica", 150);
		// Casting ou Coer��o
		((Horista) manuel).setHorasTrabalhadas(220);
		
		Horista[] horistas = {
			new Horista("Jos� Dijalbas", "Inform�tica", 150),
			new Horista("Gustavo", "Inform�tica", 150),
			new Horista("Gabriel", "Inform�tica", 150),
			new Horista("Mois�s", "Inform�tica", 150),
			new Horista("Pedro", "Inform�tica", 150)
		};
		
		Mensalista[] mensalistas = {
				new Mensalista("Luana", "Gest�o", 15000),
				new Mensalista("Jo�o Carlos", "Gest�o", 15000),
				new Mensalista("Alexandre", "Gest�o", 15000),
				new Mensalista("Maur�cio", "Gest�o", 15000)
		};
		
		double somaHorista = 0.0;
		double somaMensalista = 0.0;
		
		for(int i = 0; i < horistas.length; i++) {
			horistas[i].setHorasTrabalhadas(220);
			somaHorista += horistas[i].calculaSalario();
		}
		
		for(int i = 0; i < mensalistas.length; i++) 
			somaMensalista += mensalistas[i].calculaSalario();
		
		
		System.out.printf("O total da folha de pagamento �: R$ %.2f.\n", (somaHorista + somaMensalista));
	}
}
