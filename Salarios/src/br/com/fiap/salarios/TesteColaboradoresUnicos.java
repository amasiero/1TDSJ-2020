package br.com.fiap.salarios;

import br.com.fiap.salarios.model.*;

public class TesteColaboradoresUnicos {

	public static void main(String[] args) {
		Colaborador[] colaboradores = {
				new Horista("José Dijalbas", "Informática", 150),
				new Horista("Gustavo", "Informática", 150),
				new Horista("Gabriel", "Informática", 150),
				new Horista("Moisés", "Informática", 150),
				new Horista("Pedro", "Informática", 150),
				new Mensalista("Luana", "Gestão", 15000),
				new Mensalista("João Carlos", "Gestão", 15000),
				new Mensalista("Alexandre", "Gestão", 15000),
				new Mensalista("Maurício", "Gestão", 15000)
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
