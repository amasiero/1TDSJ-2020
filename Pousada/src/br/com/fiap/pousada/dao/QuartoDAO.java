package br.com.fiap.pousada.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.fiap.pousada.domain.Categoria;
import br.com.fiap.pousada.domain.Quarto;
import br.com.fiap.pousada.helper.FileHelper;

/**
 * 
 * <p>Essa é uma classe que contém os métodos de acesso ao banco de dados, para objetos do tipo
 * {@link br.com.fiap.pousada.domain.Quarto}.</p>
 * 
 *
 * 
 * @author Andrey Masiero
 * @version 1.0
 * 
 */
public class QuartoDAO {

	/**
	 * Objeto que recebe a conexão com o banco de dados.
	 * 
	 * @see java.sql.Connection
	 */
	Connection conn;
	
	private void conecta() throws IOException, SQLException {
		Properties props = FileHelper.loadProperties();
		this.conn = DriverManager.getConnection(
				props.getProperty("database.url"),
				props.getProperty("database.user"),
				props.getProperty("database.password")
		);
	}
	
	public List<Quarto> consultaTodos() throws IOException, SQLException {
		List<Quarto> quartos = new ArrayList<>();
		this.conecta();
		
		String sql = "select * from tb_quarto";
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			Integer numero = rs.getInt("numero");
			Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
			Integer maxPessoas = rs.getInt("max_pessoas");
			Double valorDiaria = rs.getDouble("valor_diaria");
			
			quartos.add(new Quarto(numero, categoria, maxPessoas, valorDiaria));
		}
		
		this.desconecta();
		return quartos.isEmpty() ? null : quartos;
	}
	
	/**
	 * <p>Método que retorna um quarto com base no número.</p>
	 * <p>Nele utiliza-se classes do pacote do java.sql. Para mais detalhes acesse 
	 * 	<a href="https://xkcd.com/2357/">aqui</a>.
	 * </p>
	 * 
	 * @param numero identificação do quarto da pousada
	 * @return em caso de existência retorna o objeto referente ao {@link br.com.fiap.pousada.domain.Quarto} da pousada
	 * @throws ClassNotFoundException quando não encontrar o driver de conexão
	 * @throws SQLException algum erro de sql
	 * 
	 * @see <a href="https://xkcd.com/1736/">TASK #1 - Criação do acesso aos dados</a>
	 * @since 1.0
	 */
	public Quarto consultaPorNumero(Integer numero) throws IOException, SQLException {
		Quarto quarto = null;
		this.conecta();
		
		String sql = String.format("select * from tb_quarto where numero = %s", numero);
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
			Integer maxPessoas = rs.getInt("max_pessoas");
			Double valorDiaria = rs.getDouble("valor_diaria");
			
			quarto = new Quarto(numero, categoria, maxPessoas, valorDiaria);
		}
		
		this.desconecta();
		return quarto;
	}
	
	public void salva(Quarto quarto) throws IOException, SQLException {
		this.conecta();
		String sql = String.format("insert into tb_quarto(numero, categoria, max_pessoas, valor_diaria) "
				+ "values(%s, '%s', %s, %s)", quarto.getNumero(), quarto.getCategoria(),
				quarto.getMaxPessoas(), quarto.getValorDiaria());
		Statement stmt = this.conn.createStatement();
		stmt.executeUpdate(sql);
		
		this.desconecta();
	}
	
	private void desconecta() throws SQLException {
		if(!conn.isClosed()) conn.close();
	}
}
