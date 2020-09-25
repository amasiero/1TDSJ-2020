package br.com.fiap.salarios;

import br.com.fiap.salarios.model.*;

public class TesteColaboradores {

	public static void main(String[] args) {
		Colaborador manuel = new Horista("Manuel", "Informática", 150);
		// Casting ou Coerção
		((Horista) manuel).setHorasTrabalhadas(220);
		
		Horista[] horistas = {
			new Horista("José Dijalbas", "Informática", 150),
			new Horista("Gustavo", "Informática", 150),
			new Horista("Gabriel", "Informática", 150),
			new Horista("Moisés", "Informática", 150),
			new Horista("Pedro", "Informática", 150)
		};
		
		Mensalista[] mensalistas = {
				new Mensalista("Luana", "Gestão", 15000),
				new Mensalista("João Carlos", "Gestão", 15000),
				new Mensalista("Alexandre", "Gestão", 15000),
				new Mensalista("Maurício", "Gestão", 15000)
		};
		
		double somaHorista = 0.0;
		double somaMensalista = 0.0;
		
		for(int i = 0; i < horistas.length; i++) {
			horistas[i].setHorasTrabalhadas(220);
			somaHorista += horistas[i].calculaSalario();
		}
		
		for(int i = 0; i < mensalistas.length; i++) 
			somaMensalista += mensalistas[i].calculaSalario();
		
		
		System.out.printf("O total da folha de pagamento é: R$ %.2f.\n", (somaHorista + somaMensalista));
	}
}
