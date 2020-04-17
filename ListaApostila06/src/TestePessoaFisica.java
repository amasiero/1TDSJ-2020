
public class TestePessoaFisica {
	public static void main(String[] args) {
		Veiculo veiculo = new Veiculo("Ford Mustang", "3.0 Turbo", 2, false);
		Imovel imovel = new Imovel(100, "Av. Lins de Vasconcelos", 350000, true);
		PessoaFisica pessoa = new PessoaFisica("Joao Jose", 11122233344l);
		pessoa.setImovel(imovel);
		pessoa.setVeiculo(veiculo);
	}
}
