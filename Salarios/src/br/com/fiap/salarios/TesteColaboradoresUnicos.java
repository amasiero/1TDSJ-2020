package br.com.fiap.salarios;

import br.com.fiap.salarios.model.*;

public class TesteColaboradoresUnicos {

	public static void main(String[] args) {
		Colaborador[] colaboradores = {
				new Horista("Jos� Dijalbas", "Inform�tica", 150),
				new Horista("Gustavo", "Inform�tica", 150),
				new Horista("Gabriel", "Inform�tica", 150),
				new Horista("Mois�s", "Inform�tica", 150),
				new Horista("Pedro", "Inform�tica", 150),
				new Mensalista("Luana", "Gest�o", 15000),
				new Mensalista("Jo�o Carlos", "Gest�o", 15000),
				new Mensalista("Alexandre", "Gest�o", 15000),
				new Mensalista("Maur�cio", "Gest�o", 15000)
		};
		
		for(int i = 0; i < colaboradores.length; i++) {
			Colaborador colaborador = colaboradores[i];
			
			if(colaborador instanceof Horista) {
				((Horista) colaborador).setHorasTrabalhadas(220);
			}
			
			System.out.println(colaborador.calculaSalario());
		}
	}
}
