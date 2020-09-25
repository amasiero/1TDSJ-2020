package br.com.fiap.escola.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.escola.domain.Aluno;
import br.com.fiap.escola.exception.CadastroAlunoException;
import br.com.fiap.escola.exception.ConexaoException;

public class AlunoDAO {
	
	private Connection conn;
	
	public void conecta() throws ConexaoException {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new ConexaoException("Não foi possível conectar ao banco de dados.");
		}
	}
	
	public Aluno salva(Aluno aluno) throws CadastroAlunoException {
		try {
			conecta();
			String sqlConsultaId = "SELECT SQ_ALUNO.NEXTVAL AS ID FROM DUAL";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlConsultaId);
			if(rs.next()) aluno.setId(rs.getInt("ID"));
			
			String sqlInsert = "INSERT INTO TB_ALUNO(ID, RM, NOME, ATIVO, NOTA1, NOTA2) "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sqlInsert);
			
			pStmt.setInt(1, aluno.getId());
			pStmt.setInt(2, aluno.getRm());
			pStmt.setString(3, aluno.getNome());
			pStmt.setBoolean(4, aluno.getAtivo());
			pStmt.setDouble(5, aluno.getNota1());
			pStmt.setDouble(6, aluno.getNota2());
			
			pStmt.executeUpdate();
			
			return aluno;
		} catch(ConexaoException | SQLException e) {
			System.out.println(String.format("%s: %s", e.getClass().getName(), e.getMessage()));
			throw new CadastroAlunoException("Não foi possível efetuar o cadastro do aluno.");
		} finally {
			desconecta();
		}
	}
	
	public void atualiza(Aluno aluno) throws CadastroAlunoException {
		try {
			conecta();
			
			String sql = "UPDATE TB_ALUNO SET RM=?, NOME=?, ATIVO=?, NOTA1=?, NOTA2=? WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, aluno.getRm());
			pStmt.setString(2, aluno.getNome());
			pStmt.setBoolean(3, aluno.getAtivo());
			pStmt.setDouble(4, aluno.getNota1());
			pStmt.setDouble(5, aluno.getNota2());
			pStmt.setInt(6, aluno.getId());
			
			pStmt.executeUpdate();			
			
		} catch(ConexaoException | SQLException e) {
			System.out.println(String.format("%s: %s", e.getClass().getName(), e.getMessage()));
			throw new CadastroAlunoException("Não foi possível atualizar o cadastro do aluno.");
		} finally {
			desconecta();
		}
	}
	
	public void exclui(Integer rm) throws CadastroAlunoException {
		try {
			conecta();
			
			String sql = "DELETE FROM TB_ALUNO WHERE RM = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, rm);
			pStmt.executeUpdate();			
			
		} catch(ConexaoException | SQLException e) {
			System.out.println(String.format("%s: %s", e.getClass().getName(), e.getMessage()));
			throw new CadastroAlunoException("Não foi possível excluir o cadastro do aluno.");
		} finally {
			desconecta();
		}
	}
	
	public List<Aluno> consultaTodos() throws CadastroAlunoException {
		try {
			conecta();
			List<Aluno> alunos = new ArrayList<>();
 			String sql = "SELECT * FROM TB_ALUNO";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();			
			
			while(rs.next()) {
				Integer id = rs.getInt("ID");
				Integer rm = rs.getInt("RM");
				String nome = rs.getString("NOME");
				Boolean ativo = rs.getBoolean("ATIVO");
				Double nota1 = rs.getDouble("NOTA1");
				Double nota2 = rs.getDouble("NOTA2");
				
				Aluno aluno = new Aluno(id, rm, nome, ativo, nota1, nota2);
				alunos.add(aluno);
			}
			
			return alunos;
		} catch(ConexaoException | SQLException e) {
			System.out.println(String.format("%s: %s", e.getClass().getName(), e.getMessage()));
			throw new CadastroAlunoException("Não foi possível recuperar os alunos do banco de dados.");
		} finally {
			desconecta();
		}
	}
	
	public Aluno consultaPorRm(Integer rm) throws CadastroAlunoException {
		try {
			conecta();
			String sql = "SELECT * FROM TB_ALUNO WHERE RM = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, rm);
			ResultSet rs = pStmt.executeQuery();			
			
			if(rs.next()) {
				Integer id = rs.getInt("ID");
				String nome = rs.getString("NOME");
				Boolean ativo = rs.getBoolean("ATIVO");
				Double nota1 = rs.getDouble("NOTA1");
				Double nota2 = rs.getDouble("NOTA2");
				
				return new Aluno(id, rm, nome, ativo, nota1, nota2);
			}
			
			return null;
		} catch(ConexaoException | SQLException e) {
			System.out.println(String.format("%s: %s", e.getClass().getName(), e.getMessage()));
			throw new CadastroAlunoException("Não foi possível recuperar os alunos do banco de dados.");
		} finally {
			desconecta();
		}
	}
	
	private void desconecta() {
		try {
			if(!conn.isClosed()) conn.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
