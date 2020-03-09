class Pessoa {
	String nome;
	String rg;
	int cpf;
	String endereco;
	String dataNascimento;

	void exibeDadosCadastrais() {
		System.out.printf("Nome: %s\nRG: %s\nCPF: %d\nData de Nascimento: %s\n",
			nome, rg, cpf, dataNascimento);
	}

	String informeEndereco() {
		return endereco;
	}
}