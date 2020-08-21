package br.com.fiap.todo;

import java.sql.*;
import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		
		try {
			// Registrando a classe na memória do programa
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Conexao com o banco de dados
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"system", "system");
			
			System.out.println("Conectado com sucesso!");
			
			// Criando o console para as declarações de SQL
			Statement stmt = conn.createStatement();
			
			// Inserir nova tarefa
			stmt.executeUpdate("insert into tb_tarefa(id, descricao, data_limite) " + 
					"values (sq_tarefa.nextval, 'Dar comida para Gloria Maria',"
					+ " to_date('21/08/2020', 'dd/mm/yyyy'))");
			
			// Atualizar uma tarefa
			stmt.executeUpdate("update tb_tarefa set feita = 1 where descricao like '%comida%'");
			
			// Excluir uma tarefa
			stmt.executeUpdate("delete from tb_tarefa where id = 2");
			
			// Consultar as tarefas no banco
			ResultSet rs = stmt.executeQuery("select * from tb_tarefa");
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String descricao = rs.getString("descricao");
				LocalDate dataLimite = rs.getDate("data_limite").toLocalDate();
				Boolean feita = rs.getBoolean("feita");
				
				System.out.printf("Tarefa: { %s, %s, %s, %s }\n",
						id, descricao, dataLimite, feita);
			}
			
			// Fechar conexao com o banco de dados
			conn.close();
			
		} catch(ClassNotFoundException e) {
			System.err.printf("O driver JDBC não foi encontrado: %s", e.getMessage());
		} catch(SQLException e) {
			System.err.println("Não foi possível conectar com o banco de dados");
			System.err.println(e.getMessage());
		}
	}

}
