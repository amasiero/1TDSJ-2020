package br.com.fiap.patterns.dao.interfaces;

public class Test {
    public static void main(String[] args) {
        PersonDAO dao = new OraclePersonDAO();
        // Lógica com o banco de dados Oracle
        dao = new MySQLPersonDAO();
        // Lógica com o banco de dados MySQL
    }
}
