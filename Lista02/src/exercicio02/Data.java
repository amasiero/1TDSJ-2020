package exercicio02;

import java.text.DecimalFormat;

public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano) {
		if((dia < 1 || dia > 31) || 
			(mes < 1 || mes > 12) ||
			ano < 1900) {
			this.dia = 01;
			this.mes = 01;
			this.ano = 0001;
		} else {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		if(dia > 0 && dia <= 31) {
			this.dia = dia;
		}
	}

	public int getMes() {
		return mes;
	}
	
	public String getMesExtenso() {
		switch(this.mes) {
			case 1:
				return "Janeiro";
			case 2:
				return "Fevereiro";
			case 3:
				return "Março";
			case 4:
				return "Abril";
			case 5: 
				return "Maio";
			case 6:
				return "Junho";
			case 7:
				return "Julho";
			case 8:
				return "Agosto";
			case 9:
				return "Setembro";
			case 10:
				return "Outubro";
			case 11:
				return "Novembro";
			case 12:
				return "Dezembro";
			default:
				return "Indefinido";	
		}
	}
	

	public void setMes(int mes) {
		if (mes > 0 && mes <= 12) {
			this.mes = mes;
		}
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		if (ano > 1900) {
			this.ano = ano;	
		}
	}
	
	public boolean isBissexto() {
		return ((this.ano % 4) == 0 || 
				(this.ano % 400) == 0) && 
				(this.ano % 100) != 0;
	}
	
	public Data clone() {
		return new Data(this.dia, this.mes, this.ano);
	}
	
	public int compara(Data data) {
		int diffAno = this.ano - data.getAno();
		int diffMes = this.mes - data.getMes();
		int diffDia = this.dia - data.getDia();
		// Early return functions (Design Pattern)
		if(diffAno > 0) { return 1; }
		if(diffAno < 0) { return -1; }
		if(diffMes > 0) { return 1; }
		if(diffMes < 0) { return -1; }
		if(diffDia > 0) { return 1;	}
		if(diffDia < 0) { return -1; }
		return 0;
	}
	
	public String toString() {
		DecimalFormat doisDigitos = new DecimalFormat("00");
		DecimalFormat quatroDigitos = new DecimalFormat("0000");
		return doisDigitos.format(dia) + "/" +
				doisDigitos.format(mes) + "/" +
				quatroDigitos.format(ano);
	}

}
