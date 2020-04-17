
public class Cliente {
	private String nome;
	private String email;
	private Telefone fone;
	private String endereco;
	
	public Cliente(String nome, String email, Telefone fone, String endereco) {
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefone getFone() {
		return fone;
	}

	public void setFone(Telefone fone) {
		this.fone = fone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
